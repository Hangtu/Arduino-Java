/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comandos;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import procesos.Procesos;
import terminal.Terminal;

/**
 *
 * @author Hangtu
 */
public class Comandos {
    
    private JTextPane area;
    
    private String comando;
    private Procesos procesos;
    private String mensaje;
    
    
    private String [] operacion ={"0","1","2","3","4","5","6","7","8","9"};
    
    public Comandos(Procesos procesos){
        this.procesos=procesos;
    }
    
    public Comandos(){
        
    }
    
    public void getArea(JTextPane area){
        this.area=area;
    }
    
    
    
    public void procesar(String comando){
      boolean condicion=true;
      this.comando=comando;
      mensaje=comando;
      comando=comando.toLowerCase();  // ESTA EN VEREMOS //
      
      for (int i = 0; i < operacion.length; i++) {
             if (comando.startsWith(operacion[i])){
               String resultado=operaciones(comando);
               procesos.leerContenido(resultado);
               procesos.renovar();
               condicion=false; //Asi ya no entra al verficar los comando de abajo
        }
       }
      
      if(comando.contains("Crear")){
           area.setText("PROCESO");
      }
       
      
      if(condicion==true){
        switch(comando){
        
         case "good night": apagar();
                            break;
         case "clear":      limpiar();
                            break;
         case "show ip":    procesos.leerContenido(showIP());
                            procesos.renovar();
                            break;
         case "help":       procesos.leerContenido(showComandos());
                            procesos.renovar();
                            break;
             
         default:           procesos.leerContenido(error(mensaje));
                            procesos.renovar();
      }
     }
    }
    
    
    
    
    public void apagar(){
        System.exit(0);
    }
    
    public void limpiar(){
        procesos.limpiar();
    }
    
    public String error(String mensaje){
        String error="\""+mensaje+"\""+" no es un comando valido";
        return error;
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
        String [] datos = new String [4];
        datos[0]="good night - Salir De Sismo";
        datos[1]="show ip - Muestra La IP De Tu Equipo";
        datos[2]="clear - Limpiar Pantalla";
        datos[3]="help - Muestra Todos Los Comandos";
        for (int i = 0; i < datos.length; i++) {
            help = help+datos[i] +"\n";
        }
        return help;
    }
    
    public String  operaciones(String operacion){
         int x=0;
         int y=0;
         int valor=0;
         double division=0;
         String resultado="";
       try{
        if(comando.contains("-")){
          String [] numeros = operacion.split("-");
           x=Integer.parseInt(numeros[0]);
           y=Integer.parseInt(numeros[1]);
           valor=x-y;
           resultado=Integer.toString(valor);
          }
         else if(comando.contains("+")){
           String [] numeros = operacion.split("\\+");
           x=Integer.parseInt(numeros[0]);
           y=Integer.parseInt(numeros[1]);
           valor=x+y;
           resultado=Integer.toString(valor);
         }
         else if(comando.contains("*")){
           String [] numeros = operacion.split("\\*");
           x=Integer.parseInt(numeros[0]);
           y=Integer.parseInt(numeros[1]);
           valor=x*y;
           resultado=Integer.toString(valor);
         }
         else if(comando.contains("/")){
           String [] numeros = operacion.split("/");
           x=Integer.parseInt(numeros[0]);
           y=Integer.parseInt(numeros[1]);
           division=(double)x/y;
           resultado=Double.toString(division);
         }
         else {
             resultado = "ERROR MATEMATICO";
         }
       }catch (Exception ex){
           resultado = "Error ejemplo : 5*5 ";
       }
          return "resultado = "+resultado;
     } 
    }
  
