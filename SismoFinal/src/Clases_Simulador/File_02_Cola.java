/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Simulador;

import Objetos.Procesos;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hangtu
 */
public class File_02_Cola extends  File_01_Simulador {
     
    protected Procesos procesoCo;
    
  public File_02_Cola(JTextArea areaProcesos, JTextField txtProcesador, JTable tabla,
            JList txtTerminados, JTextField txtEjecuccion,JTextArea txtBloqueados ,JTable tablaMarcos) {
        super(areaProcesos,txtProcesador,tabla,txtTerminados,txtEjecuccion,txtBloqueados,tablaMarcos);
       
    }
     
      public void ingresarCola(int id,String nombre,String usuario,String estado, int t ,int tamaño){
        Procesos p;
        cola.offer(p=new Procesos(id, nombre, usuario, estado, t,tamaño));
        asiginarIDS(p);
        dispositivoAleatorio(p);
        if(p.getDispositivo()!= 2 && nocompartido == true){
            p.setEst("Bloqueado");
        }
        if(p.getDispositivo()!= 2 && nocompartido == false){
            nocompartido=true;
        }
     
    }
      
       public String mostrarTodoCola(){
        Object arr[]=cola.toArray();
        String cad="";
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            cad=cad+Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"  "+p.getRecurso()+"\n";
        }
        return cad;
     }
       
      public void MostrarListosCola(){
        Object arr[]=cola.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            if(p.getEst().equalsIgnoreCase("Listo")){
            areaProcesos.append(Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"  "+p.getRecurso()+"\n");
            }
        }
     }
      
       public void MostrarBloqueadosCola(){
        Object arr[]=cola.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            if(p.getEst().equalsIgnoreCase("Bloqueado")){
            txtBloqueados.append(Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"  "+p.getRecurso()+"\n");
            }
        }
     }
       
        private void recursos(){
        Object arr[]=cola.toArray();
        int band=0;
        for (int i = 0; i < arr.length; i++) {
            Procesos p=(Procesos) arr[i];
            if(p.getDispositivo()!=2 && band==0){
                nocompartido=true;
                p.setEst("Listo");
                band=1;
            }
        }
     }
      
      public void tomarElementoCola(){
         procesoCo=cola.element();
         procesoCo.setEst("Ejecuccion");
         txtEjecuccion.setText(procesoCo.getId()+"  "+procesoCo.getNombre()+"  "+procesoCo.getT()+"  "+procesoCo.getEst()+"  "+procesoCo.getRecurso());
         txtProcesador.setText(Integer.toString(procesoCo.getId()));
      }
      
      public void restarCola(){
          if(procesoCo.getT()>0){
              procesoCo.setT(procesoCo.getT()-1);
          }
          else{
             
             cola.remove();
               if(procesoCo.getDispositivo()!=2){
                nocompartido=false;
                recursos();
               }
              procesoCo.setEst("Terminado");
              liberMemoria(procesoCo);
              agregarTerminado(procesoCo.getId(),procesoCo.getNombre(),procesoCo.getUser(), procesoCo.getEst());
              borrarIDS(procesoCo);
              txtProcesador.setText("");
              txtEjecuccion.setText("");
              ingresarTabla(procesoCo.getNombre(),procesoCo.getTiempoE()-1,procesoCo.getTiempoR(), 0, 100);
              
              procesoCo=null;
          }
           if(cola.size()==0){
               limpiarAreaProcesos();
           }
      }

     public void destruirProcesoCola(){
         if(!cola.isEmpty()==true){
             procesoCo.setEst("Terminado");
             liberMemoria(procesoCo);
             borrarIDS(procesoCo);
             ingresarTabla(procesoCo.getNombre(),procesoCo.getTiempoE()-1,procesoCo.getTiempoR(), 0, 100);
             agregarTerminado(procesoCo.getId(),procesoCo.getNombre(),procesoCo.getUser(), procesoCo.getEst());
             cola.remove();
             txtProcesador.setText("");
             txtEjecuccion.setText("");
         }
      }
}
