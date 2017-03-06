/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Hangtu
 */
public class ServerRMI {
    //metodos se ejecutan del lado del servidor
    public static void main(String[] args) throws Exception{
        ObjetoRemotoImple obj= new ObjetoRemotoImple();
        Registry registry = LocateRegistry.getRegistry(1099);
        Thread.sleep(20000);
        registry.rebind("remoto",obj);
      
    }
}
