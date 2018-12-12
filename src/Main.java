import java.sql.*;
public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","test","123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from test");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("he");
        } catch (SQLException e){
            System.out.println("hhh");
        }
    }
}
