/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hangtu
 */
public class Procesos1 implements Runnable {
    Queue cola;
    Thread hilo;
    
      public Procesos1 (Queue cola){
          this.cola=cola;   
          hilo=(Thread) cola.peek();
          hilo=new Thread(this);
          hilo.start();
          
      }
    //@Override

    @Override
    public void run() {
        try {
  
            Thread.sleep(5000);
            cola.poll();
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesos1.class.getName()).log(Level.SEVERE, null, ex);
        }
        terminar();
    }
   
            public void terminar(){      
            if(!cola.isEmpty()){
             System.out.println(hilo+" Termino");
         }
        }   
    
}
