/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

/**
 *
 * @author Hangtu
 */
import Interfaz.Interfaz;
import Procesos.AreaProcesos;
import Procesos.Procesos;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


/**
 *
 * @author Hangtu
 */


public class Comandos {
    
   
    private Procesos procesos;
    private Interfaz objeto;
    private JTextArea areaProcesos;
    private String comando;
    private String mensaje;
    private ArrayList lista;
   
    AreaProcesos area=new AreaProcesos();
    
    
    private String [] operacion ={"0","1","2","3","4","5","6","7","8","9"};
    
    
  public  void setProcesos(Procesos procesos){
        this.procesos=procesos;
    }
  
  public  void setLista(ArrayList lista){
        this.lista=lista;
    }
   
  public  void setInterfaz(Interfaz objeto){
        this.objeto=objeto;
        this.areaProcesos=objeto.getAreaProcesos();
    }
    
    
    public void procesar(String comando){
      area.setProcesos(this);
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
      area.setInterfaz(objeto);
     
      if(comando.contains("new")){
          String [] separador = comando.split(" ");
          String nombre = separador[separador.length-1];
          
         
          
        
         lista.add(nombre);
         
         for(int i=0;i<lista.size();i++){
                areaProcesos.append(i+" Proceso "+lista.get(i)+"\n");
        }
    
         
          condicion=false;
          procesos.renovar();
      }
      if(comando.contains("delete")){
          String [] separador = comando.split(" ");
          String nombre = separador[separador.length-1];
          
          
          area.BorrarLista(nombre);
          area.mostrar();
         
          condicion=false;
          procesos.renovar();
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
         else{
             resultado = "Error Ejemplo 5+5";
         }
       }catch (Exception ex){
           resultado = "Error ejemplo : 5+5 ";
       }
          return  resultado;
     } 
             
    }