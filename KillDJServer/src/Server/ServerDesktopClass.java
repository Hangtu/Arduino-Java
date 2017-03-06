package Server;



/**
 * A diferencia del este al anterior es que mientras el hilo atiende a el cliente el 
 * server ya esta esperando un nuevo cliente;
 * @author Hangtu 
 */
import Cases.Case1_Greet;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerDesktopClass {
    
    public static void ConnectServer() throws Exception{
        
        Socket s=null;
        ServerSocket ss= new ServerSocket(5432); // Este valor es arbitrario
        System.out.println("Server is Run "+ss.isBound());
        
   while(true){
        s=ss.accept(); //Se quedara en esta linea hasta que un cliente se haya conectado
        Thread hilo = new Thread(new Tarea(s));
        hilo.start();
     }    
    }
    
    static class Tarea extends Case1_Greet implements Runnable{
     
     private ObjectInputStream dis=null;
     private ObjectOutputStream dos=null;
     private Socket s;
      
      public Tarea(Socket s){
          this.s=s;
      }
      
        public void run() {
            try {
                System.out.println("Se conectaron desde la IP: "+s.getInetAddress());
                
                dis = new ObjectInputStream(s.getInputStream());
                dos = new ObjectOutputStream(s.getOutputStream());
                //leemos el codigo de servicio
                    int opc=dis.readInt();
                    System.out.println("caso "+opc);
                    
                    switch (opc) {
                        
                    case 1://SALUDO DE INICIO
                        this.Saludar(dis, dos);
                        break;
                        
                    case 2://REGISTRO DEL USUARIO
                         this.Registrar(dis, dos);
                         break;
                    
                    case 3: //MENSAJE DE BIENVENIDA                        
                           this.messageOfWelcome(dis, dos);
                          break;
                    default:
                         System.out.println("No Existe Esa Solicitud Al Servidor");
                }
                    
            } catch (Exception e) {
                System.out.println("Ocurrio un error");
            }
            
             finally{
                try {
                  if(dos !=null) dos.close();
                  if(dis !=null) dis.close();
                  if(s   !=null) s.close();
                System.out.println("Conexion Cerrada");
             } catch (Exception e) {
                    System.out.println("Error al cerrar las conexiones");
             }
            }
        }
   }
}


