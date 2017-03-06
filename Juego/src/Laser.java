import java.awt.*;
import javax.swing.*;

public class Laser extends Sprite {

    private int tamanioIntervalo;
    private ImageIcon imagenLaser;

    public Laser(int nuevaX, int nuevaY) {
        x = nuevaX;
        y = nuevaY;
        anchura = 5;
        altura = 5;
        tamanioIntervalo = 10;        
        imagenLaser = new ImageIcon("c:\\laser.jpg");
    }

    public void dibujar(JPanel panel) {
        Graphics papel = panel.getGraphics();
        imagenLaser.paintIcon(panel, papel, x, y);
    }

    public void mover() {
        y = y - tamanioIntervalo;
    }
}