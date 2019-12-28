package com.zjt.filter;

import com.zjt.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        HttpSession session = request.getSession();
        User usr =(User) session.getAttribute("user");
        System.out.println(usr+"你的用户");
        if(usr==null){
            request.getRequestDispatcher("../error.jsp").forward(request,response);
            System.out.println("用户为空");
        }


        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post Handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }


}
