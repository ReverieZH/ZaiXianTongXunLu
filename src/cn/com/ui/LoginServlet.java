package cn.com.ui;

import cn.com.bean.User;
import cn.com.dao.impl.JDBCUtils;
import cn.com.dao.impl.UserDao;
import cn.com.factory.UserFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            System.out.println(username+" "+password);
            User user=new User(username,password);
            UserDao userlogin= (UserDao) UserFactory.getUserDaoInstance();
            if(!userlogin.Login(user)){
                throw new Exception("用户名密码不正确");
            }
            HttpSession session=request.getSession();
            session.setAttribute("username",user.getUsername());
            response.sendRedirect("main.do");   //重定向
        } catch (Exception e) {
           /*response.getWriter().println(e.getMessage());*/
            Common.alertAndBack(response,e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
