/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
public class TwitterJavaGT {

private String accessToken;
private String accessTokenSecret;
    
    
TwitterJavaGT() throws TwitterException {

Twitter twitter;
ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true)
  .setOAuthConsumerKey("OnGVFngVruyxoLM1klaWtNGq8")
  .setOAuthConsumerSecret("e5rN8Oy8MhNhCV7YFXWckkSRV2mNaiJWqQy78eUBFvZ9LowgNI")
  .setOAuthAccessToken("2594114659-dOtEGOd8JE6LltIKAqHMZ3aFBebHHXDxU1gngK4")
  .setOAuthAccessTokenSecret("sTpLmkD8cR7nk1h2ChNQZcy4NLCLmmDAdupEnGTQmVbTZ");
TwitterFactory tf = new TwitterFactory(cb.build());
twitter = tf.getInstance();



 //motrar mis twits
    List<Status> statuses = twitter.getHomeTimeline();
    System.out.println("Showing home timeline.");
    for (Status status : statuses) {
        System.out.println(status.getUser().getName() + ":" +
                           status.getText());
    }
    

 
     //twitter.destroyStatus(retweet.getId());

 // postear algo   
    //twitter.updateStatus("Encendiendo");
    //Status status = twitter.updateStatus("Estoy Bien Perro");
    //System.out.println("Successfully updated the status to [" + status.getText() + "].");
}

public static void main(String ar[]) throws TwitterException {
  
    TwitterJavaGT twitter = new TwitterJavaGT();
}
}
