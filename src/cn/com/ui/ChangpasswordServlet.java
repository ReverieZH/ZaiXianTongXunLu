package cn.com.ui;

import cn.com.dao.IUserDao;
import cn.com.factory.UserFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangpasswordServlet")
public class ChangpasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= String.valueOf(request.getSession().getAttribute("username"));
        String oldpassword=request.getParameter("oldpassword");
        String newpassword=request.getParameter("newpassword");

        IUserDao userDao= UserFactory.getUserDaoInstance();
        try {
            userDao.changePassword(username,oldpassword,newpassword);
            ServletContext servletContext=this.getServletContext();
            Common.alert(response,"修改成功");
            servletContext.getRequestDispatcher("/main.do").forward(request,response);
        } catch (Exception e) {
            Common.alertAndBack(response,e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
