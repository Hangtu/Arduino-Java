package Cliente;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 import java.rmi.*;
/**
 *
 * @author Hangtu
 */
public class ServidorRmi extends java.rmi.server.UnicastRemoteObject implements Metodos_RMI {

       public ServidorRmi() throws java.rmi.RemoteException{
           
       }
    @Override
    public int sumaRemota(int a, int b) throws RemoteException {
        return a+b;
    }
} 

