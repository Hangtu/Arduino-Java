/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principal;

import Objetos.Procesos;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hangtu
 */
public class File_02_Cola extends  File_01 {
     
    protected Procesos procesoCo;
    
    public File_02_Cola(JTextArea terminal, JTextArea areaProcesos,JTextField txtProcesador, JTable tabla){
       super(terminal,areaProcesos,txtProcesador,tabla);
    }
     
     
     
      protected void ingresarCola(int id,String usuario,String estado, int t, int q){  
         cola.offer(new Procesos(id, usuario, estado, t, q));
    }
      public void MostrarTodoCola(){
        Object arr[]=cola.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            areaProcesos.append(Integer.toString(p.getId())+"  "+p.getUser()+"  "+p.getEst()+"  " +Integer.toString(p.getT())+"  "+Integer.toString(p.getQuantum())+"\n");
        }
     }

      
      public void tomarElementoCola(){
         procesoCo=cola.peek();
         txtProcesador.setText(Integer.toString(procesoCo.getId()));
      }
      
      public void restarCola(){
          
          if(procesoCo.getT()>0){
              procesoCo.setT(procesoCo.getT()-1);
          }
          else{
              cola.remove();
              txtProcesador.setText("");
              ingresarTabla(procesoCo.getTiempoE()-1,procesoCo.getTiempoR(), 0, 100);
          }
           if(cola.size()==0){
               limpiarAreaProcesos();
           }
      }

      protected void destruirProcesoCola(){
             cola.remove();
             txtProcesador.setText("");
      }
}
