/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.util.StringTokenizer;
import javax.swing.JTextArea;

/**
 *
 * @author Hangtu
 */
public class ProcesarComando extends Procesos {
  
    protected String comando;
    private boolean procesarC;
    
    public ProcesarComando(JTextArea terminal){
        super(terminal);
    }
    
    public void determinarComando(){
       comando=" ";
       procesarC=false;
        try{
        
       String [] funcion=new String [2]; 
       int i=0;
       
      
	  StringTokenizer tokens=new StringTokenizer(lineaFinal,">");
          while(tokens.hasMoreTokens()){
               funcion[i]=tokens.nextToken();
               i++;
          }
        
          if(funcion[1]==null){
            procesarC=true;
            renovar();
          }
          else{
           
            comando=funcion[1];
           
           }
          }catch(java.lang.Exception ex){
            System.out.println(" ERROR ");
        }
    }
    
        public void renovar(){
        contenido=contenido+"\n"+usuario();
        terminal.setText(contenido);
    }
        public String usuario(){
        String usuario=java.lang.System.getProperty("user.name")+">";
        return usuario;
    }

    public boolean isProcesarC() {
        return procesarC;
    }
        
}
