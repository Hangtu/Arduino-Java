package Networking.Sockets;



/**
 * A diferencia del este al anterior es que mientras el hilo atiende a el cliente el 
 * server ya esta esperando un nuevo cliente;
 * @author Hangtu 
 */
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server {
    
    public static void main(String[] args) throws Exception{
        
        
        Socket s=null;
        ServerSocket ss= new ServerSocket(5432); // Este valor es arbitrario
        
    while(true){
        s=ss.accept(); //Se quedara en esta linea hasta que un cliente se haya conectado
        new Tarea(s).start();
     }    
    }
    
    static class Tarea extends Thread{
     
     ObjectInputStream ois=null;
     ObjectOutputStream oos=null;
     Socket s= new Socket();
      
      public Tarea(Socket s){
          this.s=s;
      }
      
        public void run() {
            try {
                System.out.println("Se conectaron desde la IP: "+s.getInetAddress());
                
                //Enmascaro la entrada y salida de bytes
                ois = new ObjectInputStream(s.getInputStream());
                oos = new ObjectOutputStream(s.getOutputStream());
                
                //Leemos el nombre que mando el cliente
                String nom=(String) ois.readObject();
                
                //Armo el saludo personalizado que le quiero enviar
                
                String saludo= "Hola "+nom+" "+((int)System.currentTimeMillis()/1000);
                
                //Se envia el saludo al cliente
                  oos.writeObject(saludo);
                  System.out.println("Saludo Enviado");
     
            } catch (Exception e) {
                System.out.println("Ocurrio un error");
            }
             finally{
                try {
                  if(oos !=null) oos.close();
                  if(ois !=null) ois.close();
                  if(s   !=null) s.close();
                System.out.println("Conexion Cerrada");
             } catch (Exception e) {
                    System.out.println("Error al cerrar las conexiones");
             }
                
            }
        }
   }
}


