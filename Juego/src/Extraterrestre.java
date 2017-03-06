import java.awt.*;
import javax.swing.*;

public class Extraterrestre extends Sprite { 

    private int tamañoIntervalo;
    private ImageIcon imagenExtraterrestre;

    public Extraterrestre() {
        x = 0;
        y = 25;
        anchura = 20;
        altura = 10;
        tamañoIntervalo = 10;        
        imagenExtraterrestre = new ImageIcon("c:\\extraterrestre.jpg");
    }

    public void dibujar(JPanel panel) {
        Graphics papel = panel.getGraphics();
        imagenExtraterrestre.paintIcon(panel, papel, x, y);
    }

    public void mover() {
        if (x > 320 || x < 0) {
            tamañoIntervalo = -tamañoIntervalo;
        }
        x = x + tamañoIntervalo;
    }
}
