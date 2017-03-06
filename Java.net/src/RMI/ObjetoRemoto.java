/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Hangtu
 */
public interface ObjetoRemoto extends Remote {
    public String obtenerSaludo(String nombre) throws RemoteException; 
    //Todos lo metods de las interfaces deben tener RemoteException
}
