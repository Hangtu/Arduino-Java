/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

/**
 *
 * @author Hangtu
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

   
   private static String mensaje;
   
    public static boolean tryConnection(){
      boolean conexion=false;
        try {
             Socket s= new Socket("localhost",5432);
             conexion=s.isConnected();
             
            
        } catch (Exception ex) {
              conexion=false;
        }
        System.out.println("La Conexion Con El Server Es "+conexion);
        return conexion;
    }
        
    public static void sendServer(int caso, Object datum) throws Exception{
        
        ObjectInputStream dis=null;
        ObjectOutputStream dos=null;
        Socket s=null;

        try {
        
            s=new Socket("localhost",5432); //127.0.0.1
           
            dos= new ObjectOutputStream(s.getOutputStream());
            dis= new ObjectInputStream(s.getInputStream());
           
            
          if(caso==1){//SALUDO CON NOMBRE
               dos.writeInt(caso);
               dos.writeObject(datum);
               System.out.println(dis.readObject());
          }
          if(caso==2){// REGISTRAR
               dos.writeInt(caso);
               dos.writeObject(datum);
          }
          
          if(caso==3){//MENSAJE DE BIENVENIDA
                //MANDA EL DATUM AUNQUE NO MANDES NADA  EL SERVER SE QUEDA ESPERANDO
                dos.writeInt(caso);
                dos.writeObject(datum);
                mensaje=(String)dis.readObject();
          }
          
         // recibo la respuesta (el saludo personalizado)       
        } catch (Exception e) {
              System.out.println("Error Al Mandar Datos Al Servidor");
        }
        
        finally{
            if(dis!=null) dis.close();
            if(dos!=null) dos.close();
            if(s  !=null) s.close();
        }
    }
   
    
     public static String getMensaje() {
        return mensaje;
    }
}
