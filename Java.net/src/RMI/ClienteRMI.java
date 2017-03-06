/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.*;

/**
 *
 * @author Hangtu
 */
public class ClienteRMI {
    
    public static void main(String[] args) throws Exception{
        
        //Se obtiene la referencia a la registry del servidor 
        Registry reg = LocateRegistry.getRegistry("192.168.1.70",1099);
        
        //ubico el objeto remoto identificado por "remoto"
        ObjetoRemoto  obj;
        obj = (ObjetoRemoto)reg.lookup("remoto");
        
        //invoco sus metodos como lo hago como cualquier otro obejeto
        
        System.out.println(obj.obtenerSaludo("Hang Tu"));
    }
    
}
