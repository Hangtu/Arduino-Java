/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.util.StringTokenizer;
import javax.swing.JTextPane;
import Interfaz.Terminal;

/**
 *
 * @author Hangtu
 */

public class Procesos extends Terminal {
    
     private String contenido="";
     private String lineaFinal="";
    
    
    public void determinarComando(){
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
           // comando=funcion[1];
           // comandos.procesar(comando);
              renovar();
           }
          }catch(java.lang.ArrayIndexOutOfBoundsException ex){
           // comandos.procesar("default");
        }
    }
    
    public void leerContenido(String datos){
        String informacion=contenido+"\n"+datos;
        terminal1.setText(informacion);
        contenido();
        
    }
 
    public void contenido(){
      contenido=terminal1.getText();
      String cad="";
      cad=cad+contenido+"\n";
      contenido=cad;
      terminal1.setText(cad);
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
           terminal1.setText(inicio());
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
        terminal1.setText(contenido);
    }
    
    public void limpiar(){
        terminal1.setText("");
        terminal1.setText(inicio());
    }
}
