/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FaceB {

/**
 * A simple Facebook4J client which
 * illustrates how to access group feeds / posts / comments.
 * 
 * @param args
 * @throws FacebookException 
 */
public static void main(String[] args) throws FacebookException {

    // Generate facebook instance.
    Facebook facebook = new FacebookFactory().getInstance();
    // Use default values for oauth app id.
    facebook.setOAuthAppId("1428897594058044", "1be664cacf9d342171fcb5a8e9ebd153");
    facebook.setOAuthPermissions("email,publish_stream, id, name, first_name, last_name, generic");
    // Get an access token from: 
    // https://developers.facebook.com/tools/explorer
    // Copy and paste it below.
    String accessTokenString ="CAAUTkyWDpTwBABJFak2KBHk14Wyrp7IskZAjr9OJQCcGmFwV4q9WNo2LuoTZAQIfDiBIKbkdZBNzZBDXUijPwuyqFq1WQZCvBzIQAUCt6buZA0xFIjOK1YRDQt4rDrFFpZCJl6L3c3e918G8u3FZCZCWfZCo6ZAcOV0IMQmguH9n9lIq4vpRZBZB4bgnuG4eNyLoSNgwZD";
    AccessToken at = new AccessToken(accessTokenString);
    // Set access token.
    facebook.setOAuthAccessToken(at);

    // We're done.
    // Access group feeds.
    // You can get the group ID from:
    // https://developers.facebook.com/tools/explorer

    // Set limit to 25 feeds.
   // facebook.postStatusMessage("Vamos Mexico");
  while(true){
   ResponseList<Post> feeds = facebook.getFeed("702262773119129",
            new Reading().limit(25));  //id de la pagina

   //ResponseList<Post> feed = facebook.getHome(null);
        // For all 25 feeds...
        for (int i = 0; i < feeds.size(); i++) {
            // Get post.
            Post post = feeds.get(i);
            // Get (string) message.
            String message = post.getMessage();
                            // Print out the message.
            System.out.println(message);

            // Get more stuff...
            PagableList<Comment> comments = post.getComments();
            String date = post.getCreatedTime().toString();
            String name = post.getFrom().getName();
            String id = post.getId();
        }
        try {
            Thread.sleep(1000);
            facebook.postStatusMessage("Hello World from Facebook4J.");
        } catch (InterruptedException ex) {
            System.out.println("error");
        }
      }
    }
}
