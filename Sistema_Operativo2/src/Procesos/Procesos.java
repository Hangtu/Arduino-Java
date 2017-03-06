/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Comandos.Comandos;
import Interfaz.Interfaz;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JTextPane;

  
/**
 *
 * @author Hangtu
 */
public class Procesos {
    
    protected ArrayList <String> lista = new ArrayList <String> ();;
      
    private Interfaz interfaz;
    private JTextPane terminal;
    
    private String contenido="";
    private String lineaFinal="";

    public Procesos() {
        
    }
    

public  void setInterfaz(Interfaz interfaz){
        this.interfaz=interfaz;
        terminal=interfaz.getTerminal();
        
    }

       public void determinarComando(){
       Comandos comandos=new Comandos();
       comandos.setProcesos(this);
       comandos.setInterfaz(interfaz);
       comandos.setLista(lista);
       String [] funcion=new String [2];
       String comando="";
       int i=0;
       try{
	  StringTokenizer tokens=new StringTokenizer(lineaFinal,">");
          while(tokens.hasMoreTokens()){
               funcion[i]=tokens.nextToken();
               i++;
          }
        
          if(funcion[1]==null){
            renovar();
          }
          else{
            comando=funcion[1];
            comandos.procesar(comando);
           }
          }catch(java.lang.ArrayIndexOutOfBoundsException ex){
           comandos.procesar("default");
        }
    }
    
    public void leerContenido(String datos){
        String informacion=contenido+"\n"+datos;
        terminal.setText(informacion);
        contenido();
        
    }
 
    public void contenido(){
      contenido=terminal.getText();
      String cad="";
      cad=cad+contenido+"\n";
      contenido=cad;
      terminal.setText(cad);
      this.leerUltimaLinea();
    }
    
    public void leerUltimaLinea(){
       try{
        String [] lineas = contenido.split("\n");
        String lineaFinal=lineas[lineas.length-1];
        System.out.println("Linea:"+lineaFinal);
        this.lineaFinal=lineaFinal;
       }catch(java.lang.ArrayIndexOutOfBoundsException ex){
           System.out.println("Regenerando linea");
           terminal.setText(inicio());
       }
    }    
    
    public String inicio(){
        String usuario="Sistema Operativo Sismo v1.1"+"\n"+"\n";
        usuario+=java.lang.System.getProperty("user.name")+">";
        return usuario;
    }
    
    public String usuario(){
        String usuario=java.lang.System.getProperty("user.name")+">";
        return usuario;
    }
   
    public void renovar(){
        contenido=contenido+"\n"+this.usuario();
        terminal.setText(contenido);
    }
    
    public void limpiar(){
        terminal.setText("");
        terminal.setText(inicio());
    }
    
}
  
