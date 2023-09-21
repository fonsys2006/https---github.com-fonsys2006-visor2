
package clases.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author FONSYS
 */

public class Conexionbd {
    private static final int LoginTimeout = 10;
    String zcodigoempresa =" ";
    public Conexionbd(String zempre) {
        zcodigoempresa = zempre;
    }
     
    public Connection getConexion() throws SQLException{
        Connection cn = null;  
        Properties prop = new Properties();
    //    System.out.println("User home directory: " + System.getProperty("user.home"));
        String host;
        String username;
        String password;
        String driver;
      
        try {
            prop.load(new java.io.FileInputStream(System.getProperty("user.home") + "/mydb1.cfg"));
 
            host = prop.getProperty("host") + zcodigoempresa ;
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");
            
            Class.forName(driver);
        //    System.out.println("--------------------------");
        //    System.out.println("DRIVER: " + driver);
        //    System.out.println("Set Login Timeout: " + LoginTimeout);
            DriverManager.setLoginTimeout(LoginTimeout);
            cn = DriverManager.getConnection(host, username, password);
        //    System.out.println("CONNECTION: " + cn);
         
        }catch (SQLException e) {
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
        return cn;
    } 
} 
