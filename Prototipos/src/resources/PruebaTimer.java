

import java.awt.Toolkit; // Para el beep.
import java.awt.event.*; // Para el manejo de eventos, necesario para el Timer.
import javax.swing.JOptionPane; // Se introducirán los segundos.
import javax.swing.Timer; // Los benditos Timers.

public class PruebaTimer extends javax.swing.JFrame {
    
    Timer Reloj; // Declaramos un objeto Timer con el nombre de Reloj.
    int segundos; // Una variable para manejar la cuenta regresiva.
    int copiasegundos; // Para recordar los segundos en caso de reiniciar la cuenta regresiva.
    int delay = 1000; // Cada cúantos milisegundos nuestro Timer hará una acción,
                      // en este caso, cada segundo mostrará algo diferente.
    
    public PruebaTimer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Tiempo = new javax.swing.JLabel();
        Start = new javax.swing.JButton();
        Stop = new javax.swing.JButton();
        Restart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tiempo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Start.setText("Iniciar");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        Stop.setText("Detener");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });

        Restart.setText("Reiniciar");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Start)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Stop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Restart)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Start)
                    .addComponent(Stop)
                    .addComponent(Restart))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

private void StartActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // Introducir los segundos deseados:
        segundos = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Con cuántos segundos?"));
        copiasegundos=segundos; // Para recordar cuántos segundos introducimos.
        // Aquí declaramos nuestro taskPerformer, que es un parámetro de nuestro Timer,
        // básicamente aquí se introduce lo que hará el Timer cada 1000 milisegundos.
        
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Muestra en pantalla los segundos restantes:
                Tiempo.setText("Quedan " + String.valueOf(segundos) + " segundos..."); 
                // Comprueba si segundos es igual a cero para detener el Timer.
                if(segundos<=0) 
                {
                    Tiempo.setText("La cuenta regresiva ha terminado."); // Muestra mensaje.
                    Toolkit.getDefaultToolkit().beep(); // Emite sonido.
                    Reloj.stop(); // Detiene el timer y se deja de ejecutar ésto.
                }
                segundos--; // Reduce la cantidad de segundos.
            }
        }; // Fin de la declaración del ActionListener.
        
        // Creamos un nuevo Timer, indicando el retraso (delay),
        // y la acción a ejecutar, osea, taskPerformer(Arriba):
        Reloj = new Timer(delay, taskPerformer);
        Reloj.start(); // Empieza la ejecución del timer.
}                                     

private void StopActionPerformed(java.awt.event.ActionEvent evt) {                                     
Toolkit.getDefaultToolkit().beep(); // Emite sonido.
Reloj.stop(); // Detiene el timer y se deja de ejecutar ésto.
Tiempo.setText("La cuenta regresiva se ha detenido."); // Muestra mensaje.
}                                    

private void RestartActionPerformed(java.awt.event.ActionEvent evt) {                                        
Tiempo.setText("Cuenta regresiva reiniciada.");
segundos=copiasegundos; // Reinicializa el valor de segundos 
                        // para no introducirlos de nuevo.
Reloj.restart(); // Reinicia el timer.
}                                       

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
            java.util.logging.Logger.getLogger(PruebaTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaTimer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaTimer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton Restart;
    private javax.swing.JButton Start;
    private javax.swing.JButton Stop;
    private javax.swing.JLabel Tiempo;
    // End of variables declaration                   
}