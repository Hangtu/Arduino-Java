import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;

public class lienzoG extends Canvas implements MouseListener, MouseMotionListener{
//iconoImagen fondo = new iconoImagen("fondo.jpg",1,1);
iconoImagen comenzar = new iconoImagen("vocal.png",1,1);
iconoImagen play = new iconoImagen("Play.png",400,400);
iconoImagen bien = new iconoImagen("bien.png",200,50);
iconoImagen casa = new iconoImagen("logo.png",1000,200);
iconoImagen ar = new iconoImagen("arbol.png",580,250);
iconoImagen fin = new iconoImagen("logro.png",500,250);
int bandera =0;
iconoImagen granero = new iconoImagen("fondo.png",1,1);
iconoImagen vocales[] = new iconoImagen[5];
iconoImagen siluetas[] = new iconoImagen[5];
String nombre[]={"a1.png","e1.png","i1.png","o1.png","u1.png"};
String nombreSiluetas[]={"a1c.png","e1c.png","i1c.png","o1c.png","u1c.png"};
int PosicionesX[]={10,120,730,440,350};
int PosicionesY[]={440,270,440,540,340};
int PosicionesXColor []={10,210,410,610,810};
AudioClip sonidos[]= new AudioClip[5];
String nombreSonidos[]={"a.wav","e.wav","i.wav","o.wav","u.wav"};
AudioClip sonidoFondo;
AudioClip sonidoIntro;
iconoImagen punteroArrastre;
int indice;
boolean a1,e1,i1,o1,u1;
   public lienzoG(){
       
        
      
       punteroArrastre=null;
       indice=-1;
      
   for(int i=0; i<vocales.length; i++)
   {
   siluetas[i]= new iconoImagen(nombreSiluetas[i], PosicionesX[i],PosicionesY[i]);
   vocales[i]= new iconoImagen(nombre[i], PosicionesXColor[i],50);
   try {
   sonidos[i]= JApplet.newAudioClip(new URL("file:"+nombreSonidos[i]));
   } catch (MalformedURLException e) {
   Logger.getLogger(lienzoG.class.getName()).log(Level.SEVERE, null, e);
   }
   }
        try 
        {
        sonidoFondo= JApplet.newAudioClip(new URL("file:infantil.wav"));
        sonidoFondo.play();
        } catch (MalformedURLException e) {
         Logger.getLogger(lienzoG.class.getName()).log(Level.SEVERE, null, e);
        }
    
   this.addMouseListener(this);
   this.addMouseMotionListener(this);
    for(int i=0;i<vocales.length;i++){
          vocales[i].icono.getScaledInstance(40,80,100);
     }
   }
 
   
   public void paint(Graphics g){
       
       if(bandera == 0){
           try {
               comenzar.pintar(this);
               play.pintar(this);
               bien.pintar(this);
               ar.pintar(this);
               sonidoIntro = JApplet.newAudioClip(new URL("file:intro.wav"));
               sonidoIntro.play();
               
           } catch (MalformedURLException ex) {
               Logger.getLogger(lienzoG.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       if(bandera == 1){
           //fondo.pintar(this);
   granero.pintar(this);
   for(int i=0; i<vocales.length; i++){
     siluetas[i].pintar(this);
   vocales[i].pintar(this);
   casa.pintar(this);
   }
       }
     
      if(a1 && e1 && i1 &&o1 &&u1){
          fin.pintar(this);
      }
       
   
       
   }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(play.estaEnArea(e.getPoint())){
            bandera = 1;
            repaint();
        }
        
        for(int i=0; i<vocales.length; i++)
   {
       if(vocales[i].estaEnArea(e.getPoint())){
       sonidos[i].play();
       }
   }
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
         for(int i=0; i<vocales.length; i++)
   {
       if(vocales[i].estaEnArea(e.getPoint())){
           punteroArrastre = vocales[i];
           indice = i;
       }
   }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");+
        
        if(indice==0){
            if(punteroArrastre.colision(siluetas[0])){
                punteroArrastre.posX = siluetas[0].posX;
                punteroArrastre.posY = siluetas[0].posY;
                punteroArrastre.ancla = true;
                a1 = true;
                repaint ();
            }
        }
        if(indice==1){
            if(punteroArrastre.colision(siluetas[1])){
                punteroArrastre.posX = siluetas[1].posX;
                punteroArrastre.posY = siluetas[1].posY;
                punteroArrastre.ancla = true;
                e1 = true;
                repaint ();
            }
        }
        if(indice==2){
            if(punteroArrastre.colision(siluetas[2])){
                punteroArrastre.posX = siluetas[2].posX;
                punteroArrastre.posY = siluetas[2].posY;
                punteroArrastre.ancla = true;
                i1 = true;
                repaint ();
            }
        }
        if(indice==3){
            if(punteroArrastre.colision(siluetas[3])){
                punteroArrastre.posX = siluetas[3].posX;
                punteroArrastre.posY = siluetas[3].posY;
                punteroArrastre.ancla = true;
                o1 = true;
                repaint ();
            }
        }
        if(indice==4){
            if(punteroArrastre.colision(siluetas[4])){
                punteroArrastre.posX = siluetas[4].posX;
                punteroArrastre.posY = siluetas[4].posY;
                punteroArrastre.ancla = true;
                u1 = true;
                repaint ();
            }
        }
        
        
        
        indice = -1;
        punteroArrastre = null;
        
    }
  

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        punteroArrastre.mover(e.getPoint());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
/*
   public void update(java.awt.Graphics g)

{

java.awt.Graphics GraficosFueraDePantalla;

java.awt.Image offscreen = null;

java.awt.Dimension d = size();

//create the offscreen buffer and associated Graphics

offscreen = createImage(d.width, d.height);

GraficosFueraDePantalla = offscreen.getGraphics();

// clear the exposed area

GraficosFueraDePantalla.setColor(getBackground());

GraficosFueraDePantalla.fillRect(0, 0, d.width, d.height);

GraficosFueraDePantalla.setColor(getForeground());

// do normal redraw

paint(GraficosFueraDePantalla);

// transfer offscreen to window

g.drawImage(offscreen, 0, 0, this);

}
   */
}
