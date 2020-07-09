package cn.com.factory;

import cn.com.dao.IUserDao;
import cn.com.dao.impl.UserDao;

public class UserFactory {
    public static IUserDao getUserDaoInstance() {
        return new UserDao();
    }
}
