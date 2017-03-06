/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principal;

import Objetos.Procesos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hangtu
 */
public class File_04_MT extends File_03_RB {
    
    protected Procesos procesoMT;
    
    public File_04_MT(JTextArea terminal, JTextArea areaProcesos,JTextField txtProcesador, JTable tabla){
       super(terminal,areaProcesos,txtProcesador,tabla);
    }
    
     protected void ingresarListaMT(int id,String usuario,String estado, int t, int q){  
          listaMT.add(id, new Procesos(id, usuario, estado, t, q));
    }
     
    protected void mostrarTodoMT(){
          for (int i = 0; i < listaMT.size(); i++) {
          Procesos p=listaMT.get(i);
          areaProcesos.append(Integer.toString(p.getId())+"  "+p.getUser()+"  "+p.getEst()+"  " +Integer.toString(p.getT())+"  "+Integer.toString(p.getQuantum())+"\n");
        }
      }
    
    protected void restarTiempoMT(){
        
          int x=procesoMT.getT()-1;
         
          if(x<0){
           procesoMT.setT(0);
         }
         if(procesoMT.getT()>0){
            procesoMT.setT(x);
          }
      
    }
          
       protected void tomarMT(){
         
           Procesos p1;
         
           ArrayList <Integer> lista=new ArrayList<>();
           ArrayList <Procesos> listaP=new ArrayList<>();
           Comparator<Integer> comparador = Collections.reverseOrder();
           
           if(listaMT.isEmpty()!=true){
               for (int i = 0; i < listaMT.size(); i++) {
                      p1=listaMT.get(i);       
                      if(p1.getT()>0 ){
                          lista.add(p1.getT());
                          listaP.add(p1);
                      }
                      else if(!p1.getEst().equals("Terminado")){
                          p1.setEst("Terminado");
                          ingresarTabla(procesoMT.getTiempoE(),procesoMT.getTiempoR(), 0, 100);
                      }
               }
               //Si el tiempo de la lista coincide con el tiempo del proceso
               if(lista.isEmpty()!=true){
                  Collections.sort(lista,comparador);
                     for (int i = 0; i <lista.size(); i++) {
                         if(lista.get(lista.size()-1)==listaP.get(i).getT()){
                               procesoMT=listaP.get(i);
                               txtProcesador.setText(Integer.toString(procesoMT.getId()));
                               procesoMT.setEst("Ejecuccion");
                         }
                         else if(!listaP.get(i).getEst().equalsIgnoreCase("listo")){
                              listaP.get(i).setEst("Bloqueado");
                         }
                   }
               }else{
                   txtProcesador.setText("");
               }   
           }       
    }
       
    protected void destruirProcesoMT(int x){
       Procesos p;
        p=listaMT.get(x);
        p.setT(0);
        p.setEst("Terminado");
    }
}



    