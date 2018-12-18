package com.ming.entity;

// 对应表c表
public class Curriculum {
    private String cno;
    private String cn;
    private String hourc;
    public String getCno(){
        return this.cno;
    }
    public void setCno(String _cno){
        this.cno = _cno;
    }
    public String getHourc(){
        return this.hourc;
    }
    public void setHourc(String _hourc){
        this.hourc = _hourc;
    }
    public String getCn(){
        return this.cn;
    }
    public void setCn(String _cn){
        this.cn = _cn;
    }
}
