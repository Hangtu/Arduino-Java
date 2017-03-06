package Cliente;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.Remote;
import java.rmi.*;
/**
 *
 * @author Hangtu
 */
public interface Metodos_RMI extends Remote {
    
  public int sumaRemota(int a, int b) throws java.rmi.RemoteException;
        
    
}
