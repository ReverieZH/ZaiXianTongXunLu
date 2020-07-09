package cn.com.ui;

import cn.com.bean.Contracts;
import cn.com.bean.Page;
import cn.com.dao.IContractDao;
import cn.com.dao.IUserDao;
import cn.com.dao.impl.JDBCUtils;
import cn.com.factory.ContractsFactory;
import cn.com.factory.UserFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //通过获取servlet上下文得到页码数
            ServletContext servletContext=this.getServletContext();
            int pagesize= Integer.parseInt(servletContext.getInitParameter("pagesize"));

             //获取请求的页码数
            int pageNUm=1;
            String page=request.getParameter("page");
            if(page!=null){
                pageNUm=Integer.parseInt(page);
            }

            //通过获取存取的session对象来得到登录过的用户名
            HttpSession session=request.getSession();
            String username= String.valueOf(session.getAttribute("username"));


            //获取联系人
            IContractDao contractDao= ContractsFactory.getContractsInstance();
            List<Contracts> contractslist=contractDao.getContractList(username,null,null,null,null,null);
            if(contractslist.size()!=0){
                Page<Contracts> pagebaen=new Page<>(pageNUm,pagesize,contractslist.size());
                pagebaen.setList(contractslist);
                request.setAttribute("pageBean",pagebaen);
            }
            servletContext.getRequestDispatcher("/main.jsp").forward(request,response);
        } catch (Exception e) {
            Common.alertAndBack(response,e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
