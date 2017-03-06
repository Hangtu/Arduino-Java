/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Hangtu
 */
public class Verbos {
    
    private String irregular;
    private String simplePast;
    private String spanish;
    
    public Verbos(String irregular, String simplePast , String spanish){
        this.irregular=irregular;
        this.simplePast=simplePast;
        this.spanish=spanish;
    }  
      public Verbos(String irregular, String simplePast){
        this.irregular=irregular;
        this.simplePast=simplePast;
    }

    public String getSimplePast() {
        return simplePast;
    }

    public String getIrregular() {
        return irregular;
    }
    
}
