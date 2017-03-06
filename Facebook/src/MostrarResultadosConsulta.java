/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author startX

public class MostrarResultadosConsulta extends javax.swing.JFrame {

   
    public MostrarResultadosConsulta() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
      
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarResultadosConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarResultadosConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarResultadosConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarResultadosConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarResultadosConsulta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
*/
import java.awt.*;  
import java.awt.event.*;  
import java.sql.*;  
import java.util.*;  
import javax.swing.*;  
import javax.swing.table.*;  

public class MostrarResultadosConsulta extends javax.swing.JFrame {
    static final String CONTROLADOR_JDBC = "com.mysql.jdbc.Driver";  
    static final String URL_BASEDEDATOS = "jdbc:mysql://localhost/FACE?user=root&amp;amp;password=";  

// la consulta predeterminada recupera todos los datos de la tabla autores  
   static final String CONSULTA_PREDETERMINADA = "SELECT * FROM PAIS";  
   private ModeloTablaResultados modeloTabla;  

//private JTextArea areaConsulta;  



    /** Creates new form MostrarResultadosConsulta */
    public MostrarResultadosConsulta() {
                      
        super( "Mostrando resultados de la consulta" );  
        initComponents();
        setLocation(100,150);
        // crear objeto ModeloTablaResultados y mostrar tabla de la base de datos  
        try {  
            // crear objeto TableModel para los resultados del a consulta SELECT * FROM autores  
            modeloTabla = new ModeloTablaResultados( CONTROLADOR_JDBC, URL_BASEDEDATOS, CONSULTA_PREDETERMINADA );  
           JTable tablaResultados = new JTable(modeloTabla);  
           getContentPane().setLayout(new BorderLayout());  
            getContentPane().add( new JScrollPane(tablaResultados) , BorderLayout.CENTER );  
            // establecer tamaño de ventana y mostrarla en pantalla  
            setSize( 500, 250 );  
            setVisible( true );  
            }  // fin de bloque try  
            // atrapar la excepción ClassNotFoundException lanzada por el  
            // objeto ModeloTablaResultados si no se encuentra el controlador de la base de datos  
         catch ( ClassNotFoundException claseNoEncontrada ) {  
                JOptionPane.showMessageDialog( null, "No se encontro el controlador de la base de datos", "No se encontro el controlador",JOptionPane.ERROR_MESSAGE );  
                System.exit( 1 );   // terminar la aplicación  
           } // fin de bloque catch  
            // atrapar la excepción SQLException lanzada por el objeto ModeloTablaResultados  
            // si ocurren problemas al establecer la conexión a la base de datos  
            // y realizar la consulta en la misma  
            catch ( SQLException excepcionSQL ) {  
            JOptionPane.showMessageDialog( null, excepcionSQL.getMessage(),  "Error en la base de datos", JOptionPane.ERROR_MESSAGE );  
            // asegurar que la conexión a la base de datos esté cerrada  
            modeloTabla.desconectarDeLaBaseDeDatos();  
            System.exit( 1 );   // terminar la aplicación  
            }  
            // desechar la ventana cuando el usuario salga de la aplicación  
            // (esta opción sobrescribe a la opción predeterminada de HIDE_ON_CLOSE)  
            setDefaultCloseOperation( DISPOSE_ON_CLOSE );  
            // asegurar que la conexión a la base de datos esté cerrada cuando el usuario salga de la aplicación  
            addWindowListener( new WindowAdapter() {  // desconectarse de la base de datos y salir cuando se haya cerrado la ventana  
            public void windowClosed( WindowEvent evento ) {  
            modeloTabla.desconectarDeLaBaseDeDatos();  
            System.exit( 0 ); 
            dispose();} }  );  

         
        
}// fin del constructor
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>                        
    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MostrarResultadosConsulta().setVisible(true);
                JFrame.setDefaultLookAndFeelDecorated(true); 
        new MostrarResultadosConsulta(); 
            }
        });
    }
    
    // Variables declaration - do not modify                     
    // End of variables declaration                   
    
}
