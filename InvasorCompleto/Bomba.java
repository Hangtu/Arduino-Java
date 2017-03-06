import java.awt.*;
import javax.swing.*;

public class Bomba extends Sprite {

    private int tamañoIntervalo;
    private ImageIcon imagenBomba;


    public Bomba(int xInicial, int yInicial) {
        x = xInicial;
        y = yInicial;
        anchura = 5;
        altura = 10;
        tamañoIntervalo = 10;        
        imagenBomba = new ImageIcon("c:\\bomba.jpg");
    }

    public void dibujar(JPanel panel) {
        Graphics papel = panel.getGraphics();
        imagenBomba.paintIcon(panel, papel, x, y);

    }

    public void mover() {
        y = y + tamañoIntervalo;
    }
}
