/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hangtu
 */
public class Procesos implements Runnable {
    
    private int id;
    private int quantum;
    private String user;
    private String est;
    private int t;
    
     int tiempoE;
     int tiempoR;
     int rendimiento;
     int procesador;
    
    Thread gestion;
    
    public Procesos(int id,String user, String est,int t, int quantum){
        this.id=id;
        this.user=user;
        this.est=est;
        this.t=t;
        this.quantum=quantum;
        gestion=new Thread(this);
        gestion.start();
    }

    public int getT() {
        return t;
    }

    public int getId() {
        return id;
    }

    public int getQuantum() {
        return quantum;
    }

    public String getUser() {
        return user;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getTiempoE() {
        return tiempoE;
    }

    public int getTiempoR() {
        return tiempoR;
    }
 

    @Override
    public void run() {
                
        while(true){
            try {
                Thread.sleep(1000);
                tiempoE++;
                if(!this.getEst().equalsIgnoreCase("ejecuccion")){
                    tiempoR++;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Procesos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    
    
    
}
