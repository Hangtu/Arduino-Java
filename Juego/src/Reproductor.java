import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;



public class Reproductor {
    public BasicPlayer player;

    public Reproductor() {
        player = new BasicPlayer();
    }
public void coge(String y){

}
    public void Play() throws Exception {
        player.play();
    }

    public void AbrirFichero(String ruta) throws Exception {
        player.open(new File(ruta));
    }

    public void Pausa() throws Exception {
        player.pause();
    }

    public void Continuar() throws Exception {
        player.resume();
    }

    public void Stop() throws Exception {
        player.stop();
    }
    public void reproducemp3 (int i) throws Exception{
       try {
             Reproductor   mi_reproductor = new Reproductor(); 
           if(i==0){
            mi_reproductor.AbrirFichero("C:/Users/startX/Videos/Terra.mp3");
            mi_reproductor.Play();
            
           }
           else {
     
           }
           
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
       
    }
           
         public void reproducemp4 () throws Exception{
       try {
            Reproductor   mi_reproductor = new Reproductor();
            mi_reproductor.AbrirFichero("C:/Users/startX/Videos/Tetris.mp3");
            mi_reproductor.Play();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
         }
}