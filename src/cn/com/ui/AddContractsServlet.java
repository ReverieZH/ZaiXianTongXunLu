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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "AddContractsServlet")
public class AddContractsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            String name=request.getParameter("name");
            String sex=request.getParameter("sex");
            Integer ageInt=null;
            String age=request.getParameter("age");
            System.out.println("age:"+age);
            if(!age.equals("")){
                ageInt= Integer.valueOf(age);
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

            Contracts contracts=new Contracts(name,sex,birth,ageInt,qq,number,phone,email,wrokspace,address,postcode,username,role);

            IContractDao contractDao= ContractsFactory.getContractsInstance();
            contractDao.addContract(contracts);

            Common.alertAndRedirect(response,"添加成功","main.do");
        } catch (Exception e) {
            e.printStackTrace();
            Common.alertAndBack(response,e.getMessage());
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
