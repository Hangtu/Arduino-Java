/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Hangtu
 */
public class Comandos extends ProcesarComando {
    
     private String [] operacion ={"0","1","2","3","4","5","6","7","8","9"};
     private boolean bProcesos;
     protected String nombreProceso;
    
     public Comandos(JTextArea terminal){
        super(terminal);
    }
    
    public void listaComandos(){
        nombreProceso="";
        bProcesos=false;
        
        try{
        if(comando.contains("new")){
           bProcesos=true;
           String nombre[]=comando.split(" ");
           nombreProceso=nombre[nombre.length-1];
           renovar();
        }    
            
        if(bProcesos==false){
        switch(comando){
        
         case "good night": apagar();
                            break;
             
         case "clear":      limpiar();
                            break;
             
         case "show ip":    leerContenido(showIP());
                            renovar();
                            break;
             
         case "help":       leerContenido(showComandos());
                            renovar();
                            break;
        
         default:           leerContenido("No se reconoce "+"\""+comando +"\""+" como comando");
                            renovar() ;
      }
    } //fin del if
        
        } catch(java.lang.Exception ex){
            System.out.println("Renovando en Comandos");
        }
    }
     
    public void apagar(){
        System.exit(0);
    }
    
      public void limpiar(){
        terminal.setText("");
        terminal.setText(inicio());
    }
    
    public String showIP(){
        java.net.InetAddress v=null;
        try {
            v=InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Comandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dato=v.toString();
        return dato;
    }
    
        public String showComandos(){
        String help="";
        String [] datos = new String [5];
        datos[0]="good night - Salir De Sismo";
        datos[1]="show ip - Muestra La IP De Tu Equipo";
        datos[2]="clear - Limpiar Pantalla";
        datos[3]="help - Muestra Todos Los Comandos";
        datos[4]="new - Crea Nuevo Proceso";
        for (int i = 0; i < datos.length; i++) {
            help = help+datos[i] +"\n";
        }
        return help;
    }

    public boolean isbProcesos() {
        return bProcesos;
    }
        
}
