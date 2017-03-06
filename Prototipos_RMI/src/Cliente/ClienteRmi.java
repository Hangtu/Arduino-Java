package Cliente;


import Cliente.ServidorRmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
public class ClienteRmi {
    
    public static void main(String[] args) {
        
        try{
            Registry registro= LocateRegistry.createRegistry(8080);
            registro.rebind("rmiRemoto", new ServidorRmi());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
