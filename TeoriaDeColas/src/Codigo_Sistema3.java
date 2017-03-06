/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author startX
 */
public class Codigo_Sistema3 {
    
     public double RO(double a,double u){
           double res=a/u;
           return res;  
     }
     
     public double Po(double p,double k){
         double res=(1-p)/(1-Math.pow(p,(k+1)));
         return res;
     }
     
     public double Pn(double p, double n,double po ,double k){
         double res=0;
         if(n<=k){
             res= Math.pow(p, n) *  po;
             return res;
         }
         else {
             res=0;
             return res;
         }
     }
     
     
     public double L (double p,double k){
         double res=(p/(1-p)) - (((k+1)*Math.pow(p, (k+1))) / (1-Math.pow(p,(k+1))) );
         return res;
     }
     
     
     public double Pn2 (double k , double n){
         if(n<=k){
           double res=(1/(k+1));
              return res;
         }
         else{
             double res=0;
             return res;  
         }
     }
     
     public double L2(double k){
         double res= k/2;
         return res;
     }
     
     
     public double Lq(double l, double po){
         double res=l-(1-po);
         return res;
     }
     
     
     public double A(double a,double p,double k,double po,double n){
         
           double res=a*(1- Pn( p,n=k,po,k));
           return res;
     }
     
     public double W(double l,double an){
         double res=l/an;
         return res;
     }
     
     public double Wq(double lq, double an){
         double res = lq/an;
         return res;
     }
        
}
