/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Principal;

import Objetos.Procesos;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hangtu
 */
public class File_02_Cola extends  File_01 {
     
    protected Procesos procesoCo;
    
    public File_02_Cola(JTextArea terminal, JTextArea areaProcesos,
                    JTextField txtProcesador, JTable tabla, JList txtTerminados,JTextField txtEjecuccion ){
       super(terminal,areaProcesos,txtProcesador,tabla,txtTerminados,txtEjecuccion);
    }
     
      protected void ingresarCola(int id,String nombre,String usuario,String estado, int t){  
         cola.offer(new Procesos(id, nombre, usuario, estado, t));
    }
      
      public void MostrarListosCola(){
        Object arr[]=cola.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            if(p.getEst().equalsIgnoreCase("Listo")){
            areaProcesos.append(Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"\n");
            }
        }
     }
      

      

      public void tomarElementoCola(){
         procesoCo=cola.peek();
         procesoCo.setEst("Ejecuccion");
         txtEjecuccion.setText(procesoCo.getId()+"  "+procesoCo.getNombre()+"  "+procesoCo.getT()+"  "+procesoCo.getEst());
         txtProcesador.setText(Integer.toString(procesoCo.getId()));
      }
      
      public void restarCola(){
          
          if(procesoCo.getT()>0){
              procesoCo.setT(procesoCo.getT()-1);
          }
          else{
              procesoCo.setEst("Terminado");
              agregarTerminado(procesoCo.getId(),procesoCo.getNombre(),procesoCo.getUser(), procesoCo.getEst());
              cola.remove();
              txtProcesador.setText("");
              txtEjecuccion.setText("");
              ingresarTabla(procesoCo.getNombre(),procesoCo.getTiempoE()-1,procesoCo.getTiempoR(), 0, 100);
          }
           if(cola.size()==0){
               limpiarAreaProcesos();
           }
      }

      protected void destruirProcesoCola(){
             procesoCo.setEst("Terminado");
             agregarTerminado(procesoCo.getId(),procesoCo.getNombre(),procesoCo.getUser(), procesoCo.getEst());
             cola.remove();
             txtProcesador.setText("");
             txtEjecuccion.setText("");
      }
}
