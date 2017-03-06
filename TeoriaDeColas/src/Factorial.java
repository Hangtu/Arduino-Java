/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author startX
 */
public class Factorial {
    
    public static double  factorial(double x){
     double factorial=1;
     for(int i=1;i<=x;i++){
          factorial=factorial*i;
     }
       return factorial;
      
     }
    
}
