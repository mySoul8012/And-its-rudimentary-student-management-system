package com.ming.ServiceLayer;

import com.ming.entity.phone;

import java.sql.ResultSet;

/**
 * @author ming
 * 此表封装了对phone表的CURD
 */
public class phoneTable extends DBConnection{
    private phone phone = new phone();
    public phoneTable(){
        super();    // 初始化连接
    }
    // 根据sno获取手机号
    public String getPhoneNumber(String sno){
        this.sql = "SELECT phone FROM phone WHERE sno = '" + sno + "';";
        System.out.println(this.sql);
        try{
            this.executeQuery();
            ResultSet rs = this.getResultSet();
            String phone = null;
            while(rs.next()){
                phone = rs.getString(1);
            }
            super.closeStatementConnection();
            return phone;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    // 增加关联
    public boolean addPhoneSno(String phone, String sno){
        this.sql = "INSERT phone(sno, phone) values('" + sno +"', '" + phone + "')";
        try{
            this.executeQuery();
            this.closeStatementConnection();
            return this.getResultSetUpdate().equals("1");
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
