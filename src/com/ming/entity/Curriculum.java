package com.ming.entity;

// 对应表c表
public class Curriculum {
    private String cno;
    private String cn;
    private String hourc;

    /**
     *
     */
    public Curriculum(){
        this.cn = "";
        this.hourc = "";
        this.cno = "";
    }

    /**
     * @return
     */
    public String getCno(){
        return this.cno;
    }

    /**
     * @param _cno
     */
    public void setCno(String _cno){
        this.cno = _cno;
    }

    /**
     * @return
     */
    public String getHourc(){
        return this.hourc;
    }

    /**
     * @param _hourc
     */
    public void setHourc(String _hourc){
        this.hourc = _hourc;
    }

    /**
     * @return
     */
    public String getCn(){
        return this.cn;
    }

    /**
     * @param _cn
     */
    public void setCn(String _cn){
        this.cn = _cn;
    }
}
