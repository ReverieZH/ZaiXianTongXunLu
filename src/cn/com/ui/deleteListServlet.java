package cn.com.ui;

import cn.com.bean.Contracts;
import cn.com.bean.Page;
import cn.com.dao.IContractDao;
import cn.com.dao.impl.JDBCUtils;
import cn.com.factory.ContractsFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "deleteContractsServlet")
public class deleteListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServletContext context=this.getServletContext();
            int pageSize= Integer.parseInt(context.getInitParameter("pagesize"));

            int pageNum=1;
            String page=request.getParameter("page");
            if(page!=null)
                pageNum= Integer.parseInt(page);


            HttpSession session=request.getSession();
            String username= (String) session.getAttribute("username");

            IContractDao contractDao= ContractsFactory.getContractsInstance();
            List<Contracts> contractsList=contractDao.getContractList(username,null,null,null,null,null);
            if(contractsList.size()!=0) {
                Page<Contracts> pageBean = new Page<>(pageNum, pageSize, contractsList.size());
                pageBean.setList(contractsList);
                request.setAttribute("pageBean",pageBean);
            }

            context.getRequestDispatcher("/deleteList.jsp").forward(request,response);
        } catch (Exception e) {
            Common.alertAndBack(response,e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
