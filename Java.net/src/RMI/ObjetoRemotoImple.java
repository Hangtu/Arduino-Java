/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Hangtu
 */
public class ObjetoRemotoImple extends UnicastRemoteObject implements ObjetoRemoto {

    public ObjetoRemotoImple() throws RemoteException{
        super();
    }
    
    @Override
    public String obtenerSaludo(String nombre) throws RemoteException {
         return "Hola "+nombre;
    }
    
}
