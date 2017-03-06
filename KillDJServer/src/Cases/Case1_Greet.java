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
public class Case1_Greet extends Case2_Registry{

    protected void Saludar(ObjectInputStream dis, ObjectOutputStream dos){
        try {
               
            String name= (String) dis.readObject();
            String saludo= "Hola "+name+" "+((int)System.currentTimeMillis()/1000);
               
               //Se envia el saludo al cliente
                 dos.writeObject(saludo);
                 System.out.println(saludo);
                 System.out.println("Saludo Enviado");
        
        } catch (IOException ex) {
            Logger.getLogger(Case1_Greet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Case1_Greet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

