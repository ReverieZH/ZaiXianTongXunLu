package cn.com.ui;

import cn.com.dao.IContractDao;
import cn.com.dao.impl.JDBCUtils;
import cn.com.factory.ContractsFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "deleteServlet")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServletContext servletContext=this.getServletContext();

            IContractDao contractDao= ContractsFactory.getContractsInstance();
            String deletelist[]=request.getParameterValues("cid");
            for (String cid:deletelist) {
                contractDao.deleteContract(cid);
            }

            String page=request.getParameter("page");
            servletContext.getRequestDispatcher("/deleteList.do?page="+page).forward(request,response);

        } catch (Exception e) {
           Common.alertAndBack(response,e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
