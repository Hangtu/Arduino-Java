/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Comandos.Comandos;
import Interfaz.Interfaz;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author Hangtu
 */
public class AreaProcesos extends Procesos {
    
   private Interfaz interfaz;
   private JTextArea areaProcesos;
   
   private String nombreProceso;
   private Thread hilo;
   private Comandos comando;
   
   public AreaProcesos(){

       
   }
   
   
   
   public  void setInterfaz(Interfaz interfaz){
        this.interfaz=interfaz;
        areaProcesos=interfaz.getAreaProcesos();
    }
   
   public  void setProcesos(Comandos comando){
        this.comando=comando;
       
    }
    
    public void  setNombreProceso(String nombreProceso){
          this.nombreProceso=nombreProceso;
          
          
    }
    public void agregarLista(){
        
         lista.add(nombreProceso);
    
    }
    
    public void BorrarLista(String palabra){
        System.out.println("ENTRO 1");
        for(String eliminar : lista){
            System.out.println("Entro a ver la lista");// este for mejorado va a recorrer toda la lista
            if(palabra.equalsIgnoreCase(eliminar)){
                int numero=lista.indexOf(eliminar);
                lista.remove(numero);
                System.out.println("SI ENTRO FOR");
            }
        }
   }
    
    public void mostrar(){
         for(int i=0;i<lista.size();i++){
                areaProcesos.append(i+" Proceso "+lista.get(i)+"\n");
        }
    } 
} //Fin de la clase
