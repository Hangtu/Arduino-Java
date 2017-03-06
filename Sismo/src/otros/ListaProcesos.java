/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otros;

import Procesos.Comandos;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Hangtu
 */
public class ListaProcesos extends Comandos  {
    
    protected JTextArea areaProcesos;
    protected ArrayList <String> lista=new ArrayList<>();
    private Thread hilo;
    
     public ListaProcesos (JTextArea terminal, JTextArea areaProcesos){
        super(terminal);
        this.areaProcesos=areaProcesos;   
    }
     
     public void agregar(){
         lista.add(nombreProceso);
     }
    
     public void mostrar(){
         for(int i=0;i<lista.size();i++){
                areaProcesos.append(i+" "+lista.get(i)+"\n");
                }
     }
     public void borrarCola(){
          lista.remove(0);
     }

}
