/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_Simulador;

import Objetos.Procesos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hangtu
 */
public class File_04_MT extends File_03_RB {
    
    protected Procesos procesoMT;
    private int idlista;
    
   public File_04_MT(JTextArea areaProcesos, JTextField txtProcesador, JTable tabla,
            JList txtTerminados, JTextField txtEjecuccion,JTextArea txtBloqueados ,JTable tablaMarcos) {
        super(areaProcesos,txtProcesador,tabla,txtTerminados,txtEjecuccion,txtBloqueados,tablaMarcos);
       
    }
    
     public void ingresarListaMT(int id,String nombre,String usuario,String estado, int t,int tamaño){  
          listaMT.add(id, new Procesos(id, nombre, usuario, estado, t ,tamaño));
          Procesos p=listaMT.get(idlista);
          asiginarIDS(p);
          dispositivoAleatorio(p);
          if(p.getDispositivo()!= 2 && nocompartido == true){
            p.setEst("Bloqueado");
          }
           if(p.getDispositivo()!= 2 && nocompartido == false){
            nocompartido=true;
         }
          idlista++;
    }
     
     public void MostrarListosMT(){
        Object arr[]=listaMT.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            if(p.getEst().equalsIgnoreCase("Listo")){
            areaProcesos.append(Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"  "+p.getRecurso()+"\n");
            }
        }
           MostrarBloqueadosMT();
     }
     
      public String mostrarTodoMT(){
        Object arr[]=listaMT.toArray();
        String cad="";
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            if(!p.getEst().equalsIgnoreCase("Terminado")){
            cad=cad+Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"  "+p.getRecurso()+"\n";
            }
        }
        return cad;
     } 
      
         public void MostrarBloqueadosMT(){
        Object arr[]=listaMT.toArray();
        for (int i = 0; i < arr.length; i++) {   
            Procesos p=(Procesos) arr[i];
            if(p.getEst().equalsIgnoreCase("Bloqueado")){
            txtBloqueados.append(Integer.toString(p.getId())+"  "+p.getNombre()+"  "+p.getUser()+"  "+
            p.getEst()+"  " +Integer.toString(p.getT())+"  "+p.getRecurso()+"\n");
            }
        }
     }
         
    private void recursos(){
        Object arr[]=listaMT.toArray();
        int band=0;
        for (int i = 0; i < arr.length; i++) {
            Procesos p=(Procesos) arr[i];
            if(p.getDispositivo()!=2 && band==0 && p.getBand().equals("v")){
                nocompartido=true;
                p.setEst("Listo");
                band=1;
            }
        }
     }
    
    public void restarTiempoMT(){
          int x=procesoMT.getT()-1;
          if(x<0){
           procesoMT.setT(0);
         }
         if(procesoMT.getT()>0){
            procesoMT.setT(x);
          }
    }
          
       public void tomarMT(){
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
                          p1.setBand("z");
                          liberMemoria(p1);
                          borrarIDS(p1);
                          ingresarTabla(procesoMT.getNombre(),procesoMT.getTiempoE(),procesoMT.getTiempoR(), 0, 100);
                          agregarTerminado(p1.getId(),p1.getNombre(),p1.getUser(),p1.getEst());
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
                               txtEjecuccion.setText(procesoMT.getId()+"  "+procesoMT.getNombre()+"  "+procesoMT.getEst()+"  "+procesoMT.getT()+"  "+procesoMT.getRecurso());
                         }
                         else if(!listaP.get(i).getEst().equalsIgnoreCase("listo")){
                            if(listaP.get(i).getDispositivo()==2)
                             listaP.get(i).setEst("Listo");
                            else
                             listaP.get(i).setEst("Bloqueado");
                         }
                   }
                  
               }else{
                   txtProcesador.setText("");
                   txtEjecuccion.setText("");
               }   
           }       
    }
       
    public void destruirProcesoMT(int x){
        Procesos p;
        p=listaMT.get(x);
        if(p.getT()>0){
           liberMemoria(p);
        }
        borrarIDS(p);
        p.setT(0);
        p.setEst("Terminado");
        txtProcesador.setText("");
        txtEjecuccion.setText("");
        agregarTerminado(p.getId(),p.getNombre(),p.getUser(),p.getEst());
        ingresarTabla(p.getNombre(),p.getTiempoE(),p.getTiempoR(), 0, 100);
        
    }

    public Procesos getProcesoMT() {
        return procesoMT;
    }
}



    