/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cases;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hangtu
 */
public class Case3_Welcome {

    
    
    private static String mensaje="Bienvenido";
    
     protected void messageOfWelcome(ObjectInputStream dis, ObjectOutputStream dos){
         try {
       
                   dos.writeObject(mensaje);
         } catch (IOException ex) {
             Logger.getLogger(Case3_Welcome.class.getName()).log(Level.SEVERE, null, ex);
         }  
    }
     
     public static void setMensaje(String mensaje) {
        Case3_Welcome.mensaje = mensaje;
    }
}