/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
public class TwitterJavaGT {

    
private static Twitter twitter;
 

   
    
    
TwitterJavaGT() throws TwitterException {

 
  ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
    .setOAuthConsumerKey("OnGVFngVruyxoLM1klaWtNGq8")
    .setOAuthConsumerSecret("e5rN8Oy8MhNhCV7YFXWckkSRV2mNaiJWqQy78eUBFvZ9LowgNI")
    .setOAuthAccessToken("2594114659-dOtEGOd8JE6LltIKAqHMZ3aFBebHHXDxU1gngK4")//me lo da la otra clase
    .setOAuthAccessTokenSecret("sTpLmkD8cR7nk1h2ChNQZcy4NLCLmmDAdupEnGTQmVbTZ");// me lo da la otra clase
    TwitterFactory tf = new TwitterFactory(cb.build());
    twitter = tf.getInstance();


}

public static String  lineaTiempo(){
 //motrar mis twits
    String estadoFinal="";
    long idFinal=0;
    
   
    try {
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Mostrando Ultima Linea De Tiempo De Twitter");
        estadoFinal=statuses.get(0).getText();
       
        if(estadoFinal.equalsIgnoreCase("Encender") || estadoFinal.equalsIgnoreCase("apagar")){
         idFinal=statuses.get(0).getId();
         twitter.destroyStatus(idFinal);
        }
        
    }catch(Exception ex) {
        System.out.println("error en TwitterJavaGT");
    } 
       return estadoFinal;
    }
  }

    
 // postear algo   
    //twitter.updateStatus("Encendiendo");
  

