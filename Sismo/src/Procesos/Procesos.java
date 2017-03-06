/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import javax.swing.JTextArea;

/**
 *
 * @author Hangtu
 */
public class Procesos extends Padre{
    
    protected String contenido="";
    protected String lineaFinal="";
    
    public Procesos(JTextArea terminal){
        super(terminal);
    }
    
      public String inicio(){
        String usuario="Sistema Operativo Sismo v1.1"+"\n"+"\n";
        usuario+=java.lang.System.getProperty("user.name")+">";
        return usuario;
    }
      
      public void contenido(){
      contenido=terminal.getText();
      String cad="";
      cad=cad+contenido+"\n"; //SALTO
      contenido=cad;
      terminal.setText(cad);
      leerUltimaLinea();
    }
      
       public void leerUltimaLinea(){
       try{
        String [] lineas = contenido.split("\n");
         lineaFinal=lineas[lineas.length-1];
       }catch(java.lang.Exception ex){
          System.out.println("Regenerando linea");
          terminal.setText(inicio());
       }
    }    
       
        public void leerContenido(String datos){
        String informacion=contenido+datos;
        terminal.setText(informacion);
        contenido();
    }
    
}
