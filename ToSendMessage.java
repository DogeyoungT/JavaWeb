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
import java.util.ArrayList;
import java.util.LinkedList;
@Controller
public class ToSendMessage {
    /**
     * @RequestParam注解的作用是：根据参数名从URL中取得参数值
     *
     *            任务标题
     *
     * @param model
     * */
    @RequestMapping("tosendmessage")
    public String tosendmessage(@CookieValue("cookieName")String cookieval,
                                HttpServletRequest request,Model model){
        model.addAttribute("userInfo",MapUnit.findCurrUser(cookieval).getUserInfo());
        request.setAttribute("coco",cookieval);
        return "sendmessage";
    }
}
