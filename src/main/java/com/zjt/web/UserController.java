package com.zjt.web;

import com.zjt.pojo.User;
import com.zjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Resource
    private UserService us;
    @RequestMapping("/usr/checkLogin")
    public String login(User user, HttpServletRequest request, HttpSession session){
        System.out.println(user);
        String msg = null;
        String page = null;
        System.out.println("我日"+us.checkLogin(user));
        if (us.checkLogin(user)==null){
            msg ="the account or password is wrong";
            page = "er";
        }else if (us.checkLogin(user).getType().equals("teacher")){
            session.setAttribute("user",user);
            page = "manager";
        }else if(us.checkLogin(user).getType().equals("student")){
            request.getSession().setAttribute("user",user);
            page = "choice";
        }
        System.out.println(msg);
        request.setAttribute("msg","msg");
        return page;
    }


    @RequestMapping("/usr/error")
    public String usererror(){
        return "add";
    }


}
