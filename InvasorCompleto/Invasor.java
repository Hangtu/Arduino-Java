
// Este programa necesita 4 archivos de gr�ficos - consulte el texto del programa.
// Estos archivos necesitan estar en la unidad C en el nivel m�s alto para coincidir con los nombres de los archivos que se utilizan dentro del programa.
// Hay 4 archivos de imagen sugeridos disponibles dentro de la carpeta que contiene este archivo.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Invasor extends JFrame
implements ActionListener, MouseListener, MouseMotionListener {

    private JButton bot�n;
    private JPanel panel;

    private Extraterrestre extraterrestre;
    private Defensor defensor;
    private L�ser l�ser;
    private Bomba bomba; 

    private Timer temporizador;

    public static void main(String[] args) {
        Invasor marco = new Invasor();
        marco.setSize(250,280);
        marco.crearGUI();
        marco.setVisible(true);
    }

    private void crearGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.white);
        ventana.add(panel);

        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);

        bot�n = new JButton("iniciar");
        ventana.add(bot�n);
        bot�n.addActionListener(this);

        temporizador = new Timer(100, this);

        nuevoJuego();
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bot�n) {
            nuevoJuego();
        }
        if (event.getSource() == temporizador) {
            temporizador_Tick();
        }
    }

    public void mouseClicked(MouseEvent event) {
        int xInicial  = defensor.getX();
        int yInicial  = defensor.getY();
        if (l�ser == null) {
            l�ser = new L�ser(xInicial, yInicial);
        }
    }

    public void mouseMoved(MouseEvent event) {
        defensor.mover(event.getX());
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent event) {
    }

    public void mousePressed(MouseEvent event) {
    }

    public void mouseExited(MouseEvent event) {
    }

    public void mouseEntered(MouseEvent event) {
    }

    private void temporizador_Tick() {
        if (bomba == null) {
            bomba = new Bomba(extraterrestre.getX(), extraterrestre.getY());
        }
        moverTodo();
        dibujarTodo();
        comprobarChoques();
    }

    private void moverTodo() {
        extraterrestre.mover();
        if (bomba != null) {
            bomba.mover();
        }
        if (l�ser != null) {
            l�ser.mover();
        }
    }

    private void comprobarChoques() {
        if (colisiona(l�ser, extraterrestre)) {
            terminarJuego("defensor");
        }
        else {
            if (colisiona(bomba, defensor)) {
                terminarJuego("extraterrestre");
            }
        }
        if (bomba != null) {
            if (bomba.getY() > panel.getHeight()) {
                bomba = null;
            }
        }
        if (l�ser != null) {
            if (l�ser.getY() < 0) {
                l�ser = null;
            }
        }
    }

    private boolean colisiona(Sprite uno, Sprite dos) {
        if (uno == null || dos == null) {
            return false;
        }
        if (    uno.getX() > dos.getX()
            &&  uno.getY() < (dos.getY() + dos.getAltura())
            && (uno.getX() + uno.getAnchura()) < (dos.getX() + dos.getAnchura())
            && (uno.getY() + uno.getAnchura()) > (dos.getY())) {
            return true;
        }
        else {
            return false;
        }
    }

    private void terminarJuego(String ganador) {
        l�ser = null;
        bomba = null;
        temporizador.stop();
        JOptionPane.showMessageDialog(null, "fin del juego - " + ganador + " gana");
    }

    private void nuevoJuego() {
        defensor = new Defensor();
        extraterrestre = new Extraterrestre();
        temporizador.start();
    }

    private void dibujarTodo() {
        Graphics papel = panel.getGraphics();
        papel.setColor(Color.white);
        papel.fillRect(0, 0, panel.getWidth(), panel.getHeight());

        defensor.dibujar(panel);
        extraterrestre.dibujar(panel);
        if (l�ser != null) {
            l�ser.dibujar(panel);
        }
        if (bomba != null) {
            bomba.dibujar(panel);
        }
    }
}

