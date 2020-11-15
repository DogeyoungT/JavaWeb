package controller;

/**
 * Created by zhangzheyu on 2017/7/20.
 */
import Model.Message;
import Model.MapUnit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
@Controller
public class readMessage {
    /**
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     *
     *            任务标题
     * @param taskid
     * @param sender
     * @param receiver
     * @param details
     * @param date
     * @param model
     * */
    @RequestMapping("readMessage")
    public String readMessage(@RequestParam("taskid")String taskid,@RequestParam("sender")String sender,@RequestParam("receiver")String receiver,
                              @RequestParam("details") String details,@RequestParam("date")String date,@CookieValue("cookieName")String cookieval,
                              HttpServletRequest request,Model model)throws SQLException{

        Connection connection =new DBConnection().connection;
        Statement statement =connection.createStatement();
        String sql ="";
        sql = String.format("update systemmessage set is_read = 'read' where task_id = '%s' and message_sender = '%s'and message_receiver = '%s' and message_details = '%s' and message_date = '%s'",
                taskid,sender,receiver,details,date);
        statement.execute(sql);
        LinkedList<Message> linkedList = MapUnit.findCurrUser(cookieval).getMy_friend_message_list();
        for(Message message:linkedList ){
            if (message.getTask_id().equals(taskid)&& message.getMessage_details().equals(details)&&
                    message.getMessage_sender().equals(sender)&&message.getMessage_receiver().equals(receiver)&&
                    message.getMessage_date().equals(date))
                message.setIsread("read");
        }
        model.addAttribute("userInfo",MapUnit.findCurrUser(cookieval).getUserInfo());
        request.setAttribute("coco",cookieval);
        return "/showMessage";

    }

}
