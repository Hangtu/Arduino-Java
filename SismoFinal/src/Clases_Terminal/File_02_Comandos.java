/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Terminal;


import Clases_Simulador.File_05_Data;
import Frames.Inicio;
import Frames.Simulador;
import Frames.Terminal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;


/**
 *
 * @author Hangtu
 */
public class File_02_Comandos extends File_01_Terminal implements Runnable {
    
 
    private String planificador;
    private int quantum=0;
    private Thread hiloArea;
    private int ram=10;
 
    public File_02_Comandos(JTextArea terminal, Terminal term , File_05_Data dato, Simulador sim){
        super(terminal,term,dato,sim);
        hiloArea=new Thread(this);  

    }
   
    public void determinarComando(){
        
        if (!comando.isEmpty()==true){ //si comando no esta vacio 
           if(comando.contains("new")){
               if(planificador==null){
                  leerContenido("Escoja un planificador: Use Help Para Ayuda");
               }  
               else{
               try{
                String [] lineas = comando.split(" -");
                String nombre= lineas[1];    
                int tiempo=Integer.parseInt(lineas[2]);
                int tamaño=Integer.parseInt(lineas[3]);
                int calculo=tamaño+simulador.getMemoria();
                
                if(simulador.getMemoria()<ram && calculo<=ram ){               
                
                  if(planificador.equals("RB")){
                    simulador.getIDMarcosVacios();
                    if(quantum==0){
                     quantum=Integer.parseInt(lineas[4]);
                     leerContenido("Se definio un quantum de "+quantum);
                    }
                    if(quantum>0){
                    simulador.setMemoria(calculo); //asignamos el tamaño del proceso a la mmp
                    simulador.ingresarColaRB(id,nombre,usuario(), "Listo", tiempo, tamaño, quantum);
                    leerContenido("Se creo el proceso "+nombre);
                    id++;
                    }else{
                    leerContenido("Error en el quantum vuelva a introducirlo");
                    quantum=0;
                    }
                }
                  
                if(planificador.equals("FIFO")){
                    simulador.setMemoria(calculo);
                    simulador.getIDMarcosVacios();
                    simulador.ingresarCola(id, nombre, usuario(), "Listo", tiempo,tamaño);
                    leerContenido("Se creo el proceso "+nombre);
                    id++;
               
                }
                
                if(planificador.equals("MT")){
                    simulador.setMemoria(calculo);
                    simulador.getIDMarcosVacios();
                    simulador.ingresarListaMT(id,nombre,usuario(),"Listo", tiempo,tamaño);
                    leerContenido("Se creo el proceso "+nombre);
                    id++;
                }
                
                }else{leerContenido("Memoria Insuficiente");}
 
               }catch(Exception ex){
                   System.out.println("Error En Crear Proceso");
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
                   simulador.destruirProcesoRB();
                }
                if(planificador.equals("FIFO")){
                    simulador.destruirProcesoCola();
                }
                
                if(planificador.equals("MT")){
                    int t=Integer.parseInt(lineas[1]);
                    simulador.destruirProcesoMT(t);
                }
                
                leerContenido("Se borro el proceso ");
 
               }catch(Exception ex){
                   System.out.println("Error al borrar procesos");
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
                   System.out.println("Error en crear User");
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
        
         case "show procesos" : if(planificador.equals("FIFO")){
                                leerContenido(simulador.mostrarTodoCola());
                                }
                                else if(planificador.equals("RB")){
                                leerContenido(simulador.mostrarTodoRB());
                                }
                                else if(planificador.equals("MT")){
                                leerContenido(simulador.mostrarTodoMT());
                                }
                                break;
         
         case "reset":        System.out.println("Reiniciando");
                              term.setVisible(false);
                              sim.setVisible(false);
                              term=null;
                              sim=null;
                              hiloArea.interrupt();
                              new Inicio("r").setVisible(true);
                              break;
                 
         default:           leerContenido("No se reconoce "+"\""+comando +"\""+" como comando valido");
        }
       }
      }
    }   
    
    
     private void apagar(){
        System.out.println("Apagando");
         term.setVisible(false);
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
            Logger.getLogger(File_02_Comandos.class.getName()).log(Level.SEVERE, null, ex);
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
        datos[3]="new -> Para crear un nuevo proceso inserte new -nombre -tiempo -tamaño -quantum (si se necesita)";
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
            if(simulador.getCola().isEmpty()!=true && planificador.equals("FIFO")){
                simulador.tomarElementoCola();            
                simulador.limpiarAreaProcesos();
                simulador.MostrarListosCola();  
                simulador.MostrarBloqueadosCola();
                Thread.sleep(1000);
                System.out.println(simulador.getMemoria());
                simulador.restarCola();
          } //Fin de la condicion Cola
                 
            
           if(simulador.getListaMT().isEmpty()!=true && planificador.equals("MT")){
              simulador.tomarMT();
              if(simulador.getProcesoMT()!=null){                            
                  simulador.MostrarListosMT();
                  Thread.sleep(1000);
                  System.out.println(simulador.getMemoria());
                  simulador.restarTiempoMT();
              }     
                simulador.limpiarAreaProcesos();
             } 
               
           if(simulador.getColaRB().isEmpty()!=true && planificador.equals("RB")){ //Si la cola no esta vacia
               simulador.tomarRB();
               simulador.MostrarListosRB();        
               for (int i = 0; i <simulador.getProcesoRB().getQuantum(); i++) {
                 if(simulador.getProcesoRB().getT()>0){
                  Thread.sleep(1000);
                  simulador.restarRB();
                  simulador.limpiarAreaProcesos();
                  simulador.MostrarListosRB();
                 }
                 if(simulador.getProcesoRB().getDispositivo()!=2){
                     while(simulador.getProcesoRB().getT()>0){
                         Thread.sleep(1000);
                         simulador.restarRB();
                         simulador.limpiarAreaProcesos();
                         simulador.MostrarListosRB();
                     }
                 }
              }
               System.out.println(simulador.getMemoria());
               simulador.siguienteRB(); //quitar cola
               simulador.limpiarAreaProcesos();   
          } //Fin de la condicion Cola
            
          }//Fin del While
        } catch (InterruptedException ex) {
            System.out.println("Error_File_06_Comandos_HILO o Reinicio De Sistema");
            leerContenido("Ocurrio Un Error Grave,  Reinicie El Sistema :( ");
        }
    }     
    
}
