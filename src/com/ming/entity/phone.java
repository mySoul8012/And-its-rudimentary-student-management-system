package com.ming.entity;

public class phone {
    private String sno;
    private String phone;
    public phone(){
        this.sno = "";
        this.phone = "";
    }

    public String getPhone() {
        return phone;
    }

    public String getSno(){
        return sno;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setSno(String sno){
        this.sno = sno;
    }
}
