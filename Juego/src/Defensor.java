import java.awt.*;
import javax.swing.*;

public class Defensor extends Sprite {

    private ImageIcon imagenUsuario;

    public Defensor() {
        x = 0;
        y = 175;
        anchura = 20;
        altura = 20;        
        imagenUsuario = new ImageIcon("c:\\defensor.jpg");

    }

    public void mover(int nuevaX) {
        x = nuevaX;
    }

    public void dibujar(JPanel panel) {
        Graphics papel = panel.getGraphics();
        imagenUsuario.paintIcon(panel, papel, x, y);
    }
}
