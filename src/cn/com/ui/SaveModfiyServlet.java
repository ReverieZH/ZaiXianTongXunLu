package cn.com.ui;

import cn.com.bean.Contracts;
import cn.com.dao.IContractDao;
import cn.com.dao.impl.JDBCUtils;
import cn.com.factory.ContractsFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "SaveModfiyServlet")
public class SaveModfiyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String pageNum=request.getParameter("page");
            String cid=request.getParameter("cid");
            String name=request.getParameter("name");
            String sex=request.getParameter("sex");
            Integer age;
            System.out.println(request.getParameter("age"));
            if(request.getParameter("age").equals("")||request.getParameter("age")==null){
                age=null;
            }else {
                age = Integer.valueOf(request.getParameter("age"));
            }
            String birth=request.getParameter("birth");
            String qq=request.getParameter("qq");
            String number=request.getParameter("number");
            String phone=request.getParameter("phone");
            String email=request.getParameter("email");
            String wrokspace=request.getParameter("workspace");
            String address=request.getParameter("address");
            String postcode=request.getParameter("postcode");
            String role=request.getParameter("role");

            HttpSession session=request.getSession();
            String username= String.valueOf(session.getAttribute("username"));

            Contracts contracts=new Contracts(cid,name,sex,birth,age,qq,number,phone,email,wrokspace,address,postcode,username,role);

            IContractDao contractDao= ContractsFactory.getContractsInstance();
            contractDao.updateContract(contracts);

            Common.alertAndRedirect(response,"修改成功","modfiyList.do?page="+pageNum);
        } catch (Exception e) {
            Common.alertAndBack(response,e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
