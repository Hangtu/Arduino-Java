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
import javax.swing.DefaultListModel;
import javax.swing.JList;
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
  protected JList txtTerminados;
  protected JTextField txtEjecuccion;
  protected JTextField txtProcesador;
  protected JTable tabla;
 
  protected ArrayList <String> listaUsers=new ArrayList<>();
  protected Queue <Procesos> cola=new LinkedList <>();
  protected Queue <Procesos> colaRB=new LinkedList <>();
  protected ArrayList <Procesos> listaMT=new ArrayList<>();
  private DefaultListModel modelo = new DefaultListModel();
  
  protected String contenido;
  private   String lineaFinal;
  protected String comando;
  protected String usuario=java.lang.System.getProperty("user.name");
  protected int id=0;

  
     public File_01(JTextArea terminal, JTextArea areaProcesos,
                    JTextField txtProcesador, JTable tabla, JList txtTerminados,JTextField txtEjecuccion ){
       this.terminal=terminal; 
       this.areaProcesos=areaProcesos;
       this.txtProcesador=txtProcesador;
       this.tabla=tabla;
       this.txtTerminados=txtTerminados;
       this.txtEjecuccion=txtEjecuccion;
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
       
     protected void limpiarAreaProcesos(){
         areaProcesos.setText("");
     }
     
     protected void agregarTerminado(int id , String nom ,String user, String est){
         modelo.addElement(id+"  "+nom+"  "+user+"  "+est);
         txtTerminados.setModel(modelo);
     }
     
     
     protected void ingresarTabla(String nom,int te,int tr,int ren ,int pro){
         DefaultTableModel modelo= (DefaultTableModel) tabla.getModel();
         Object colum []=new Object [5]; 
         colum[0]=nom;
         colum[1]=te;
         colum[2]=tr;
         colum[3]=ren;
         colum[4]=pro; 
         modelo.addRow(colum);
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
