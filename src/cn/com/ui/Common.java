package cn.com.ui;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    /**
    * @Description: 弹出警告框
    * @Param:
    * @return:
    * @Date:
    */
    public static void alert(HttpServletResponse response,String smessage) throws IOException {
        PrintWriter pw=response.getWriter();
        pw.println("<script>alert('"+smessage+"');</script>");
    }

    /**
    * @Description: 弹出警告框并返回
    * @Param:
    * @return:
    * @Date:
    */
    public static void alertAndBack(HttpServletResponse response,String smessage) throws IOException {
        PrintWriter pw=response.getWriter();
        pw.println("<script>alert('"+smessage+"');history.back();</script>");
    }

    /**
    * @Description: 弹出警示框并刷新当前页面
    * @Param:
    * @return:
    * @Date:
    */
    public static void alertAndRefresh(HttpServletResponse response,String smessage) throws IOException {
        PrintWriter pw=response.getWriter();
        pw.println("<script>alert('"+smessage+"');location.href=location.href;<script>");
    }

    /**
    * @Description: 刷新当前页面
    * @Param:
    * @return:
    * @Date:
    */
    public static void Refresh(HttpServletResponse response) throws IOException {
        response.getWriter().println("<script>location.href=location.href;</script>");
    }

    /**
    * @Description: 弹出提示框并重定向
    * @Param:
    * @return:
    * @Date:
    */
    public static void alertAndRedirect(HttpServletResponse response, String sMessage, String sURL) throws IOException{
        PrintWriter out = response.getWriter();
        out.println("<script>alert('"+ sMessage +"');location.href='"+sURL+"';</script>");
    }
    /**
    * @Description: 弹出消息框,并关闭页面
    * @Param:
    * @return:
    * @Date:
    */
    public static void alertAndClose(HttpServletResponse response,String smessage) throws IOException {
        response.getWriter().println("<script>alert('"+smessage+"');window.opener=null;window.open('','_self');close();</script>");
    }

    /**
    * @Description: 关闭页面
    * @Param:
    * @return:
    * @Date:
    */
    public static void Close(HttpServletResponse response) throws IOException {
        response.getWriter().println("<script>window.opener=null;window.open('','_self');</script>");
    }

    /**
    * @Description: 将字符串处理为非空字符串
    * @Param:
    * @return:  如果源字符串为空，则返回&nbsp;否则返回源字符串
    * @Date:
    */
    public static String getNotNullString(String source){
        if(source!=null){
            return source;
        }else {
            return "&nbsp";
        }
    }

    /**
    * @Description: 将字符串处理成固定长度的字符串
    * @Param:
    * @return:  如果原字符串大于指定长度，则处理为指定长度的字符串，并加"...",否则输出原字符串
    * @Date:
    */
    public static String getFixedLengthString(String source,int length){
        if(source.length()>length){
            return source.substring(0,length)+"...";
        }else {
            return source;
        }
    }

    /**
    * @Description: 将日期处理为字符串
    * @Param:
    * @return:
    * @Date:
    */
    public static String dateToString(Timestamp timestamp){
        if(timestamp!=null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            return format.format(timestamp);
        }else {
            return "&nbsp;";
        }
    }

    /**
    * @Description: 将字符串转为为日期
    * @Param:
    * @return:
    * @Date:
    */
    public static Timestamp StringToDate(String dateString) throws Exception {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
        Date date=format.parse(dateString);
        Timestamp timestamp=new Timestamp(date.getTime());
        return timestamp;
    }

}
