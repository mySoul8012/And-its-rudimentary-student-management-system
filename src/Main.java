import com.ming.ServiceLayer.DBConnection;
import com.ming.ServiceLayer.StudentInfoTable;
import com.ming.ServiceLayer.UserLogin;
import com.ming.entity.User;
import com.ming.view.mainUi.MainUi;
import com.ming.view.studentUI.StudentUI;
import com.ming.entity.Student;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //MainUi mainUi = new MainUi();
        //Login login = new Login();
        //JFrame test = new Test();
        //Student student = new Student();
        //student.setAge("12");
        //JFrame test = new StudentUI(student);
       User user = new User();
       user.setName("sdgr");
       user.setPassword("sdfsfs");
       UserLogin userLogin = new UserLogin();
       try{
           if(userLogin.login(user)){
               System.out.println("登录成功");
           }else{
               System.out.println("登录失败");
           };
       }catch (Exception e){
           System.out.println(e);
       }
        /*
        try {
            Student student = new Student();
            student.setSno("0780505001");
            StudentInfoTable studentInfoTable = new StudentInfoTable();
            if(studentInfoTable.addStudent(student)){
                System.out.println("增加成功");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        */
    }
}
