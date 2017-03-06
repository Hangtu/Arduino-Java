/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Hangtu
 */
public class ConsumirRemoto {
    
    public void SumarRemotamente(int a, int b){
    
        try{
            Registry registro= LocateRegistry.getRegistry("127.0.0.1",8080);
            Metodos_RMI miInterfaz = (Metodos_RMI)registro.lookup("rmiRemoto");//nombre del servidor 
            int suma= miInterfaz.sumaRemota(a, b);
            javax.swing.JOptionPane.showMessageDialog(null, suma);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
