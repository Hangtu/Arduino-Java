/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principal;

import Objetos.Procesos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hangtu
 */
public class File_01  {
    
  protected JTextArea terminal;
  protected JTextArea areaProcesos;
  protected JTextField txtProcesador;
  protected JTable tabla;
  protected Queue <Procesos> cola=new LinkedList <>();
  protected Queue <Procesos> colaRB=new LinkedList <>();
  protected ArrayList <Procesos> listaMT=new ArrayList<>();
  
  protected String contenido;
  private String lineaFinal;
  protected String comando;
  protected int id=0;
  
  //Gestion de Procesos
    
    protected int tiempoE;
    protected int tiempoR;
    protected int rendimiento;
    protected int procesador;
  
 
  
     public File_01(JTextArea terminal, JTextArea areaProcesos,JTextField txtProcesador, JTable tabla){
       this.terminal=terminal; 
       this.areaProcesos=areaProcesos;
       this.txtProcesador=txtProcesador;
       this.tabla=tabla;
      
    }

     protected String usuario(){
      String usuario=java.lang.System.getProperty("user.name")+">";
      return usuario;
    }
    
     public String nuevo(){
        String nuevo= "Welcome To Sismo v2.0" +"\n" +"\n"+ usuario(); ;
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
       
     protected void limpiarAreaProcesos(){
         areaProcesos.setText("");
     }
     
     protected void ingresarTabla(int te,int tr,int ren ,int pro){
         
         DefaultTableModel modelo= (DefaultTableModel) tabla.getModel();
         
         Object colum []=new Object [4]; 
         
         colum[0]=te;
         colum[1]=tr;
         colum[2]=ren;
         colum[3]=pro;
         
         modelo.addRow(colum);
         
     }
    
     public void dividirLinea(){
       try{
       comando="";
       String [] funcion=new String [2]; // contemplado el 3 para hangtu>perro>perro;  
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

    public String getComando() {
        return comando;
    }
}
