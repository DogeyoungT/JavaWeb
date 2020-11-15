package controller;

/**
 * Created by zhangzheyu on 2017/7/17.
 */
import Model.MapUnit;
import Model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Model.Task;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.LinkedList;

@Controller
public class ShowMessage {
    /**
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     *
     *            任务标题
     */
    @RequestMapping("/Mymessage")
    public String Mymessage(@CookieValue("cookieName") String cookieval, HttpServletRequest request)
    {
        request.setAttribute("coco", cookieval);
        return "showMessage";

    }
    /**
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     * @param Messagetype
     *
     */
    @RequestMapping("ShowMessage")
    public String ShowMessage(@RequestParam(value = "Messagetype",required = false)String Messagetype,@CookieValue("cookieName") String cookieval,
                              HttpServletRequest request)throws SQLException{
        Connection connection =new DBConnection().connection;
        Statement statement =connection.createStatement();
        String sql = "";
        LinkedList<Message> linkedList = new LinkedList<>();
        ResultSet resultSet;
        if (Messagetype.equals("systemmessage")){
            sql = String.format("select task.task_id,task_title,message_details,message_send, message_receiver,message_date,is_read from task,systemmessage where message_receiver = '%s'and \"task\".task_id = systemmessage.task_id  order by message_date desc", MapUnit.findCurrUser(cookieval).getUserInfo().getAcc_username());
            resultSet = statement.executeQuery(sql);
            addtoSystemMessageList(linkedList,resultSet);
            MapUnit.findCurrUser(cookieval).setMy_system_message_list(linkedList);
        }else if (Messagetype.equals("friendmessage")){
            sql = String.format("select * from friendmessage where message_receiver = '%s' order by message_date desc", MapUnit.findCurrUser(cookieval).getUserInfo().getAcc_username());
            resultSet = statement.executeQuery(sql);
            addtoFriendMessageList(linkedList,resultSet);
            MapUnit.findCurrUser(cookieval).setMy_friend_message_list(linkedList);
        }
        request.setAttribute("coco", cookieval);
        return "showMessage";


    }
    public void addtoSystemMessageList(LinkedList<Message> linkedList,ResultSet resultSet)throws SQLException{
        while(resultSet.next()){
            Message message =new Message();
            message.setTask_id(resultSet.getString("task_id"));
            message.setTask_title(resultSet.getString("task_title"));
            message.setMessage_details(resultSet.getString("message_details"));
            message.setMessage_sender(resultSet.getString("message_send"));
            message.setMessage_receiver(resultSet.getString("message_receiver"));
            message.setMessage_date(resultSet.getString("message_date"));
            message.setIsread(resultSet.getString("is_read"));
            linkedList.add(message);
        }

    }
    public void addtoFriendMessageList(LinkedList<Message> linkedList,ResultSet resultSet) throws SQLException{
        while(resultSet.next()){
            Message message =new Message();
            message.setMessage_date( resultSet.getString("message_date"));
            message.setMessage_receiver(resultSet.getString("message_receiver"));
            message.setMessage_sender(resultSet.getString("messsage_sender"));
            message.setMessage_details(resultSet.getString("message_details"));
        }
    }

}
