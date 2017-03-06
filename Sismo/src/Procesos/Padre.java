/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import javax.swing.JTextArea;

/**
 *
 * @author Hangtu
 */
public class Padre {
    
    protected JTextArea terminal;
    
    public Padre(JTextArea terminal){
            this.terminal=terminal;
    }

    public JTextArea getTerminal() {
        return terminal;
    }
 
}
