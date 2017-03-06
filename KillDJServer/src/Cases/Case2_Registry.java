/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cases;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hangtu
 */
public class Case2_Registry extends Case3_Welcome {
    
    
    protected void Registrar(ObjectInputStream dis, ObjectOutputStream dos){
        try {
            Connection con=null;
            PreparedStatement pstm=null;
            ArrayList <String> list=null;
            String sql="";
            list= (ArrayList) dis.readObject();
            con=Connections.UConnection.getConnection();
            
            System.out.println("llego aqui");
            sql+="INSERT INTO USUARIO (idUsuario, nombre, apellido , contraseña, correo) ";
            sql+="VALUES(?,?,?,?,?) ";   
            pstm=con.prepareStatement(sql);
            
            pstm.setInt(1, 0);
            pstm.setString(2,list.get(0));
            pstm.setString(3,list.get(1));
            pstm.setString(4,list.get(2));
            pstm.setString(5, list.get(3));
            
            int res=pstm.executeUpdate();
            
            if (res==1) {
                System.out.println("Se Insertaron Los Datos");
                 dos.writeObject("Registro Completado");
            } else {
                System.out.println("Error Al Insertar Los Datos");
            }
        
 
        } catch (SQLException ex) {
            Logger.getLogger(Case2_Registry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Case2_Registry.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Case2_Registry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }

