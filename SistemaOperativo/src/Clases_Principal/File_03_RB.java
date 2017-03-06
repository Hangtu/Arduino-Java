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
public class File_03_RB extends File_02_Cola{
    
    protected Procesos procesoRB;
    protected int resultadoT;
    
    public File_03_RB(JTextArea terminal, JTextArea areaProcesos,
                    JTextField txtProcesador, JTable tabla, JList txtTerminados,JTextField txtEjecuccion ){
       super(terminal,areaProcesos,txtProcesador,tabla,txtTerminados,txtEjecuccion);
    
    }
    
      protected void ingresarColaRB(int id, String nombre, String usuario,String estado, int t,int q){  
         colaRB.offer(new Procesos(id,nombre,usuario, estado,t,q));
    }
      public void MostrarListosRB(){
        Object arr[]=colaRB.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            if(p.getEst().equalsIgnoreCase("Listo")){
            areaProcesos.append(Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"\n");
            }
        }
     }
    
      protected void tomarRB(){
           procesoRB=colaRB.element();
           procesoRB.setEst("Ejecuccion");
      }
      
      protected void restarRB(){
         int tiempo=procesoRB.getT();
         int resultado=tiempo-1;     
            if(resultado>0){
               txtProcesador.setText(Integer.toString(procesoRB.getId()));
               txtEjecuccion.setText(procesoRB.getId()+"  "+procesoRB.getNombre()+"  "+procesoRB.getT()+"  "+procesoRB.getEst());
               procesoRB.setT(resultado);
            }
            if(resultado==0){
                procesoRB.setT(-1);
                procesoRB.setEst("Terminado");
                ingresarTabla(procesoRB.getNombre(),procesoRB.getTiempoE(),procesoRB.getTiempoR(), 0, 100);
                agregarTerminado(procesoRB.getId(),procesoRB.getNombre(),procesoRB.getUser(), procesoRB.getEst());
                txtProcesador.setText("");
                txtEjecuccion.setText("");
                colaRB.remove();
            }
      }
      
      protected void siguienteRB(){
          if(procesoRB.getT()>0){
              colaRB.remove();          
               colaRB.offer(procesoRB);
               procesoRB.setEst("Listo");
            }
      }
      
      protected void destruirProcesoRB(){
             procesoRB.setEst("Terminado");
             agregarTerminado(procesoRB.getId(),procesoRB.getNombre(),procesoRB.getUser(), procesoRB.getEst());
             cola.remove();
             txtProcesador.setText("");
             txtEjecuccion.setText("");
      }
}