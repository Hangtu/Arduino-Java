/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import javax.swing.JTextField;

/**
 *
 * @author Hangtu
 */
public class Hilo extends java.lang.Thread {
    
    JTextField elCampo;
    private int x=0;
    private boolean estado=true;
    public Hilo (javax.swing.JTextField Campo){
          elCampo=Campo;
    }
 
    public void run(){
         while(estado){
          incrementar();
          System.out.println(x);
         }
    }
    
    public void incrementar(){
        x=x+1;
        elCampo.setText(Integer.toString(x));
    }
    public void detener(){
        estado=false;
    }
}
