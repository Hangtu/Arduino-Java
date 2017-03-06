/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Objects.Verbos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Hangtu
 */
public class Panel extends javax.swing.JFrame {

    private int contador=0;
    private int errores=0;
    private ArrayList <Verbos> lista=new ArrayList <>(); 
    private About about;

    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
        this.setLocationRelativeTo(null);
        about=new About();
        //this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        objetos();
    }
    
    public  Image getIconImage(){
    Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/favicon.png"));
    return retValue;
     } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtPast = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jVerb = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        txtPast.setFont(new java.awt.Font("Teen", 0, 70)); // NOI18N
        txtPast.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPast.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPastKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 80)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Irregular Verbs");

        jVerb.setFont(new java.awt.Font("Teen", 0, 70)); // NOI18N
        jVerb.setForeground(new java.awt.Color(255, 255, 255));
        jVerb.setText("ARISE");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_harmonhall_full.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Teen", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("About...");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 467, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jVerb)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPast, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jVerb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(txtPast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPastKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPastKeyReleased
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           if(contador<lista.size()-1){
               Verbos verb= lista.get(contador);
               if(txtPast.getText().equalsIgnoreCase(verb.getSimplePast())){
                   contador++;
                   jVerb.setText(lista.get(contador).getIrregular().toUpperCase());
                   txtPast.setText("");
               }
               else{
                 
                   errores++;
                   
               }
           }
           else{
             javax.swing.JOptionPane.showMessageDialog(this,"Game Over"+"\n"+"\n"+errores+ "  Failed");
             int y=javax.swing.JOptionPane.showOptionDialog(this,"Do you want to play again?","Irregular Verbs", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,null,"");
             if(y==0){
              this.setVisible(false);
              new Panel().setVisible(true);
             }
             else{
                 System.exit(0);
             }
          }
       }
    }//GEN-LAST:event_txtPastKeyReleased

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setForeground(Color.WHITE);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        about.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

     private void objetos(){

         lista.add(new Verbos("arise","arose"));
         lista.add(new Verbos("be","was"));
         lista.add(new Verbos("beat","beat"));
         lista.add(new Verbos("become","became"));
         lista.add(new Verbos("begin","began"));
         lista.add(new Verbos("bet","bet"));
         lista.add(new Verbos("bite","bit"));
         lista.add(new Verbos("bleed","bled"));
         lista.add(new Verbos("blow","blew"));
         lista.add(new Verbos("break","broke"));
         lista.add(new Verbos("bring","brought"));
         lista.add(new Verbos("build","built"));
         lista.add(new Verbos("buy","bought"));
         lista.add(new Verbos("catch","caught"));
         lista.add(new Verbos("choose","chose"));
         lista.add(new Verbos("come","came"));
         lista.add(new Verbos("cost","cost"));
         lista.add(new Verbos("creep","crept"));
         lista.add(new Verbos("cut","cut"));
         lista.add(new Verbos("deal","dealt"));
         lista.add(new Verbos("do","did"));
         lista.add(new Verbos("draw","drew"));
         lista.add(new Verbos("dream","dreamt"));
         lista.add(new Verbos("drink","drank"));
         lista.add(new Verbos("drive","drove"));
         lista.add(new Verbos("eat","ate"));
         lista.add(new Verbos("fall","fell"));
         lista.add(new Verbos("feed","fed"));
         lista.add(new Verbos("feel","felt"));
         lista.add(new Verbos("fight","fought"));
         lista.add(new Verbos("find","found"));
         lista.add(new Verbos("fly","flew"));
         lista.add(new Verbos("forget","forgot"));
         lista.add(new Verbos("forgive","forgave"));
         lista.add(new Verbos("forsake","forsook"));
         lista.add(new Verbos("freeze","froze"));
         lista.add(new Verbos("get","got"));
         lista.add(new Verbos("give","gave"));
         lista.add(new Verbos("go","went"));
         lista.add(new Verbos("grind","ground"));
         lista.add(new Verbos("grow","grew"));
         lista.add(new Verbos("hang","hung"));
         lista.add(new Verbos("have","had"));
         lista.add(new Verbos("hear","heard"));
         lista.add(new Verbos("hide","hid"));
         lista.add(new Verbos("hit","hit"));
         lista.add(new Verbos("hold","held"));
         lista.add(new Verbos("hurt","hurt"));
         lista.add(new Verbos("keep","kept"));
         lista.add(new Verbos("kneel","knelt"));
         lista.add(new Verbos("know","knew"));
         lista.add(new Verbos("lead","led"));
 
     }
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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jVerb;
    private javax.swing.JTextField txtPast;
    // End of variables declaration//GEN-END:variables
}