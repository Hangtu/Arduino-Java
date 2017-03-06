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
public class File_03_RB extends File_02_Cola{
    
    protected Procesos procesoRB;
    protected int resultadoT;
    
    public File_03_RB(JTextArea terminal, JTextArea areaProcesos,JTextField txtProcesador, JTable tabla){
       super(terminal,areaProcesos,txtProcesador,tabla);
    }
    
      protected void ingresarColaRB(int id,String usuario,String estado, int t, int q){  
         colaRB.offer(new Procesos(id, usuario, estado, t, q));
    }
      public void MostrarTodoColaRB(){
        Object arr[]=colaRB.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            areaProcesos.append(Integer.toString(p.getId())+"  "+p.getUser()+"  "+p.getEst()+"  " +Integer.toString(p.getT())+"  "+Integer.toString(p.getQuantum())+"\n");
        }
     }
    
      protected void tomarRB(){
           procesoRB=colaRB.element();
           txtProcesador.setText(Integer.toString(procesoRB.getId()));
           procesoRB.setEst("Ejecuccion");
      }
      
      protected void restarRB(){
         int tiempo=procesoRB.getT();
         int resultado=tiempo-1;     
            if(resultado>0){
               procesoRB.setT(resultado);
            }
            if(resultado==0){
                procesoRB.setT(-1);
                ingresarTabla(procesoRB.getTiempoE(),procesoRB.getTiempoR(), 0, 100);
                txtProcesador.setText("");
                colaRB.remove();
            }
      }
      
      protected void siguienteRB(){
          if(procesoRB.getT()>0){
              colaRB.remove();          
               colaRB.offer(procesoRB);
               procesoRB.setEst("Bloqueado");
            }
      }
      
      
      protected void destruirProcesoRB(){
            colaRB.remove();
            txtProcesador.setText("");
      }
}