/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
//HOla
import javax.media.*;
import java.awt.Component;
import javax.swing.*;
public class video1 {
MediaLocator ml;
Player p;
Component frame;
JFrame frame2;
public video1(){
try{
ml = new MediaLocator("vfw://0");
p = Manager.createRealizedPlayer(ml);
}catch(Exception ie){System.out.println(ie.toString());}
p.start();
frame = p.getVisualComponent();
frame2 = new JFrame("Video de Prueba");
frame2.add(frame);
frame2.setVisible(true);
}
public static void main(String args[]) {
try {
SwingUtilities.invokeLater(new Runnable() {
public void run() {
new video1();
}
});
} catch (Exception ex) {
ex.printStackTrace();
}
}
}