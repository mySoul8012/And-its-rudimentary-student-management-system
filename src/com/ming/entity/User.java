package com.ming.entity;

import javax.xml.crypto.Data;
import java.util.Date;

// 对应于数据库的user表
public class User {
    // 用户姓名
    private String name;
    // 用户密码
    private String password;
    // 创建时间
    private Date createData;
    // 过期时间
    private Date expireTime;
    public User(){
        this.name = "";
        this.expireTime = new Date();
        this.createData = new Date();
        this.password = "";
    }
    // 对应的set get方法
    public String getName(){
        return this.name;
    }
    public void setName(String _name){
        this.name = _name;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String _password){
        this.password = _password;
    }
    public Date getCreateData(){
        return this.createData;
    }
    public void setCreateData(Date _createData){
        this.createData = _createData;
    }
    public Date getExpireTime(){
        return this.expireTime;
    }
    public void setExpireTime(Date _expireTime){
        this.expireTime = _expireTime;
    }
}
