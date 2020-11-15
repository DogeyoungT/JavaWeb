package controller;

/**
 * Created by zhangzheyu on 2017/7/25.
 */
import Model.MapUnit;
import Model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.sql.*;

public class TargetWordSearch {

     @RequestMapping("/TargetWordSearch")
    public String TargetWordSearch(@RequestParam("targetword") String targetword, Model model, @CookieValue("cookieName") String cookieval, HttpServletRequest request) throws SQLException{
         Connection connection = new DBConnection().connection;
         Statement statement= connection.createStatement();
         String sql  = "";
         sql = "select from task where task_title like '% "+targetword+"%' and  task_publisher != '"+MapUnit.findCurrUser(cookieval).getUserInfo().getAcc_username()
                 +"'and task_id not in (select task_id from taskreceived where receiver = '"+MapUnit.findCurrUser(cookieval).getUserInfo().getAcc_username()+"')";
         ResultSet resultSet= statement.executeQuery(sql);
         LinkedList<Task> taskList=new LinkedList<>();
         while(resultSet.next()){
             Task task =new Task();
             task.setTask_id(resultSet.getString("task_id"));
             task.setTask_p_date(resultSet.getString("task_p_date"));
             task.setTask_ddl(resultSet.getString("task_ddl"));
             task.setContact(resultSet.getString("contact"));
             task.setDetails(resultSet.getString("details"));
             task.setTask_address(resultSet.getString("task_address"));
             task.setTask_publisher(resultSet.getString("task_publisher"));
             task.setTask_title(resultSet.getString("task_title"));
             task.setTask_type(resultSet.getString("task_type"));
             task.setTask_request_people(resultSet.getString("task_request_people"));
             taskList.add(task);
         }
         MapUnit.map_set_Task_list(cookieval, taskList);
         model.addAttribute("userInfo", MapUnit.findCurrUser(cookieval).getUserInfo());
         request.setAttribute("coco", cookieval);
         return "main";
     }
}
