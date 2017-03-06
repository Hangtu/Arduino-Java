/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principal;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   
    
    public File_06_Comandos(JTextArea terminal, JTextArea areaProcesos,JTextField txtProcesador, JTable tabla){
        super(terminal,areaProcesos,txtProcesador,tabla);
        hiloArea=new Thread(this);  
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
                 int t=Integer.parseInt(lineas[1]);
                 int q=Integer.parseInt(lineas[2]);
               
                if(planificador.equals("RB")){
                    ingresarColaRB(id, usuario(), "Listo", t, q);
                    id++;
                }
                if(planificador.equals("FIFO")){
                    ingresarCola(id, usuario(), "Listo", t, q);
                    id++;
               
                }
                
                if(planificador.equals("MT")){
                    ingresarListaMT(id,usuario(),"Listo", t, q);
                    id++;
                }
 
               }catch(Exception ex){
                   leerContenido("No se pudo completar la operacion intente de nuevo");
               }
             } //fin del else
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
             
        case "mostrar":     limpiarAreaProcesos();
                            mostrarTodoMT();
                            break;
      
        case "tomar":       tomarMT();
                            break;
                      
         
         case "round robin": if(planificador==null){
                                      planificador="RB";
                                      hiloArea.start();
                                }
                              break;
         
         case "fifo":       if(planificador==null){
                                      planificador="FIFO";
                                      hiloArea.start();            
                                }
                              break;
             
         case "menor tiempo": if(planificador==null){
                                      planificador="MT";
                                      hiloArea.start();
                                }
                              break;
         
         case "show plan":    leerContenido("menor tiempo - round robin - fifo");
                              break;
                 
             
         default:           leerContenido("No se reconoce "+"\""+comando +"\""+" como comando valido");
        }
       }
      }
    }   
    
    
     private void apagar(){
        System.exit(0);
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
     
     public String showComandos(){
        String help="";
        String [] datos = new String [7];
        datos[0]="good night - Salir De Sismo";
        datos[1]="show ip - Muestra La IP De Tu Equipo";
        datos[2]="clear - Limpiar Pantalla";
        datos[3]="help - Muestra Todos Los Comandos";
        datos[4]="new - Para crear un nuevo proceso inserte new -t -q";
        datos[5]="del id- Para Eliminar un proceso ";
  //      datos[6]="show procesos - Ver lista de procesos";
  //      datos[7]="user -Crear usuario";
        datos[6]="show plan- Muestra planificadores disponibles";
        for (int i = 0; i < datos.length; i++) {
            help = help+datos[i]+"\n";
        }
        return help;
    }

    @Override
    public void run() {
        try {
            
        while(true){ 
          if(cola.isEmpty()!=true && planificador.equals("FIFO")){ //Si la cola no esta vacia
               
                tomarElementoCola();
                procesoCo.setEst("Ejecuccion");
                limpiarAreaProcesos();
                MostrarTodoCola();
                Thread.sleep(1000);
                restarCola();
                
          } //Fin de la condicion Cola
           
            
           if(listaMT.isEmpty()!=true && planificador.equals("MT")){
              tomarMT();
              if(procesoMT!=null){                            
           
                  mostrarTodoMT();
                  Thread.sleep(1000);
                  restarTiempoMT();
              }     
                limpiarAreaProcesos();
                
             } 
               
          if(colaRB.isEmpty()!=true && planificador.equals("RB")){ //Si la cola no esta vacia
               tomarRB();
               MostrarTodoColaRB();        
              // Thread.sleep(procesoRB.getQuantum()*1000);
               for (int i = 0; i < procesoRB.getQuantum(); i++) {
                 if(procesoRB.getT()>0){
                  Thread.sleep(1000);
                  restarRB();
                  limpiarAreaProcesos();
                  MostrarTodoColaRB();
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
