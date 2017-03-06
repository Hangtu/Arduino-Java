
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author synth3
 */
public class ConexionDB {
    
    
       public static Connection GetConnection(){
        Connection conexion=null;
     
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://10.43.9.19:3306";
            String usuarioDB="root";
            String passwordDB="";
            conexion= (Connection) DriverManager.getConnection(servidor,usuarioDB,passwordDB);
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,"Error en el Pool DB"+ex.getMessage(), "Error al intentar realizar la conexión con la BD ",JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error en el Pool DB"+ex.getMessage(), "Error al intentar realizar la conexión con la BD ",JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }
       
       private void Msg(String msg, Exception ex){
              JOptionPane.showMessageDialog(null,"Error en el Pool DB", "Error al intentar realizar la conexión con la BD "+ex.getMessage(),JOptionPane.ERROR_MESSAGE);
        }

}
