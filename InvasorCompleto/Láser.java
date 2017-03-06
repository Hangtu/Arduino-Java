import java.awt.*;
import javax.swing.*;

public class L�ser extends Sprite {

    private int tama�oIntervalo;
    private ImageIcon imagenL�ser;

    public L�ser(int nuevaX, int nuevaY) {
        x = nuevaX;
        y = nuevaY;
        anchura = 5;
        altura = 5;
        tama�oIntervalo = 10;        
        imagenL�ser = new ImageIcon("c:\\l�ser.jpg");
    }

    public void dibujar(JPanel panel) {
        Graphics papel = panel.getGraphics();
        imagenL�ser.paintIcon(panel, papel, x, y);
    }

    public void mover() {
        y = y - tama�oIntervalo;
    }
}