/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    
    
    
/**
 *
 * @author ANDRES
 */
public class control_cliente extends Persona {
private Sentencias_sql sql; 


    public control_cliente(String documento, String tipo, String nombres, String apellidos, String direccion, String ciudad,String telefono) {
        super(documento, tipo, nombres, apellidos, direccion, ciudad,telefono);
        sql = new Sentencias_sql();
    }   
    
        
   
    public boolean ingresar_cliente()
    {               
        
            String datos[] = {documento,tipo,nombres,apellidos,direccion,ciudad,telefono};           
            return sql.insertar(datos, "insert into Cliente(Documento, cod_tipo_documento, Nombres, Apellidos, Direccion, cod_ciudad,Telefono) values(?,?,?,?,?,?,?)");
                      
                
    }
    
    public Object[][] consulta_clientes(){
        String[] columnas={"Documento","Descripcion","Nombres","Apellidos","Direccion","Nombre_ciudad","Telefono"};
        Object[][] datos = sql.GetTabla(columnas, "cliente", "select Documento,Descripcion,Nombres,Apellidos,Direccion,Nombre_ciudad,Telefono from cliente,ciudad,tipo_de_documento where id_tipo_documento=cod_tipo_documento and Codigo_ciudad=cod_ciudad;");
        return datos;
    }
     
    
    
}