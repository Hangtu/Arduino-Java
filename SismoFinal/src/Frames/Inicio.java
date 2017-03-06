/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Hangtu
 */
public class Inicio extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Inicio
     */
    
    private Thread hilo;
    String est;
    
    public Inicio(String a)
    {
        this.est=a;
        this.setUndecorated(true);
        initComponents();
         if(a.equals("r")){
          label("Reiniciando");   
        }
          if(a.equals("a")){
          label("Apagando");   
        }
        this.setLocationRelativeTo(null);
        hilo=new Thread(this);
        hilo.start();
        
    }
    public  Image getIconImage(){
    Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/favicon5.png"));
    return retValue;
   } 
     
    private void label(String estado){        
        JLabel jLabel2 = new javax.swing.JLabel();
        jLabel2.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel2.setText(estado);
        jLabel2.setBounds(130, 80, 160, 50);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel2.setText("Sismo SO v3.0");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel3.setText("Sismo SO v3.0");
        jLabel3.setBounds(120, 30, 160, 50);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelCurves1.setBounds(0, -10, 400, 140);
        jLayeredPane1.add(panelCurves1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Inicio("0").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            if(est.equals("a")){
             Thread.sleep(2000);
              System.exit(0);
            }else{
            Thread.sleep(3000);
            new Terminal().setVisible(true);
            this.setVisible(false);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
