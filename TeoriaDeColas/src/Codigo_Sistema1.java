/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author startX
 */
public class Codigo_Sistema1 {
    
        
     public double Ro(double a, double u){
         double division=(a/u);
         return division;
     }
     
     public double Lq(double p){
         double res=(Math.pow(p, 2)) / (1-p);
         return res;
     }
     
     public  double Wq(double lq, double a){
         double res=lq/a;
         return res;
     }
     
     public double W(double wq, double u){
         double res=wq+(1/u);
         return res;
     }
     
     public double L(double a, double w){
         double res=a*w;
         return res;
     }
     
     public double Po(double p){
         double res=1-p;
         return res;
     }
  
     public double Pn(double p, int n,double po){
         double res=Math.pow(p,n) *po;
         return res;
     }
}
