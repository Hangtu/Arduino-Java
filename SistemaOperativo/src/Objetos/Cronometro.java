/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Hangtu
 */
public class Cronometro implements Runnable{
    
    private JLabel jmin;
    private JLabel jseg;
    private Thread hilo;
    private int tic;
    
    public Cronometro(JLabel jmin, JLabel jseg){
        this.jmin=jmin;
        this.jseg=jseg;
        hilo=new Thread(this);
        hilo.start();
    }

    public JLabel getJmin() {
        return jmin;
    }

    public JLabel getJseg() {
        return jseg;
    }

    @Override
    public void run() {
        while(true){
         try {
             jmin.setText(Integer.toString(tic/60));
             jseg.setText(Integer.toString(tic%60));
             tic++;
             Thread.sleep(1000);
         } catch (InterruptedException ex) {
             Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }
}
