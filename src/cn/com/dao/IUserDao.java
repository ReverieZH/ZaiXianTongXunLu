package cn.com.dao;

import cn.com.bean.User;

import java.sql.SQLException;


/** 
* @Description: 用户服务的接口 
* @Date:  
* @Author:
*/ 
public interface IUserDao {
    public void addUser(User user) throws SQLException, Exception;
    public void deleteUser(String username) throws SQLException, Exception;
    public User getUserByName(String username) throws SQLException, Exception;
    public boolean Login(User user) throws SQLException, Exception;
    public void changePassword(String username, String newpassword, String oldpassword) throws Exception;
}
