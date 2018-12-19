package com.ming.ServiceLayer;

import com.ming.entity.User;
import com.ming.tools.Encryption;

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
        //System.out.println(sql);
        // 执行sql
        super.executeQuery();
        // 进行判断
        ResultSet  rs = this.getResultSet();
        while (rs.next()) {
            if(rs.getString(1).equals(Encryption.getSHA(this.password))){
                return true;
            }
        }
        return false;
    }
    // 注册用户增加
    public boolean addUser(User user) throws Exception{
        this.name = user.getName();
        this.password = user.getPassword();
        this.createData = user.getCreateData();
        this.expireTime = user.getExpireTime();
        // 拼接sql
        this.sql = "INSERT user(name,password) VALUES('"+ this.name + "', '" + Encryption.getSHA(this.password) + "');";
        //this.sql = "Insert user(name,password) values('sefwf', 'eferfef');";
        // 执行sql
        super.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        return "1".equals(rs);
    }
    // 注册用户删除
    public boolean deleteUser(User user)throws Exception{
        this.name = user.getName();
        this.password = user.getPassword();
        this.expireTime = user.getExpireTime();
        this.expireTime = user.getExpireTime();
        // 拼接sql
        this.sql = "DELETE FROM user WHERE name = '" + this.name + "' ";
        // 执行
        super.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        return "1".equals(rs);
    }
    // 注册用户更改
    public boolean updat(User olduser, User user)throws Exception{
        this.name = user.getName();
        this.password = user.getPassword();
        this.expireTime = user.getExpireTime();
        this.expireTime = user.getExpireTime();
        // 拼接sql
        this.sql = "UPDATE user SET name = '" + this.name + "', password = '" + Encryption.getSHA(this.password) + "' WHERE name = '"  + olduser.getName() + "';";
        //System.out.println(this.sql);
        // 执行
        super.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        return "1".equals(rs);
    }
}
