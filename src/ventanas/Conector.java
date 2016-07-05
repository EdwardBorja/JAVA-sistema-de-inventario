package ventanas;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conector {
        static Connection conect = null;
       public static Connection conexion()
       {
           try{
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               
               conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/temsa","root","123");
               conect = DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/temsa","root","123");  
             
               
           }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
               JOptionPane.showMessageDialog(null, "Error" + e);
        
          }
       return conect;
       }
}
