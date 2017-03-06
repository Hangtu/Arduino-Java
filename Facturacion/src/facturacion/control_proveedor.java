
package facturacion;

import javax.swing.JOptionPane;

/**
 *
 * @author ANDRES
 */
public class control_proveedor extends Persona {
    
private String Nombre_comercial;
Sentencias_sql sql;

    public control_proveedor(String documento, String tipo, String nombres, String apellidos, String Nombre_comercial, String direccion, String ciudad,String telefono)
    { 
        super(documento, tipo, nombres, apellidos, direccion, ciudad, telefono);
        this.Nombre_comercial=Nombre_comercial;
        sql = new Sentencias_sql();
    }
    
    
    
    public boolean ingresar_proveedor()
    {               
       
            String datos[] = {documento,tipo,nombres,apellidos,Nombre_comercial,direccion,ciudad, telefono};           
            return sql.insertar(datos, "insert into proveedor(No_documento, cod_tipo_documento, Nombre, Apellido,Nombre_comercial,direccion, cod_ciudad, Telefono) values(?,?,?,?,?,?,?,?)");
                                  
        
        
    }
    public Object[][] consulta_proveedor(){
        String[] columnas={"No_documento","Descripcion","Nombre","Apellido","Nombre_comercial","Direccion","Nombre_ciudad","Telefono"};
        Object[][] datos = sql.GetTabla(columnas, "proveedor", "select No_documento,Descripcion,Nombre,Apellido,Nombre_comercial,Direccion,Nombre_ciudad,Telefono from proveedor,ciudad,tipo_de_documento where id_tipo_documento=cod_tipo_documento and Codigo_ciudad=cod_ciudad;");
        return datos;
    }
}
