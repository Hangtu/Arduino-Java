/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
public class Fibonacci {
    
  public static void main(String[] args) {
     int x=0;
     int y=1;
     int suma =0;
     String cad="";
       while(x<100){
          
           suma=x+y;
           x=y;
           y=suma;
         
           cad=cad+suma+"\n";
           
       }
     System.out.println(cad);
    }
}
