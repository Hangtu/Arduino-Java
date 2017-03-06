import java.awt.*;
import javax.swing.*;

public class Láser extends Sprite {

    private int tamañoIntervalo;
    private ImageIcon imagenLáser;

    public Láser(int nuevaX, int nuevaY) {
        x = nuevaX;
        y = nuevaY;
        anchura = 5;
        altura = 5;
        tamañoIntervalo = 10;        
        imagenLáser = new ImageIcon("c:\\láser.jpg");
    }

    public void dibujar(JPanel panel) {
        Graphics papel = panel.getGraphics();
        imagenLáser.paintIcon(panel, papel, x, y);
    }

    public void mover() {
        y = y - tamañoIntervalo;
    }
}