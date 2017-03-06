
public class Codigo_Sistema4 {
    
    
    public double P(double a, double u){
        double res=a/u;
        return res;
    }
    
    public double Po(double c,double k,double p){
        double sum1=0;
        double sum2=0;
        for(int n=0;n<=c;n++){
            sum1=sum1+ ((Math.pow(p,n))/ Factorial.factorial(n)) ;
        }
          sum1=sum1+ ((Math.pow(p, c))/ Factorial.factorial(c));
       for(double n=(c+1);n<=k;n++){
           sum2=sum2 + Math.pow((p/c), (n-c) );
       }
          return sum1+sum2;
    }
    
    public double Pn1(double p, double n, double po){
        
        double res=((Math.pow(p, n))/ Factorial.factorial(n)) * po;
        return res;
    }
    
    public double Pn2(double p,double c, double n, double po){
        
        double res=((Math.pow(p, n))/ ((Factorial.factorial(c)*Math.pow(c,(n-c))) )) *  po;
        return res;
    }
    
     public double Pn3(){
         
       return 0.0;
    }
     
     public double Lq(double po, double p, double c , double a, double u , double k){
         double res=0;
         double mul=0;
         
         mul=po*(Math.pow(p,(c)) * (a/(c*u)));
         mul= mul / (Factorial.factorial(c) * Math.pow(((1-a)/(c*u)), 2));
         
         res= 1-(Math.pow((a/(c*u)),(k-c)));
         
         res= res - ((k-c)* Math.pow((a/(c*u)), (k-c)));
         
         res= res * (1-(a/(c*u)) );
         
       
         return mul*res;
     }
     
     public double L(double p,double pn, double lq, double c,double po){
         
        double sum1=0;
        double sum2=0;
           for (double n=0; n<=(c-1);n++){
               sum1=sum1+ n*  Pn1( p,n,po);
           }
        sum1=sum1+lq;
         
           for (double n=0; n<=(c-1);c++){
               sum2=sum2+ Pn1( p,n,po);
           }
           sum2=1-sum2;
           sum2=sum2*c;
           
        return sum1+sum2;
     }
    
     
}
