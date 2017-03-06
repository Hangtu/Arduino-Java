/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static javax.swing.JOptionPane.*;

/**
 *
 * @author startX
 */
public class Inicio {
    //Declaracion De Variables

    String nombre[] = new String[10];
    String contraseña[] = new String[10];
    String mensajes[] = new String[10];
    int registrados = 0;
    int se_in = 0;
    int envios = 0;
    int envio = 0;

    public void registro() { // Registrar Usuarios
        nombre[registrados] = showInputDialog(null, "Dame Tu Nombre");
        contraseña[registrados] = showInputDialog(null, "Dame Tu Contraseña");
        showMessageDialog(null, nombre[registrados] + " Haz Sido Registrado Con Exito!");
        registrados++;
    }

    public void registrados() {
        if (registrados > 0) {
            String cad = "";
            for (int i = 0; i < registrados; i++) {
                cad = cad + i + " : " + nombre[i] + "\n";
            } //fin del for
            showMessageDialog(null, cad);
        }//fin del if
        else {
            showMessageDialog(null, "No Existen Usuarios");
        }
    }

    public int inicio_sesion(String usuario, String contraseñas) {
        for (int i = 0; i < registrados; i++) {
            if (usuario.equals(nombre[i]) && contraseñas.equals(contraseña[i])) {
                se_in = i;
                showMessageDialog(null, "Bienvenido " + nombre[i]);
                return 1;
            }
        }//for
        showMessageDialog(null, "Usuario O Contraseña Incorrecta ");
        return 0;
    } //fin  de inicio_sesion


    public void cerrar_sesion() {
        showMessageDialog(null, "Hasta Pronto " +nombre[se_in]);
    }

    public void enviar_mensaje(String mensaje) {
        String cad = "";
        for (int i = 0; i < registrados; i++) {
            cad = cad + i + " : " + nombre[i] + "\n";
        }
        envio = Integer.parseInt(showInputDialog(null, "***Usuarios Disponibles***\n \n" + cad  + "\n" + "\n" +" Escoje Un Numero"));
        showMessageDialog(null, "Mensaje Enviado a  " + nombre[envio]);
        //enviando el mensaje
        mensajes[0] = mensaje;
       
    } //fin de enviar mensaje

      public String bandejaEntrada(){
          if(nombre[se_in].equals(nombre[envio])){ 
              return mensajes[0];
          }
          else{
              showMessageDialog(null,"Usted No Tiene Nuevos Mensajes");
              return "";
          }      
      } //fin del metodo
}
