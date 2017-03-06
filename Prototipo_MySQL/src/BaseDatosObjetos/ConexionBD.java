/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatosObjetos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.*;


/*
 Statement tiene muchos métodos, pero hay dos interesentantes:
 * executeUpdate() y executeQuery(). El primero se usa para sentencias SQL 
 * que impliquen modificaciones en la base de datos (INSERT, UPDATE, DELETE, etc).
 * El segundo sólo para consultas (SELECT y similares)
 */
public class ConexionBD {
    // Se Podria No Cerrar La Conexion para no abrirla cada vez que tengamos que hacer una concuslta//
    // GUARDAR LOS RESULTADOS EN UN ARRAYLIST JII
    private static Connection conexion=null; //SON LA UNICA INSTANCIA //
    private static Statement st=null;
    private static ResultSet rs=null;
    
    public static void conectarBD(){
       
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost/familia"; 
        //en caso inalmbrico "jdbc:mysql://10.43.9.19:3306";
        //Connection conexion = DriverManager.getConnection("jdbc:mysql://10.54.0.163:3306/snack_online", "qooke", "");
        String usr="hangtu";
        String pass="";

        try{ 
            Class.forName(driver);
            conexion= DriverManager.getConnection(url,usr,pass);
            showMessageDialog(null,"Te Conectaste A La Base De Datos");
         }
           catch(java.lang.Exception e){
            showMessageDialog(null,"Error Al Al Conectar Con La Base De Datos");
        }
    }
    
    public static void cerrarRecursos(){
         try { //Se cierran todos los recursos en el orden inverso al que fueron adquiridos          
             if(rs!=null){rs.close();}
             if(st!=null){st.close();}
        } catch (Exception e) {
        }
    }
    
    public static void createST(){
        try {
            st=conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cerrarConexionBD(){
        if(conexion!=null){
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
  
    public static void Update(String codigo){ 
        
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
