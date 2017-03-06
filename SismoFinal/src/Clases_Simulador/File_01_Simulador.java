/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Simulador;

import Objetos.Procesos;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
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
public class File_01_Simulador {
    
  protected JTextArea areaProcesos;
  protected JList txtTerminados;
  protected JTextField txtEjecuccion;
  protected JTextField txtProcesador;
  protected JTextArea txtBloqueados;
  protected JTable tabla;
  protected JTable tablaMarcos;
 
  protected Queue <Procesos> cola=new LinkedList <>();
  protected Queue <Procesos> colaRB=new LinkedList <>();
  protected ArrayList <Procesos> listaMT=new ArrayList<>();
  private DefaultListModel modelo = new DefaultListModel();
  private int vacios [] =new int [10];
  private int idVacios [];
  private int memoria=0;
  protected boolean nocompartido=false;

    
  public File_01_Simulador(JTextArea areaProcesos, JTextField txtProcesador, JTable tabla,
          JList txtTerminados, JTextField txtEjecuccion,JTextArea txtBloqueados,JTable tablaMarcos) {
       
      this.areaProcesos=areaProcesos;
      this.txtProcesador=txtProcesador;
      this.tabla=tabla;
      this.txtTerminados=txtTerminados;
      this.txtEjecuccion=txtEjecuccion;
      this.txtBloqueados=txtBloqueados;
      this.tablaMarcos=tablaMarcos;
  }
      
   public void limpiarAreaProcesos(){
       areaProcesos.setText("");
       txtBloqueados.setText("");
   }
  
  
   public void agregarTerminado(int id , String nom ,String user, String est){
         modelo.addElement(id+"  "+nom+"  "+user+"  "+est);
         txtTerminados.setModel(modelo);
    
     }
    
     
    public void ingresarTabla(String nom,int te,int tr,int ren ,int pro){
         DefaultTableModel model= (DefaultTableModel) tabla.getModel();
         Object colum []=new Object [5]; 
         colum[0]=nom;
         colum[1]=te;
         colum[2]=tr;
         colum[3]=ren;
         colum[4]=pro; 
         model.addRow(colum);
     }
     


    public ArrayList<Procesos> getListaMT() {
        return listaMT;
    }

    public Queue<Procesos> getCola() {
        return cola;
    }

    public Queue<Procesos> getColaRB() {
        return colaRB;
    }
     
   public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
    
    
     public void limpiarMarcos(){
        for (int i = 0; i < 10; i++) {
            tablaMarcos.setValueAt("", i, 0);
        }
    }   
  
          public void liberMemoria(Procesos p){
         int calculo=memoria-p.getTamaño();
         setMemoria(calculo);
     }
     
   public void getIDMarcosVacios(){ 
        int data=0;
          for (int i = 0; i < 10; i++) {
              if(tablaMarcos.getValueAt(i, 0).equals("")){
                     vacios[i]=i;
              }
                else{vacios[i]=15;}
        }
          for (int i = 0; i < vacios.length; i++) {
              if(vacios[i]!=15){
                  data++;
              }    
          }
          idVacios=new int [data];
          data=0;
          
          for (int i = 0; i < vacios.length; i++) {
            if(vacios[i]!=15){
                idVacios[data]=vacios[i]; 
                data++;
            }
        }
    }     
      

     public void asiginarIDS(Procesos p){ 
         
         int arr[]=new int [p.getTamaño()];
         for(int i = 0; i < p.getTamaño() ; i++) {
               arr[i]=idVacios[i];
         }
         p.setPaginas(arr);
         
         for (int i = 0; i < arr.length; i++) {
             tablaMarcos.setValueAt(p.getNombre(),arr[i], 0);
         }
     }
     
     public void borrarIDS(Procesos p){
         int arr[]=p.getPaginas();
      try{
        for (int i = 0; i < arr.length; i++) {
             tablaMarcos.setValueAt("",arr[i], 0);
        }
      }catch(Exception ex){
          System.out.println("Limpiando ultimos marcos");
          limpiarMarcos();
       }
     }        
     public void dispositivoAleatorio(Procesos p){
         Random aleatorio=new Random();
         int x=aleatorio.nextInt(3);
         p.setDispositivo(x);
         if(x==2){
             p.setRecurso("compartido");
         }
         else{
             p.setRecurso("no compartido");
         }
     }
}

