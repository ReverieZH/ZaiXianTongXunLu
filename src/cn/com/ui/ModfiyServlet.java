package cn.com.ui;

import cn.com.bean.Contracts;
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

@WebServlet(name = "ModfiyServlet")
public class ModfiyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String cid=request.getParameter("cid");
            IContractDao contractDao= ContractsFactory.getContractsInstance();
            Contracts contracts=contractDao.getContractByID(cid);

            request.setAttribute("contracts",contracts);
            ServletContext servletContext=this.getServletContext();
            servletContext.getRequestDispatcher("/modfiyContracts.jsp").forward(request,response);
        } catch (Exception e) {
            Common.alertAndBack(response,e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
