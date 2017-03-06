
import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
public class FacebookCT {
    
    public FacebookCT(){
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
  .setOAuthAppId("1428897594058044")
  .setOAuthAppSecret("1be664cacf9d342171fcb5a8e9ebd153")
 .setOAuthAccessToken("1428897594058044|qauWUWXBY2EfLtOrlX290H4SRcc");
  cb.setOAuthAppSecret("0bf7f1c04c86899cb25538a901b271e0");
  cb.setOAuthPermissions("email,publish_stream, id, name, first_name, last_name, generic");
   FacebookFactory ff = new FacebookFactory(cb.build());
   Facebook facebook = ff.getInstance();
       //
   try {
           ResponseList<Post> feeds = facebook.getFeed("702262773119129",
            new Reading().limit(25));
		
           
          System.out.println(facebook.getOAuthAppAccessToken());
          
         //facebook.postStatusMessage("Vamos Mexico");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public static void main(String[] args) {
        FacebookCT a= new FacebookCT();
    }
}
