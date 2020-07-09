package cn.com.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    /**
    * @Description:
    * @Param:
    * @return:
    * @Date:
    */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
    * @Description:
    * @Param:
    * @return:
    * @Date:
    */
     public static Connection getConnecion() throws Exception {
         return dataSource.getConnection();
     }


     /**
     * @Description: 关闭连接
     * @Param:  Connection , CallableStatement , ResultSet
     * @return:  void
     * @Date:
     */
     public static void close(Connection con, CallableStatement cs, ResultSet rs){
         if(con!=null){
             try {
                 con.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
         if(cs!=null){
             try {
                 cs.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
         if(rs!=null){
             try {
                 rs.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
     }

    public static void close(Connection con, CallableStatement cs){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(cs!=null){
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
