package cn.com.ui;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
* @Description: 定义Web过滤器，判断是否登录
* @Date:
* @Author:
*/
public class WebFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置Servlet
        servletResponse.setContentType("text/html");
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        HttpServletRequest httpRequest= (HttpServletRequest) servletRequest;
        HttpSession session=httpRequest.getSession();
        
        String path=httpRequest.getServletPath();
        if(path.equals("/login.jsp")||path.equals("login.do")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            String username= String.valueOf(session.getAttribute("username"));
            if(username!=null||!username.equals("")){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                ((HttpServletResponse)servletResponse).sendRedirect("/login.jsp");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
