package com.kgc.news.dao;
import util.ConfigManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author Mr.5227
 * @date 2019/3/20 - 9:42
 * 连接数据库的基类
 */
public class BaseDao {
    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    //获取数据库的连接 使用JDBC
/*    public boolean getConnection () throws ClassNotFoundException {
//        ConfigManager cfm = new ConfigManager();
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/kgcnews";
        Class.forName(ConfigManager.getInstance().getString("jdbc.driver"));
        try {
            connection = DriverManager.getConnection(ConfigManager.getInstance().getString("jdbc.url"),
                    ConfigManager.getInstance().getString("jdbc.username"),
                    ConfigManager.getInstance().getString("jdbc.password"));
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }*/
    //数据库连接 使用JNDI
    public boolean getConnection2(){
        try {
            //1、获取一个服务的上下文对象
            Context context = new InitialContext();
            //2、通过上下文对象 Lookup 查找数据源
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/news");
            //3、获取连接
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    //查
    public ResultSet executeSelect(String sql,Object[] params){
            if(this.getConnection2()){
                try {
                    ps = connection.prepareStatement(sql);
                    for(int i=0;i<params.length;i++){
                        ps.setObject(i+1,params[i]);
                    }
                    rs = ps.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return rs;
    }
    //增、删、改
    public int executeUpdate(String sql,Object[] params){
        int result = 0;
            if(this.getConnection2()){
                try {
                    ps = connection.prepareStatement(sql);
                    for(int i=0;i<params.length;i++){
                        ps.setObject(i+1,params[i]);
                    }
                    result = ps.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return result;
    }

    //释放资源
    public void closeAll(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}