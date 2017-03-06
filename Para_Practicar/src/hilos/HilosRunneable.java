/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hangtu
 */
public class HilosRunneable implements Runnable{
      
    public void sleep(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosRunneable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
          for(int i=0;i<=10;i++){
              System.out.print(i+"\t"+"Hola Mundo"+"\n");
              sleep();
          }
    }
    
    public static void main(String[] args) throws Exception {
        Thread objeto=new Thread(new HilosRunneable());
        Thread objeto1=new Thread(new HilosRunneable());
        Thread objeto2=new Thread(new HilosRunneable());
        
        objeto.start();
        objeto1.start();
        objeto2.start();
        
        
        // Esperar a que finalice un Thread
        
        objeto.join();
        objeto1.join();
        objeto2.join();
    }
    
}
