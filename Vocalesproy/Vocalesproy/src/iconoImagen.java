
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
public class iconoImagen {
    Image icono;
    int posX, posY;
    boolean ancla; //true es NO MOVER y false es mover
    
    iconoImagen(String archivo){
    icono = new ImageIcon (getClass().getResource(archivo)).getImage();
    ancla = false;
    }
    
    iconoImagen(String archivo, int x, int y) {
    icono = new ImageIcon (getClass().getResource(archivo)).getImage();
          posX = x;
          posY = y;
          ancla = false;
    }
    public void pintar(Canvas canvas)
    {
        Graphics pintor = canvas.getGraphics();
        pintor.drawImage(icono, posX, posY, canvas);     
    }
    public boolean colision(iconoImagen otro){
    int x2, y2;
        x2 = posX + icono.getWidth(null); 
        y2 = posY + icono.getHeight(null);
        if(otro.estaEnArea(new Point(posX,posY))==true){
        return true;
        }
        if(otro.estaEnArea(new Point(posX,y2)))
        {
        return true;        
        }
        if(otro.estaEnArea(new Point(x2,posY)))
        {
        return true;
        }
        if(otro.estaEnArea(new Point(x2,y2)))
        {
        return true;
        }
        return false;
    }
    public boolean estaEnArea(Point raton){
        int x2, y2;
        x2 = posX + icono.getWidth(null); // Tarea: determinar ANCHO de la imagen por codigo
        y2 = posY + icono.getHeight(null); // Tarea: determinar ALTO de la imagen por codigo
            if(raton.x >= posX && raton.x <= x2)
            {
            if(raton.y >= posY && raton.y <= y2)
            {
                return true;
            }
            }
            
        return false;
    }
public void mover(Point raton){
    if(ancla==true) return;//returnt se entiende como SALIR para este caso
posX=raton.x-icono.getWidth(null)/2;
posY=raton.y-icono.getHeight(null)/2;
}
}
