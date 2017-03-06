/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
public class absoluto {
  
private void valor(){
     int numero = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(null,"Ingresa El Valor"));
     numero=Math.abs(numero);
     javax.swing.JOptionPane.showMessageDialog(null,"El numero absoluto es " + numero);
}
    
public static void main (String ar[]){
     
    absoluto objeto=new absoluto();
    objeto.valor();
  }
}