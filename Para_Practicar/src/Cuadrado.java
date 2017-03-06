
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
public class Cuadrado implements Runnable{
    private Graphics papel;
    private int posX, posY;
    private Color color;
    private JPanel panel;
    
    public Cuadrado(java.awt.Graphics papel, javax.swing.JPanel panel , int posX, int posY, Color color){
      this.papel=papel;
      this.posX=posX;
      this.posY=posY;
      this.color=color;
      this.panel=panel;
      Thread hilo=new Thread(this);
      hilo.start();
    
    }
    
    public void dibujar (){        
        papel.setColor(color);
        papel.fillRect(posX, posY, 50, 50);
    }
    
    public void mover(){
       posX=posX+1;
       if(posX==388){ 
           posX=-50;
           posY=posY+50;
       }
       if (posY>=223){
           posY=0;
       }
    }
    
    public void borrar(){
   
        papel.setColor(Color.WHITE);
        papel.fillRect(posX, posY, 50, 50);
        panel.removeAll();
    }
    
    public void pausar(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cuadrado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {   
     
       while(true){
        dibujar();
        pausar();
        borrar();
        mover();
       
       }
    }

    public Graphics getPapel() {
        return papel;
    }

    public void setPapel(Graphics papel) {
        this.papel = papel;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

}
