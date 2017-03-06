/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HSQL;

import java.sql.*;
import java.util.ResourceBundle;

/*
 Statement tiene muchos métodos, pero hay dos interesentantes:
 * executeUpdate() y executeQuery(). El primero se usa para sentencias SQL 
 * que impliquen modificaciones en la base de datos (INSERT, UPDATE, DELETE, etc).
 * El segundo sólo para consultas (SELECT y similares)
 */
public class UConnection {
    //DISEÑO  SINGLETON PATTERN 
    private static Connection con=null; //ES LA UNICA INSTANCIA //

    
    public static Connection getConnection(){
       
        ResourceBundle rb= ResourceBundle.getBundle("jdbc");
      
        
        String driver=rb.getString("driver");
        String url=rb.getString("url");
        String usr=rb.getString("usr");
        String pass=rb.getString("pass");
              
        try{ 
          if(con==null){
            Runtime.getRuntime().addShutdownHook(new Shutdown());
            Class.forName(driver);
            con= DriverManager.getConnection(url,usr,pass);
            System.out.println("Conexion con "+url+" exitosa");
          }
        }
        
        catch(java.lang.Exception e){
            System.out.println("Conexion con "+url+" erronea");
        }
        
        return con;
    }
    
    static class Shutdown extends Thread{
      
            public void run(){
                try {
                  Connection con= UConnection.getConnection();
                  con.close();
                  System.out.println("Se cerro la conexion con la base de datos");
                } catch (Exception e) {
                  System.out.println("Error al cerrar la conexion con la base de datos");
                }
            }
    }
}

    
