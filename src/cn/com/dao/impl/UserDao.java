package cn.com.dao.impl;

import cn.com.bean.User;
import cn.com.dao.IUserDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

public class UserDao implements IUserDao {
    @Override
    public void addUser(User user) throws Exception {
        Connection con=JDBCUtils.getConnecion();
        CallableStatement cs=con.prepareCall("{call addUser(?,?)}");
        cs.setString(1,user.getUsername());
        cs.setString(2,user.getPassword());
        cs.executeUpdate();
        JDBCUtils.close(con,cs);
    }

    @Override
    public void deleteUser(String username) throws Exception {
        Connection con=JDBCUtils.getConnecion();
        CallableStatement cs=con.prepareCall("{call deleteUser(?)}");
        cs.executeUpdate();
        JDBCUtils.close(con,cs);
    }

    @Override
    public User getUserByName(String username) throws Exception {
        Connection con=JDBCUtils.getConnecion();
        CallableStatement cs=con.prepareCall("{call getUserByname(?)}");
        cs.setString(1,username);
        ResultSet rs=cs.executeQuery();
        if(!rs.next())
            throw new Exception("未找到用户");
        User user=new User(rs.getString("username"),rs.getString("password"));
        JDBCUtils.close(con,cs,rs);
        return user;
    }

    @Override
    public boolean Login(User user) throws Exception {
        User userget=getUserByName(user.getUsername());
        if(user.getPassword().equals(userget.getPassword())){
             return true;
        }
        return false;
    }

    @Override
    public void changePassword(String username, String oldpassword, String newpassword) throws Exception {
            Connection con=JDBCUtils.getConnecion();
            String error=new String();
            CallableStatement cs=con.prepareCall("{call changePassword(?,?,?,?)}");
            cs.setString(1,username);
            cs.setString(2,oldpassword);
            cs.setString(3,newpassword);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.executeUpdate();
            error=cs.getString(4);
            if(error!=null){
                System.out.println(error);
                throw new Exception("原密码不正确");
            }
            JDBCUtils.close(con,cs);
    }

  /* public static void main(String[] args) throws Exception {
            UserDao userdao=new UserDao();
            userdao.changePassword("reverie","r123","8520");
    }*/
}
