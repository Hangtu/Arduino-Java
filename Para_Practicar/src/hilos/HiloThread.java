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
public class HiloThread extends Thread {
     private int x=0;
    
    public void sleep(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            x++;
        }
    }
    
    public void run(){
     while(x<=10){
         System.out.print(x+"\t"+"Hola Mundo"+"\n");
         sleep();
     }
    }
    
    public static void main(String[] args) {
           HiloThread objeto=new HiloThread();
           objeto.start();
    }
    
}
