
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
public class Imagenes {

    
    private String nombre;
    private ImageIcon imagen;
    
    public Imagenes(String nombre, ImageIcon imagen){
        
        this.nombre=nombre;
        this.imagen=imagen;
        
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public ImageIcon getImagen() {
        return imagen;
    }
    
}
