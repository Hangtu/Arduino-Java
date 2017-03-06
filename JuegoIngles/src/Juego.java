
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hangtu
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     */
    private Imagenes imagen;
    private Random aleatorio=new Random();
    private ArrayList <Imagenes> list=new ArrayList<>();
    private int puntos=0;
    
    private Imagenes a=new Imagenes("belt",new ImageIcon(getClass().getResource("/imagenes/belt.jpg")));
    private Imagenes b=new Imagenes("boots",new ImageIcon(getClass().getResource("/imagenes/boots.jpg")));
    private Imagenes c=new Imagenes("cap",new ImageIcon(getClass().getResource("/imagenes/cap.jpg")));
    private Imagenes d=new Imagenes("coat",new ImageIcon(getClass().getResource("/imagenes/coat.jpg")));
    private Imagenes e=new Imagenes("gloves",new ImageIcon(getClass().getResource("/imagenes/gloves.jpg")));
    private Imagenes f=new Imagenes("hat",new ImageIcon(getClass().getResource("/imagenes/hat.jpg")));
    private Imagenes g=new Imagenes("socks",new ImageIcon(getClass().getResource("/imagenes/socks.jpg")));
    private Imagenes h=new Imagenes("sandals",new ImageIcon(getClass().getResource("/imagenes/sandals.jpg")));
    private Imagenes i=new Imagenes("scarf",new ImageIcon(getClass().getResource("/imagenes/scarf.jpg")));
    private Imagenes j=new Imagenes("skirt",new ImageIcon(getClass().getResource("/imagenes/skirt.jpg")));
    private Imagenes k=new Imagenes("sneakers",new ImageIcon(getClass().getResource("/imagenes/sneakers.jpg")));
    private Imagenes l=new Imagenes("tie",new ImageIcon(getClass().getResource("/imagenes/tie.jpg")));
    private Imagenes m=new Imagenes("watch",new ImageIcon(getClass().getResource("/imagenes/watch.jpg")));
    private Imagenes n=new Imagenes("underwear",new ImageIcon(getClass().getResource("/imagenes/underwear.jpg")));
   
    
    public Juego() {
        initComponents();
        objetosLista();
        this.setLocationRelativeTo(null);
        name.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        label.setBackground(new java.awt.Color(255, 255, 255));

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("GUESS THE NAME");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/club.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        
        escoger();
        btnStart.setEnabled(false);
        name.setEnabled(true);
    }//GEN-LAST:event_btnStartActionPerformed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           if(name.getText().equalsIgnoreCase(imagen.getNombre())){
           
           javax.swing.JOptionPane.showMessageDialog(this,"GOOD :D");
           name.setText("");
           escoger();
           puntos++;
       }
       else{
            javax.swing.JOptionPane.showMessageDialog(this,"I'M SORRY  YOUR SCORE: "+puntos);
            label.setIcon(null);
            name.setText("");
            name.setEnabled(false);
            btnStart.setEnabled(true);
            puntos=0;
       }
       }
    }//GEN-LAST:event_nameKeyPressed
   
    private void objetosLista(){
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        list.add(h);
        list.add(i);
        list.add(j);
        list.add(k);
        list.add(l);
        list.add(m);
        list.add(n);
        
    }
    
    private void escoger(){
        imagen=list.get(aleatorio.nextInt(list.size()));
        label.setIcon(imagen.getImagen());
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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}