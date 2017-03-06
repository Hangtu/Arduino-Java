
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
public class Clothes {
    
    private String nombre;
    private ImageIcon image;
    
    public Clothes(String nombre, ImageIcon image){
        this.nombre=nombre;
        this.image=image;
    }

    public String getNombre() {
        return nombre;
    }

  

    public ImageIcon getImage() {
        return image;
    }

    
}
