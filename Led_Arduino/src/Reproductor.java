import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;
 


public class Reproductor {
    public BasicPlayer player;
    private Reproductor Voz;

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
           
         public void Encendidomp3 () throws Exception{
       try {
            Voz.AbrirFichero("C:/Users/Hangtu/Music/steve.mp3");
            Voz.Play();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}