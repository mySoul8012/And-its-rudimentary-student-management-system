package com.ming.entity;

import javax.xml.crypto.Data;

// 对应于数据库的user表
public class User {
    // 用户姓名
    private String name;
    // 用户密码
    private String password;
    // 创建时间
    private Data createData;
    // 过期时间
    private Data expireTime;
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
    public Data getCreateData(){
        return this.createData;
    }
    public void setCreateData(Data _createData){
        this.createData = _createData;
    }
    public Data getExpireTime(){
        return this.expireTime;
    }
    public void setExpireTime(Data _expireTime){
        this.expireTime = _expireTime;
    }
}
