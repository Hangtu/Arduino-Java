package ConexionBD;

import java.sql.*;
import static javax.swing.JOptionPane.*;


/*
 Statement tiene muchos métodos, pero hay dos interesentantes:
 * executeUpdate() y executeQuery(). El primero se usa para sentencias SQL 
 * que impliquen modificaciones en la base de datos (INSERT, UPDATE, DELETE, etc).
 * El segundo sólo para consultas (SELECT y similares)
 */
public class ConexionBD {
    // Se Podria No Cerrar La Conexion //
    // GUARDAR LOS RESULTADOS EN UN ARRAYLIST JII
    private static Connection conexion=null; //SON LA UNICA INSTANCIA //
    private static Statement st=null;
    private static ResultSet rs=null;
    
    public static void conectar(){
       
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost/familia";
        String usr="hangtu";
        String pass="";

        try{ 
            Class.forName(driver);
            conexion= DriverManager.getConnection(url,usr,pass);
            st=conexion.createStatement();
            showMessageDialog(null,"Te Conectaste A La Base De Datos");
         }
           catch(java.lang.Exception e){
            showMessageDialog(null,"Error Al Al Conectar Con La Base De Datos");
        }
    }
    
    public static void cerrar(){
         try { //Se cierran todos los recursos en el orden inverso al que fueron adquiridos          
             if(rs!=null){rs.close();}
             if(st!=null){st.close();}
             if(conexion!=null){conexion.close();}     
        } catch (Exception e) {
        }
    }
 
    
    public static ResultSet Consulta(String codigo){
        try {
            rs=st.executeQuery(codigo);
            
        }catch (Exception ex){
             showMessageDialog(null,"Error Al Ejecutar El Codigo");
         }
        return rs;  
    }
    
  
    public static void Actualiza(String codigo){ 
        
        try {
           st.executeUpdate(codigo);
        } catch (SQLException ex) {
           showMessageDialog(null,"Error Al Ejecutar El Codigo");
        }
         catch (Exception ex){
           showMessageDialog(null,"Error Al Ejecutar El Codigo");
         }
    }
    
    
}


