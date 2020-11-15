package controller;

/**
 * Created by zhangzheyu on 2017/7/22.
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
public class SendMessage {
    /**
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     *
     * @param receiver
     *@param details
     * @param model
     * */
    @RequestMapping("SendMessage")
    public String SendMessage(@RequestParam("receiver") String receiver,@RequestParam("details") String details,Model model,@CookieValue("cookieName")String cookieval,
                              HttpServletRequest request) throws SQLException{
        Connection connection = new DBConnection().connection;
        Statement statement = connection.createStatement();
        String sql = "";
        String username = MapUnit.findCurrUser(cookieval).getUserInfo().getAcc_username();
        Calendar today = Calendar.getInstance();
        String currentDate = today.get(Calendar.YEAR)+"-"+(today.get(Calendar.MONTH)+1)+"-"+(today.get(Calendar.DAY_OF_MONTH));
        Date now = new Date();
        SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyyMMddHHmmss");
        String message_id = dateFormat.format(now) + username;
        sql = String.format("insert into friendmessage values('%s','%s','%s','%s','%s')",message_id,details,username,receiver,currentDate);
        statement.execute(sql);
        model.addAttribute("userInfo",MapUnit.findCurrUser(cookieval).getUserInfo());
        request.setAttribute("coco",cookieval);
        return "/friends";

    }
}
