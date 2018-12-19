package com.ming.ServiceLayer;

import com.ming.entity.User;
import java.sql.*;
import javax.xml.crypto.Data;

// 该类封装了对user表的操作 包含查询和增加
public class UserLogin extends DBConnection{
    private String name;
    private String password;
    private Data createData;
    private Data expireTime;
    public UserLogin(){
        super();    // 和数据库建立连接
    }
    // 用户登录方法
    public boolean login(User _user) throws Exception{
        // 获取当前登录信息
        // 用户姓名
        this.name = _user.getName();
        // 密码
        this.password = _user.getPassword();
        // 创建时间
        this.createData = _user.getCreateData();
        // 过期时间
        this.expireTime = _user.getExpireTime();
        // 拼接sql
        this.sql = "SELECT password FROM user WHERE name = " + "'" + this.name + "'" + ";";
        // 执行sql
        super.executeQuery();
        // 进行判断
        ResultSet  rs = this.getResultSet();
        while(rs.next()){
            if(rs.getString(1).equals(this.password.toUpperCase())){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    // 注册用户增加
    public boolean addUser(User _user) throws Exception{
        this.name = _user.getName();
        this.password = _user.getPassword();
        this.createData = _user.getCreateData();
        this.expireTime = _user.getExpireTime();
        // 拼接sql
        this.sql = "INSERT user(name,password) VALUES(' "+ this.name + "', '" + this.password.toUpperCase() + "');";
        //this.sql = "Insert user(name,password) values('sefwf', 'eferfef');";
        // 执行sql
        super.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        if(rs.equals("1")){
            return true;
        }
        return false;
    }
    // 注册用户删除
    public boolean deleteUser(User _user)throws Exception{
        this.name = _user.getName();
        this.password = _user.getPassword();
        this.expireTime = _user.getExpireTime();
        this.expireTime = _user.getExpireTime();
        // 拼接sql
        this.sql = "DELETE FROM user WHERE name = '" + this.name + "' ";
        // 执行
        super.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        if(rs.equals("1")){
            return true;
        }
        return false;
    }
    // 注册用户更改
    public boolean updat(User _oldUser, User _user)throws Exception{
        this.name = _user.getName();
        this.password = _user.getPassword();
        this.expireTime = _user.getExpireTime();
        this.expireTime = _user.getExpireTime();
        // 拼接sql
        this.sql = "UPDATE user SET name = '" + this.name + "', password = '" + this.password.toUpperCase() + "' WHERE name = '"  + _oldUser.getName() + "';";
        //System.out.println(this.sql);
        // 执行
        super.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        if(rs.equals("1")){
            return true;
        }
        return false;
    }
}
