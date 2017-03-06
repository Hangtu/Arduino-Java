/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;
import java.sql.*;

/**
 *
 * @author ANDRES
 */
public class conexion {

   
   
   
   private final String url = "jdbc:mysql://localhost/facturacion";
    PreparedStatement psPrepararSentencia;
    Connection con = null;
   

    
    public conexion() {
     try{  
         
         Class.forName("com.mysql.jdbc.Driver");
         
         con = DriverManager.getConnection(url,"tu usuario en la base de datos","tu contraseña");
         if (con!=null){
            System.out.println("Conexión a base de datos facturacion. listo");
         }
      }
         catch(SQLException e)
         {
         System.out.println(e);
         }
         catch(ClassNotFoundException e)
         {
          System.out.println(e);
         }
    }
     /**
     *
     * @return
     */
    public Connection conectado(){
      return con;
}

    public void desconectar(){
      con = null;
      System.out.println("conexion terminada");

    } 

    
}
