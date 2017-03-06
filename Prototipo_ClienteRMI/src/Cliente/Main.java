/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Cliente.ConsumirRemoto;
import java.rmi.*;


/**
 *
 * @author Hangtu
 */
public class Main {
    
    public static void main(String[] args) {
         
             if(System.getSecurityManager()==null)
             {
                 
                 System.setSecurityManager(new RMISecurityManager());
             }
         
         
             ConsumirRemoto a=new ConsumirRemoto(); 
             a.SumarRemotamente(4, 5);
         
    }
    
}
