/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Terminal;

import Clases_Simulador.File_05_Data;
import Frames.Simulador;
import Frames.Terminal;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JTextArea;


/**
 *
 * @author Hangtu
 */
public class File_01_Terminal {
    
  protected JTextArea terminal;
  protected Terminal term;
  protected File_05_Data simulador;
  protected ArrayList <String> listaUsers=new ArrayList<>();
  protected Simulador sim;

  
  protected String contenido;
  private   String lineaFinal;
  protected String comando;
  protected String usuario=java.lang.System.getProperty("user.name");
  protected int id=0;



  
     public File_01_Terminal(JTextArea terminal,Terminal term ,File_05_Data dato  ,Simulador sim){
      
       this.terminal=terminal;
       this.term=term;
       this.simulador=dato;
       this.sim=sim;
       listaUsers.add(usuario);
    }

    protected String usuario(){
       return usuario+">";
    }
    
     public String nuevo(){
        String nuevo= "Welcome To Sismo v3.0" +"\n" +"\n"+ usuario(); ;
        return nuevo;
     }
    
     public void leerLinea(){
      contenido=terminal.getText();
      String [] lineas = contenido.split("\n");
      lineaFinal=lineas[lineas.length-1];
    }    
     
     public void renovar(){
       terminal.setText(contenido+"\n"+usuario());
    }
     
     public void leerContenido(String datos){
        contenido=contenido+"\n"+datos+"\n";
    }

     public void dividirLinea(){
       try{
       comando="";
       String [] funcion=new String [2]; //pendiente : hangtu>perro>perro;  
       int i=0;
       
        StringTokenizer tokens=new StringTokenizer(lineaFinal,">");
         
         while(tokens.hasMoreTokens()){       
              funcion[i]=tokens.nextToken();
               i++;     
          }
          if(funcion[1]==null){
          }
          else{
            comando=funcion[1];
          }
         }
     catch(Exception ex){
         System.out.println("Error File_01_dividirLinea");
    } 
   }
}
