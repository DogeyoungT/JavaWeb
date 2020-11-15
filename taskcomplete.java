package controller;

import org.springframework.stereotype.Controller;
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
/**
 * Created by zhangzheyu on 2017/7/20.
 */
@Controller
public class taskcomplete {
    /**
     *
     * @param taskid
     * @param pub
     *
     *
     * @return
     */ @RequestMapping("/taskcomplete") // @RequestMapping 注解可以用指定的URL路径访问本控制层
    public String taskcomlete(@RequestParam("taskid") String taskid, @RequestParam("pub") String pub,
                              @CookieValue("cookieName") String cookieval, HttpServletRequest request)throws SQLException{
        Connection connection =new DBConnection().connection;
        Statement  statement =connection.createStatement();
        Statement statement1 =connection.createStatement();
        Statement statement2 =connection.createStatement();
        String sql = "";
        Calendar today = Calendar.getInstance();
        String currentDate = today.get(Calendar.YEAR)+"-"+(today.get(Calendar.MONTH)+1)+"-"+(today.get(Calendar.DAY_OF_MONTH));
        sql = String.format("select receiver from taskreceived where task_id  = '%s' and publisher = '%s'" ,taskid,pub);
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<String> receiver =new ArrayList<>();
        while (resultSet.next()){
            receiver.add(String.valueOf(resultSet.getString(1)));
        }
        for (String receivername: receiver) {
            String messagesql = String.format("insert into systemmessage values('%s','%s','%s','%s','%s','%s')",
                    taskid,"确认完成",receivername,pub,currentDate,"unread");
            statement1.execute(messagesql);
        }
        for(String receivername: receiver){
            String finishsql = String.format("insert into taskfinished values('%s','%s','%s','%s','%s')",taskid,null,null,currentDate,receivername);
            statement1.execute(finishsql);
        }
        String deletesql = String.format("delete from taskreceived where task_id = '%s' and publisher  = '%s'",taskid,pub);
        statement.execute(deletesql);
        connection.close();
        request.setAttribute("coco",cookieval);
        return "center";


    }

}
