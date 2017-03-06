/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principal;

import Sismo.Inicio;
import Sismo.Principal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hangtu
 */
public class File_06_Comandos extends File_04_MT implements Runnable {
    
 
    private String planificador;
    private Thread hiloArea;
    protected Principal p;
   
    
    public File_06_Comandos(JTextArea terminal, JTextArea areaProcesos,
                    JTextField txtProcesador, JTable tabla,JList txtTerminados,JTextField txtEjecuccion, Principal p ){
       super(terminal,areaProcesos,txtProcesador,tabla,txtTerminados,txtEjecuccion);
        hiloArea=new Thread(this);  
        this.p=p;
    }
    
    public void determinarComando(){
        
        if (!comando.isEmpty()){ //si comando no esta vacio 
           if(comando.contains("new")){
               if(planificador==null){
                  leerContenido("Escoja un planificador: Use Help Para Ayuda");
               }  
               else{
               try{
                String [] lineas = comando.split(" -");
                String nombre= lineas[1];    
                int t=Integer.parseInt(lineas[2]);
                               
               
                if(planificador.equals("RB")){
                    int q=Integer.parseInt(lineas[3]);
                    ingresarColaRB(id,nombre,usuario(), "Listo", t, q);
                    id++;
                }
                if(planificador.equals("FIFO")){
                    ingresarCola(id, nombre, usuario(), "Listo", t);
                    id++;
               
                }
                
                if(planificador.equals("MT")){
                    ingresarListaMT(id,nombre,usuario(),"Listo", t);
                    id++;
                }
 
               }catch(Exception ex){
                   leerContenido("No se pudo completar la operacion intente de nuevo");
               }
             } 
           }
           else if(comando.contains("del")){ 
               if(planificador==null){
                  leerContenido("Escoja un planificador use Help Para Ayuda");
               }  
               else{
               try{
                String [] lineas = comando.split(" -");
                 
                 
                if(planificador.equals("RB")){
                    destruirProcesoRB();
                }
                if(planificador.equals("FIFO")){
                    destruirProcesoCola();
                }
                
                if(planificador.equals("MT")){
                    int t=Integer.parseInt(lineas[1]);
                    destruirProcesoMT(t);
                }
 
               }catch(Exception ex){
                   System.out.println("Error");
               }
             
             }
               
           }//fin del "del"
           else if(comando.contains("s user")){
               try{
                   boolean existe=false;
                   String user[]=comando.split(" -");

                    for (int i = 0; i < listaUsers.size(); i++) {
                       if(user[1].equalsIgnoreCase(listaUsers.get(i))){
                          leerContenido("Se cambio De usario");
                          usuario=listaUsers.get(i);
                          existe=true;
                       }                       
                   }
                    if(user[1].length()<4){
                       leerContenido("El nombre tiene que ser de un minimo de 4 caracteres");
                   }
                   else if(existe==false){
                     listaUsers.add(user[1]);
                     leerContenido("Se creo el usario "+user[1]);
                   } 
                }    
               catch (Exception ex) {
                   leerContenido("Ocurrio un error al crear el usuario");
               }
           }
        else{
               
        switch(comando){
        
         case "good night": apagar();
                            break;
             
         case "clear":      limpiar();
                            break;
             
         case "show ip":    leerContenido(showIP());
                            break;
             
         case "help":       leerContenido(showComandos());
                            break;
             
      
         case "tomar":       tomarMT();
                            break;
                      
         
         case "round robin": if(planificador==null){
                                      planificador="RB";
                                      leerContenido("Se escogio Round Robin como planificador");
                                      hiloArea.start();
                                }else{leerContenido("Reinicie para cambiar de planificador");}
                               
                              break;
         
         case "fifo":       if(planificador==null){
                                      planificador="FIFO";
                                      leerContenido("Se escogio FiFo como planificador");
                                      hiloArea.start();            
                                }
                                 else{leerContenido("Reinicie para cambiar de planificador");}
                              break;
             
        case "menor tiempo": if(planificador==null){
                                      planificador="MT";
                                      leerContenido("Se Escogio Menor Tiempo como planificador");
                                      hiloArea.start();
                                }
                                 else{leerContenido("Reinicie para cambiar de planificador");}
                              break;
         
         case "show plan":    leerContenido("menor tiempo - round robin - fifo");
                              break;
         
         case "show users" : leerContenido(mostrarUser());
                                break;
         
         case "reset":        System.out.println("Reiniciando");
                              p.setVisible(false);
                              p=null;
                              new Inicio("r").setVisible(true);
                              break;
                 
         default:           leerContenido("No se reconoce "+"\""+comando +"\""+" como comando valido");
        }
       }
      }
    }   
    
    
     private void apagar(){
        System.out.println("Apagando");
         p.setVisible(false);
         new Inicio("a").setVisible(true);
     }
    
     private void limpiar(){
       contenido="";
       terminal.setText("");
    }
      
     private String showIP(){
        java.net.InetAddress v=null;
        try {
            v=InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(File_06_Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dato=v.toString();
        return dato;
    }
     
    private String mostrarUser(){
        String usr="";
        for (int i = 0; i < listaUsers.size(); i++) {
              usr=usr+listaUsers.get(i)+"\n";
        }
        return usr;
    }
     
     public String showComandos(){
        String help="";
        String [] datos = new String [11]; 
        datos[0]="show ip -> Muestra La IP De Tu Equipo";
        datos[1]="clear -> Limpiar Pantalla";
        datos[2]="help -> Muestra Todos Los Comandos";
        datos[3]="new -> Para crear un nuevo proceso inserte new -nombre -tiempo -quantum (si se necesita)";
        datos[4]="del -id -> Para Eliminar un proceso ";
        datos[5]="show procesos -> Ver lista de procesos";
        datos[6]="show users -> Ver lista de usuarios";
        datos[7]="s user -nombre -> Crear usuario & Cambiar usuario";
        datos[8]="show plan -> Muestra planificadores disponibles";
        datos[9]="reset -> Reiniciar";
        datos[10]="good night -> Salir De Sismo";
        for (int i = 0; i < datos.length; i++) {
            help = help+datos[i]+"\n";
        }
        return help;
    }

    @Override
    public void run() {
        try {
            
        while(true){ 
            if(cola.isEmpty()!=true && planificador.equals("FIFO")){
                tomarElementoCola();            
                limpiarAreaProcesos();
                MostrarListosCola();  
                Thread.sleep(1000);
                restarCola();
          } //Fin de la condicion Cola
                 
            
           if(listaMT.isEmpty()!=true && planificador.equals("MT")){
              tomarMT();
              if(procesoMT!=null){                            
                  MostrarListosMT();
                  Thread.sleep(1000);
                  restarTiempoMT();
              }     
                limpiarAreaProcesos();
                
             } 
               
          if(colaRB.isEmpty()!=true && planificador.equals("RB")){ //Si la cola no esta vacia
               tomarRB();
               MostrarListosRB();        
               for (int i = 0; i < procesoRB.getQuantum(); i++) {
                 if(procesoRB.getT()>0){
                  Thread.sleep(1000);
                  restarRB();
                  limpiarAreaProcesos();
                  MostrarListosRB();
                 }
              }
               siguienteRB(); //quitar cola
               limpiarAreaProcesos();   
          } //Fin de la condicion Cola
            
          }//Fin del While
        } catch (InterruptedException ex) {
            System.out.println("Error_File_06_Comandos");
            leerContenido("Ocurrio Un Error Grave,  Reinicie El Sistema :( ");
        }
    }     
}
