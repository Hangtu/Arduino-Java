/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.rmi.Remote;

/**
 *
 * @author Hangtu
 */
public interface Metodos_RMI extends Remote {
    
  public int sumaRemota(int a, int b) throws java.rmi.RemoteException;
        
    
}