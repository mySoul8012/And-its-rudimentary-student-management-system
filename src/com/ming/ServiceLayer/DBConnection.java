package com.ming.ServiceLayer;

import java.sql.*;
import java.lang.Exception;

// 数据库连接类
public class DBConnection {
    // 连接
    private Connection connection = null;
    // 数据包
    private Statement statement = null;
    // 结果集
    private ResultSet resultSet = null;
    private String resultSetUpdate = null;
    // 连接数据
    // 用户名
    private static final String userName = "ming";
    // 密码
    private static final String password = "12345678";
    // 驱动
    private static final String driveClassName = "com.mysql.cj.jdbc.Driver";
    // 连接的URl
    private static final String url = "jdbc:mysql://iming.info:3306/ming_student";
    // 执行的sql
    protected String sql;
    // 构造函数
    public DBConnection(){
        try {
            Class.forName(DBConnection.driveClassName);
            connection = DriverManager.getConnection(DBConnection.url, DBConnection.userName, DBConnection.password);
            statement = this.connection.createStatement();
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    // get，set
    public String getSql(){
        return this.sql;
    }
    public void setSql(String _sql){
        this.sql = _sql;
    }
    // 执行sql命令
    public boolean executeQuery() throws Exception {
        if (sql == null)
            throw new Exception("Not sql");
        if(this.sql.charAt(0) == 'S') {
            this.resultSet = this.statement.executeQuery(this.getSql());
            return true;
        }
        if(this.sql.charAt(0) == 'I' || this.sql.charAt(0) == 'D' || this.sql.charAt(0) == 'U') {
            this.resultSetUpdate = this.statement.executeUpdate(this.getSql()) + "";
            return true;
        }
        return false;
    }
    public ResultSet getResultSet(){
        return this.resultSet;
    }
    public String getResultSetUpdate(){
        return this.resultSetUpdate;
    }
    // 关闭连接
    public boolean closeStatementConnection(){
        if(this.connection != null || this.statement != null){
            try{
                this.connection.close();
                this.statement.close();
                return true;
            }catch(SQLException e){
                return false;
            }
        }
        return false;
    }
}
