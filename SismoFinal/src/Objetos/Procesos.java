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
   
    
    private String band="v";
    private String user;
    private String est;
    private String nombre;
    private String recurso;
    private int id;
    private int quantum;
    private int t;
    private int tiempoE;
    private int tiempoR;
    private int tamaño;
    private int dispositivo;
    private Thread gestion;
    private int paginas[];
    

    
    

  
    
    public Procesos(int id,String nombre,String user, String est,int t,int tamaño,int quantum){
        this.id=id;
        this.nombre=nombre;
        this.user=user;
        this.est=est;
        this.t=t;
        this.quantum=quantum;
        this.tamaño=tamaño;
        gestion=new Thread(this);
        gestion.start();
    }
    
    public Procesos(int id,String nombre,String user, String est,int t, int tamaño){
        this.id=id;
        this.nombre=nombre;
        this.user=user;
        this.est=est;
        this.t=t;
        this.tamaño=tamaño;
        gestion=new Thread(this);
        gestion.start();
    }

    public int getT() {
        return t;
    }

    public String getNombre() {
        return nombre;
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

    public int getTamaño() {
        return tamaño;
    }
    
      public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public void setPaginas(int[] paginas) {
        this.paginas = paginas;
    }

    public int[] getPaginas() {
        return paginas;
    }

    public int getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(int dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getRecurso() {
        return recurso;
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
