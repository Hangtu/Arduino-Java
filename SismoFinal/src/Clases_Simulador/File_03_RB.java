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
public class File_03_RB extends File_02_Cola{
    
    protected Procesos procesoRB;
    protected int resultadoT;
    
    public File_03_RB(JTextArea areaProcesos, JTextField txtProcesador, JTable tabla,
            JList txtTerminados, JTextField txtEjecuccion,JTextArea txtBloqueados ,JTable tablaMarcos) {
        super(areaProcesos,txtProcesador,tabla,txtTerminados,txtEjecuccion,txtBloqueados,tablaMarcos);
       
    }
    
      public void ingresarColaRB(int id, String nombre, String usuario,String estado, int t,int tamaño ,int q){  
        Procesos pe;
        colaRB.offer(pe=new Procesos(id, nombre, usuario, estado, t,tamaño,q));
        asiginarIDS(pe);
        dispositivoAleatorio(pe);
        if(pe.getDispositivo()!= 2 && nocompartido == true){
            pe.setEst("Bloqueado");
        }
        if(pe.getDispositivo()!= 2 && nocompartido == false){
            nocompartido=true;
        }
    }
       public String mostrarTodoRB(){
        Object arr[]=colaRB.toArray();
        String cad="";
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            cad=cad+Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"  "+p.getRecurso()+"\n";
        }
        return cad;
     }
       
      public void MostrarListosRB(){
        Object arr[]=colaRB.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            if(p.getEst().equalsIgnoreCase("Listo")){
            areaProcesos.append(Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"  "+p.getRecurso()+"\n");
            }
        }
        MostrarBloqueadosRB();
     }
    
      public void MostrarBloqueadosRB(){
        Object arr[]=colaRB.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            if(p.getEst().equalsIgnoreCase("Bloqueado")){
            txtBloqueados.append(Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"  "+p.getRecurso()+"\n");
            }
        }
     }
     private void recursos(){
        Object arr[]=colaRB.toArray();
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
         public void tomarRB(){
           procesoRB=colaRB.element();
           txtProcesador.setText(Integer.toString(procesoRB.getId()));
           procesoRB.setEst("Ejecuccion");
           txtEjecuccion.setText(procesoRB.getId()+"  "+procesoRB.getNombre()+"  "+procesoRB.getT()+"  "+procesoRB.getEst()+"  "+procesoRB.getRecurso());

      }
      
      public void restarRB(){
         int tiempo=procesoRB.getT();
         int resultado=tiempo-1;     
            if(resultado>0){
               procesoRB.setT(resultado);
               txtEjecuccion.setText(procesoRB.getId()+"  "+procesoRB.getNombre()+"  "+procesoRB.getT()+"  "+procesoRB.getEst()+"  "+procesoRB.getRecurso());
               txtProcesador.setText(Integer.toString(procesoRB.getId()));
            }
            if(resultado<=0){
                colaRB.remove();
                if(procesoRB.getBand().equals("v")){
                liberMemoria(procesoRB);
                nocompartido=false;
                borrarIDS(procesoRB);
                }
               if(procesoRB.getDispositivo()!=2){
                nocompartido=false;
                recursos();
               }
                procesoRB.setT(-1);
                procesoRB.setEst("Terminado");
                ingresarTabla(procesoRB.getNombre(),procesoRB.getTiempoE(),procesoRB.getTiempoR(), 0, 100);
                agregarTerminado(procesoRB.getId(),procesoRB.getNombre(),procesoRB.getUser(), procesoRB.getEst());
                txtProcesador.setText("");
                txtEjecuccion.setText("");
            }
      }
      
      public void siguienteRB(){
          if(procesoRB.getT()>0 && procesoRB.getDispositivo()==2){
               colaRB.remove();          
               colaRB.offer(procesoRB);
               procesoRB.setEst("Listo");
            }
      }
      
      
      public void destruirProcesoRB(){
           if(colaRB.isEmpty()!=true){
             procesoRB.setT(-1);
             procesoRB.setBand("m");
             borrarIDS(procesoRB);
             liberMemoria(procesoRB);
           }
      }


    public Procesos getProcesoRB() {
        return procesoRB;
    }
      
      
}