/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HSQL.ObjectsFromBD;

import HSQL.UConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hangtu
 */
public class ConsultaUsuarios {
    
    public ArrayList<Usuarios>  mostrarTodos(){
        Connection con=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        Usuarios user=null;
        ArrayList <Usuarios> lista=new ArrayList<>();
        
        try {
            con=UConnection.getConnection();
            String sql="";
            
            sql+="SELECT * FROM usuario";
            //SELECT nombre FROM usuarios WHERE idUsuario = ?
           
            pstm=con.prepareStatement(sql);
          
            //pstm.setInt(i, GETID);
            
            rs=pstm.executeQuery();
            
            while(rs.next()){
                user=new Usuarios();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setCorreo(rs.getString("correo"));
                user.setContraseña(rs.getString("contraseña"));
                lista.add(user);
            }
            
        } catch (Exception e) {
            System.out.println("Error al guardar los datos en el arrayList");
        }
        return lista;
    }
}
