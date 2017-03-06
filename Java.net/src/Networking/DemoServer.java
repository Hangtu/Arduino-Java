/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Networking;

/**
 *
 * @author Hangtu
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DemoServer {
    
    public static void main(String[] args) throws Exception{
        
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        Socket s=null;
        ServerSocket ss= new ServerSocket(5432); // Este valor es arbitrario
        System.out.println("Se Inicio El Server");
        
        while(true){
            try {
                //El serverSocket da el socket
                s=ss.accept(); //Se quedara en esta linea hasta que un cliente se haya conectado
                
                // Informacion en la consola
                System.out.println("Se conectaron desde la IP: "+s.getInetAddress());
                
                //Enmascaro la entrada y salida de bytes
                ois = new ObjectInputStream(s.getInputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                
                //Leemos el nombre que mando el cliente
                String nom=(String) ois.readObject();
                
                //Armo el saludo personalizado que le quiero enviar
                
                String saludo= "Hola "+nom+" "+(System.currentTimeMillis()/1000);
                
                //Se envia el saludo al cliente
                  oos.writeObject(saludo);
                  System.out.println("Saludo Enviado");
                
            } catch (Exception e) {
                System.out.println("Error En El Servidor");
            }
            finally{
                if(oos !=null) oos.close();
                if(ois !=null) ois.close();
                if(s   !=null) s.close();
                System.out.println("Conexion Cerrada");
            }
        }
    }
}
