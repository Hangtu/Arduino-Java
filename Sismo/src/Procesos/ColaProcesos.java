/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import otros.ListaProcesos;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Hangtu
 */
public class ColaProcesos extends Comandos implements Runnable{
    
 
   private Queue <Thread> cola=new LinkedList <>();
   private Thread hilo;
   private JTextArea areaProcesos;
   private Procesos1 flujo;
   
    
    public ColaProcesos (JTextArea terminal, JTextArea areaProcesos){
        super(terminal);
        this.areaProcesos=areaProcesos;
        hilo=new Thread(this);
        hilo.start();
    }
    
    public void nuevoProceso(){
        cola.offer(new Thread(flujo=new Procesos1(cola)));
    }
    
    public void MostrarTodo(){
                Object arr[]=cola.toArray();
        for (int i = 0; i < arr.length; i++) {
            areaProcesos.append(arr[i].toString()+" Proceso De "+usuarios()+" Running "+"\n");    
        }
             }
    
    public String usuarios(){
        String dato=" ";
         return dato=dato+java.lang.System.getProperty("user.name");
    }
    
    

    @Override
     
    public void run() {
        while(true){
        try {
           MostrarTodo();
           Thread.sleep(300);
           areaProcesos.setText("");
        } catch (Exception ex) {
            Logger.getLogger(ColaProcesos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
   
}
