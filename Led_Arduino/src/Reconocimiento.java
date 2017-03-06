/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileReader;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.*;
/**
 *
 * @author Hangtu
 */
public class Reconocimiento extends ResultAdapter implements Runnable {
    
    Voz voz;
    Recognizer reconocedorVoz;// Reconoce el comando de voz del usuario
    String palabra; //palabra que se va a reconocer
    
    public Reconocimiento(Voz voz){
               this.voz=voz;
    }
    
    public void resultAccepted(ResultEvent re) {
        try {
            Result res = (Result) (re.getSource());
            ResultToken tokens[] = res.getBestTokens();
            
            for (int i = 0; i < tokens.length; i++) {
                palabra = tokens[i].getSpokenText();

                if (palabra.equals("apagaruno")) {
                    voz.Send("0");
                }
                if (palabra.equals("encenderuno")) {
                    voz.Send("1");
            }
               if(palabra.equals("apagardos")){
                    voz.Send("2");
               }
               
                 if(palabra.equals("encenderdos")){
                    voz.Send("3");
               }
                 
                  if(palabra.equals("parpadien")){
                    voz.Send("4");
               }
                    if(palabra.equals("prendanse")){
                    voz.Send("5");
               }
                    if(palabra.equals("apaguense")){
                    voz.Send("6");
               }
               if(palabra.equals("culo")){
                    voz.Send("7");
               }
                      
                    if(palabra.equals("cerrar")){
                     //System.exit(0);
               }
        }
         
       }catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
        public void reconocerVoz() {
        try {
            reconocedorVoz = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            reconocedorVoz.allocate();

            FileReader gramatica = new FileReader("C:\\SimpleGrammarES1.txt");

            RuleGrammar reglaGramatica = reconocedorVoz.loadJSGF(gramatica);
            reglaGramatica.setEnabled(true);

             reconocedorVoz.addResultListener(new Reconocimiento(voz));
             reconocedorVoz.commitChanges();
             reconocedorVoz.requestFocus();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    
    @Override
    public void run() {
            this.reconocerVoz(); 
    }
    
}
