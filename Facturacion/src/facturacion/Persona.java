/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

/**
 *
 * @author ANDRES
 */
public class Persona {
    
    
    protected String documento; 
    protected String tipo;
    protected String nombres;
    protected String apellidos;
    protected String direccion;
    protected String ciudad;
    protected String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    public Persona(String documento, String tipo, String nombres, String apellidos, String direccion, String ciudad,String telefono) {
        this.documento = documento;
        this.tipo = tipo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;       
        this.ciudad = ciudad;
        this.telefono=telefono;
    }
    
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
