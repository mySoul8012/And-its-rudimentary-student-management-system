package com.ming.ServiceLayer;

import com.ming.entity.Curriculum;
import com.ming.tools.TransferredMeaning;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * 封装对c表的操作
 */
public class CurrlculumTable extends DBConnection{
    private Curriculum curriculum = new Curriculum();
    public CurrlculumTable(){
        super();
    }

    /**
     * @param curriculum
     * @return Curriculum
     * 给定课程号，返回对应的全部信息
     */
    public Curriculum selectCurriclum(Curriculum curriculum) throws Exception{
        // 判断
        if(curriculum == null){
            return null;
        }
        // 赋值，拼接sql
        this.curriculum = curriculum;
        this.sql = "SELECT cno,cn,hourc FROM c WHERE cno = '" + TransferredMeaning.getTransferredMeaning(this.curriculum.getCno()) + "';";
        // 执行
        this.executeQuery();
        // 返回结果
        ResultSet rs = this.getResultSet();
        Curriculum tmpCurriculum = new Curriculum();
        while(rs.next()){
            tmpCurriculum.setCno(rs.getString(1));
            tmpCurriculum.setCn(rs.getString(2));
            tmpCurriculum.setHourc(rs.getString(3));
        }
        return tmpCurriculum;
    }
    /**
     * @param curriculum
     * @return boolean
     * 增加课程，返回布尔值
     */
    public boolean addCurriclum(Curriculum curriculum) throws Exception{
        // 判断
        if(curriculum == null){
            return false;
        }
        // 赋值
        this.curriculum = curriculum;
        // 拼接sql
        this.sql = "INSERT c(cno,cn,hourc) VALUES('" + TransferredMeaning.getTransferredMeaning(this.curriculum.getCno()) + "', '" + TransferredMeaning.getTransferredMeaning(this.curriculum.getCn()) + "', '" + TransferredMeaning.getTransferredMeaning(this.curriculum.getHourc()) + "');";
        // 执行sql
        this.executeQuery();
        // 进行判断
        String rs = this.getResultSetUpdate();
        return "1".equals(rs);
    }
    /**
     * @param curriculum
     * @return boolean
     * 删除课程，返回布尔值
     */
    public boolean deleteCurriculum(Curriculum curriculum)throws Exception{
        // 赋值
        this.curriculum = curriculum;
        // 拼接sql
        this.sql = "DELETE FROM c WHERE cno='"+ TransferredMeaning.getTransferredMeaning(this.curriculum.getCno()) +"';";
        System.out.println(this.sql);
        this.executeQuery();
        // 获取结果
        String rs = this.getResultSetUpdate();
        return "1".equals(rs);
    }
    /**
     * @param curriculum
     * @return boolean
     * 更改课程，返回布尔值
     */
    public boolean changeCurriculum(Curriculum oldCurriculum, Curriculum curriculum)throws Exception{
        // 赋值
        this.curriculum = curriculum;
        // 拼接sql
        this.sql = "UPDATE c SET cno = '"+ TransferredMeaning.getTransferredMeaning(this.curriculum.getCno()) + "', cn = '" + TransferredMeaning.getTransferredMeaning(this.curriculum.getCno()) + "', hourc = '" + TransferredMeaning.getTransferredMeaning(this.curriculum.getHourc()) + "' where cno = '" + TransferredMeaning.getTransferredMeaning(oldCurriculum.getCno()) +"';";
        this.executeQuery();
        // 获取结果
        String rs = this.getResultSetUpdate();
        return "1".equals(rs);
    }
    /**
     * @param limt
     * @param length
     * @return List<Student>
     * 返回课程列表,第一个参数为页数  第二个参数为页数的长度，返回的是已经分页过的
     */
    public List<Curriculum> lisrCurriculum(int limt, int length) throws Exception {
        // 验证传入值
        if(limt < 0 || length < 0){
            throw new Exception("传入的limt，length错误");
        }
        // 拼接sql
        this.sql = "SELECT cno,cn,hourc FROM c LIMIT " + limt * length + "," + length + ";";
        System.out.println(sql);
        // 执行sql
        super.executeQuery();
        // 获取结果
        ResultSet rs = this.getResultSet();
        List<Curriculum> list = new ArrayList<Curriculum>();
        while(rs.next()){
            Curriculum tmpCurriculum = new Curriculum();
            tmpCurriculum.setCno(rs.getString(1));
            tmpCurriculum.setCn(rs.getString(2));
            tmpCurriculum.setHourc(rs.getString(3));
            list.add(tmpCurriculum);
        }
        return list;
    }
}
