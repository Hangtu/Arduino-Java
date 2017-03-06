/*
 * ModeloTablaResultados.java
 *
 * Created on 9 de noviembre de 2010, 12:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author marie
 */
import java.sql.*;  
import java.util.*;  
import javax.swing.table.*;  

public class ModeloTablaResultados  extends AbstractTableModel{
    
    /** Creates a new instance of ModeloTablaResultados */
    public ModeloTablaResultados() {
    }
     private Connection conexion;  
     private Statement instruccion;  
     private ResultSet conjuntoResultados;  
     private ResultSetMetaData metaDatos;  
     private int numeroDeFilas;  
     // mantener el registro del estado de la conexión a la base de datos  
     private boolean conectadoALaBaseDeDatos = false;  
     // inicializar conjuntoResultados y obtener su objeto de meta datos;  
     // determinar el número de filas  
     public ModeloTablaResultados( String controlador, String url,  
        String consulta ) throws SQLException, ClassNotFoundException {  
        // cargar clase de controlador de base de datos  
     Class.forName( "com.mysql.jdbc.Driver");  
        // conectarse a la base de datos  
     //Connection con = DriverManager.getConnection( "jdbc:mysql://localhost/TUTORADOS", "root", "" );
     conexion = DriverManager.getConnection( "jdbc:mysql://localhost/FACE", "root", "");  // url
    // crear objeto Statement para consultar la base de datos  
    instruccion = conexion.createStatement(  
    ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY );  
    // actualizar estado de conexión a la base de datos  
    conectadoALaBaseDeDatos = true;  
    // establecer consulta y ejecutarla  
    establecerConsulta( consulta );  
}  

   // obtener la clase que representa al tipo de columna  

public Class getColumnClass( int columna ) throws IllegalStateException {  
     // asegurar que la conexión a la base de datos esté disponible  
    if ( !conectadoALaBaseDeDatos )  
        throw new IllegalStateException( "No hay conexion a la base de datos" );  
     // determinar la clase de Java de columna  
   try {  
        String nombreClase = metaDatos.getColumnClassName( columna + 1 );  
        // devolver objeto Class que representa a nombreClase  
       return Class.forName( nombreClase );  
        }  
       // atrapar excepciones SQLException y ClassNotFoundException  
       catch ( Exception excepcion ) {  
       excepcion.printStackTrace();  }  
       // si ocurren problemas arriba, suponer que es tipo Object  
       return Object.class;  

}  

// obtener el número de columnas en el objeto ResultSet  

 public int getColumnCount() throws IllegalStateException {  
      // asegurar que la conexión a la base de datos esté disponible  
      if ( !conectadoALaBaseDeDatos )  
           throw new IllegalStateException( "No hay conexion a la base de datos" );  
       // determinar el número de columnas  
      try {  
           return metaDatos.getColumnCount();  
           }  
           // atrapar excepciones SQLException e imprimir mensaje de error  
          catch ( SQLException excepcionSQL ) { excepcionSQL.printStackTrace();  }  
       // si ocurren problemas arriba, devolver 0 para el número de columnas  
       return 0;  
 }  
// obtener el nombre de una columna específica en el objeto ResultSet  
public String getColumnName( int columna ) throws IllegalStateException {  
        // asegurar que la conexión a la base de datos esté disponible  
    if ( !conectadoALaBaseDeDatos )  
        throw new IllegalStateException( "No hay conexion a la base de datos" );  
    // determinar el nombre de la columna  
        try {   return metaDatos.getColumnName( columna + 1 );  }  
        // atrapar excepciones SQLException e imprimir mensaje de error  
            catch ( SQLException excepcionSQL ) {  excepcionSQL.printStackTrace();  }  
        // si hay problemas, devolver cadena vacía para el nombre de la columna  
        return "";  
}  

// devolver el número de filas en el objeto ResultSet  
public int getRowCount() throws IllegalStateException {  
    // asegurar que la conexión a la base de datos esté disponible  
      if ( !conectadoALaBaseDeDatos )  
         throw new IllegalStateException( "No hay conexion a la base de datos" );  
        return numeroDeFilas;  
}  
// obtener el valor en una fila y columna específicas  
public Object getValueAt( int fila, int columna ) throws IllegalStateException {  
// asegurar que la conexión a la base de datos esté disponible  

     if ( !conectadoALaBaseDeDatos )  
           throw new IllegalStateException( "No hay conexion a la base de datos" );  
      // obtener un valor en una fila y columna específicas del objeto ResultSet  
      try {  
          conjuntoResultados.absolute( fila + 1 );  
          return conjuntoResultados.getObject( columna + 1 );  }  
      // atrapar excepciones SQLExceptions e imprimir mensaje de error  
      catch ( SQLException excepcionSQL ) {  excepcionSQL.printStackTrace();  }  
    // si hay problemas, devolver objeto cadena vacía  
       return "";  
}  
// establecer nueva cadena de consulta para la base de datos  
public void establecerConsulta( String consulta )throws SQLException, IllegalStateException {  
// asegurar que la conexión a la base de datos esté disponible  
    if ( !conectadoALaBaseDeDatos )  
       throw new IllegalStateException( "No hay conexion a la base de datos" );  
     // especificar consulta y ejecutarla  
     conjuntoResultados = instruccion.executeQuery("SELECT * FROM PAIS"); //consulta );  
     // obtener meta datos para el objeto ResultSet  
      metaDatos = conjuntoResultados.getMetaData();  
      // determinar el número de filas en el objeto ResultSet  
       conjuntoResultados.last();                   // mover a la última fila  
       numeroDeFilas = conjuntoResultados.getRow();  // obtener número de fila  
       // notificar al objeto JTable que el modelo ha cambiado  
      fireTableStructureChanged();  
}  
// cerrar objetos Statement y Connection  
public void desconectarDeLaBaseDeDatos() {  
     // cerrar objetos Statement y Connection  
 try {  instruccion.close();  
       conexion.close();  }  
     // atrapar excepciones SQLException e imprimir mensaje de error  
     catch ( SQLException excepcionSQL ) {  excepcionSQL.printStackTrace();  }  
     // actualizar estado de conexión a la base de datos  
   finally {  conectadoALaBaseDeDatos = false;  }  

}  
   
}
