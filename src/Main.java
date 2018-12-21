import com.ming.ServiceLayer.CurrlculumTable;
import com.ming.ServiceLayer.DBConnection;
import com.ming.ServiceLayer.StudentInfoTable;
import com.ming.ServiceLayer.UserLogin;
import com.ming.entity.Curriculum;
import com.ming.entity.User;
import com.ming.view.mainUi.MainUi;
import com.ming.view.studentUI.StudentUI;
import com.ming.entity.Student;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //MainUi mainUi = new MainUi();
        //Login login = new Login();
        //JFrame test = new Test();
        //Student student = new Student();
        //student.setAge("12");
        //JFrame test = new StudentUI(student);
        /*
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
*/
        try {
            List<Student> list = new ArrayList<Student>();
            StudentInfoTable studentInfoTable = new StudentInfoTable();
            list = studentInfoTable.listStudent(0,3);
            for(Student tmpStudent: list){
                System.out.println(tmpStudent.getSno());
            }
        }catch(Exception e){
            System.out.println(e);
        }
        /*
        try{
            List<Curriculum> list = new ArrayList<Curriculum>();
            CurrlculumTable currlculumTable = new CurrlculumTable();
            list = currlculumTable.lisrCurriculum(0, 20);
            for(Curriculum tmpCurriculum:list){
                System.out.println(tmpCurriculum.getCn());
            }
        }catch(Exception e){
            System.out.println(e);
        }
        */
    }
}
