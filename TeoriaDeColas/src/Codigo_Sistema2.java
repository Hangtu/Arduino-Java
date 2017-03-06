/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author startX
 */
public class Codigo_Sistema2 {
    
    
    public double Ro(double a, double u){
         double division=(a/u);
         return division;
     }
     
     public double Lq(double p, int c , double po){
         double res=(Math.pow(p,(c+1))/ Factorial.factorial(c-1)) *  (1/(Math.pow(c-p, 2))) * po;
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
     
     public double Po(double p, int c){
           double sum=0;
         for(int n=0;n<c;n++){
               sum=sum+(Math.pow(p,n) / Factorial.factorial(n));
           }
         double res=(sum+ ((Math.pow(p,c)/Factorial.factorial(c)))); 
         res=res*(c/(c-p));
         return 1/res;
     }
     
     public double Pw(int c,double p , double po){
         
         double res=(Factorial.factorial(c));
           res=(1/res) * (Math.pow(p, c))  * (c/(c-p)) * (po);
           return res;
     }
  
     public double Pn1(double p,int n,double po){
         double res=(Math.pow(p,n) / Factorial.factorial(n)) * (po);
         return res;
     }
     
     public double Pn2(double p, int c , int n, double po){
         double res=(Math.pow(p, n) / ((Factorial.factorial(c)) * Math.pow(c, n-c)) ) * po;
         return res;
     }
     
     public double U(int c,double po,double p){
         double sum=po;
          for(int n=0; n<c ;n++){
              sum=sum+ (((c-(n+1))/c)* Pn1(p, n+1 , po));
          }
         double res=sum *(-1);
         return res+1;
     }
     
 
}
