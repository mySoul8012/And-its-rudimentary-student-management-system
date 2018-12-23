package com.ming.MiddleLayer;

/**
 * @author ming
 * 登录类
 */
public class Login extends AbstractColleague {

    /**
     * @param middleLayer
     * 和中介者建立联系
     */
    public Login(AbstractMiddleLayer middleLayer) {
        super(middleLayer);
    }

    /**
     * @param user  用户名
     * @param password  密码
     * @return  boolean
     * 登录方法
     */
    public boolean userLogin(String user, String password){
        //System.out.println(user + password);
        return super.middleLayer.execute("SignIn", user, password).getResult();
    }

    /**
     * @param user 用户名
     * @param newPassword   密码
     * @return  boolean
     * 找回密码
     */
    public boolean retrievePassword(String user, String newPassword){
        return super.middleLayer.execute("RetrievePassword", user, newPassword).getResult();
    }
}
