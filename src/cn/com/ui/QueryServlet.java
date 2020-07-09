package cn.com.ui;

import cn.com.bean.Contracts;
import cn.com.bean.Page;
import cn.com.dao.IContractDao;
import cn.com.factory.ContractsFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServletContext servletContext=this.getServletContext();
            int pageSzie= Integer.parseInt(servletContext.getInitParameter("pagesize"));

            int pageNum=1;
            String page=request.getParameter("page");
            if(page!=null){
                pageNum= Integer.parseInt(page);
            }

            String username= String.valueOf(request.getSession().getAttribute("username"));
            String name=request.getParameter("name").trim();
            if(name.equals("")){
                name=null;
            }
            String number=request.getParameter("number").trim();
            if(number.equals("")){
                number=null;
            }
            String phone=request.getParameter("phone").trim();
            if(phone.equals("")){
                phone=null;
            }
            String workspace=request.getParameter("workspace").trim();
            if(workspace.equals("")){
                workspace=null;
            }

            String role=request.getParameter("role");
            if(role!=null) {
                if (role.equals("")) {
                    role = null;
                }
            }

            IContractDao contractDao= ContractsFactory.getContractsInstance();
            List<Contracts> contractsList=contractDao.getContractList(username,name,number,phone,workspace,role);
            if(contractsList.size()!=0){
                Page<Contracts> pageBean=new Page<>(pageNum,pageSzie,contractsList.size());
                pageBean.setList(contractsList);
                request.setAttribute("pageBean",pageBean);
            }

            servletContext.getRequestDispatcher("/queryList.jsp").forward(request,response);

        } catch (Exception e) {
           Common.alertAndBack(response,e.getMessage());
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
