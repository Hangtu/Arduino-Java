/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HSQL.ObjectsFromBD;

/**
 *
 * @author Hangtu
 */
public class Usuarios {
    
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;

    public String toString(){
        return nombre +" "+ apellido;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
