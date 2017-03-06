/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

/**
 *
 * @author Hangtu
 */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Proxy;
import java.net.Socket;

public class DemoCliente {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        Socket s=null;
        
        try {
            s=new Socket("localhost",5432); //127.0.0.1
            oos= new ObjectOutputStream(s.getOutputStream());
            ois= new ObjectInputStream(s.getInputStream());
         
          // envio un  nombre
            oos.writeObject("Hangtu");
            
         // recibo la respuesta (el saludo personalizado)
            String ret = (String) ois.readObject();
         
        //Muestra la respuesta que envio el server
            System.out.println(ret);
            
        } catch (Exception e) {
              System.out.println("Error en el cliente");
        }
        
        finally{
            if(ois!=null) ois.close();
            if(oos!=null) oos.close();
            if(s  !=null) s.close();
        }
        
    }
    
}
