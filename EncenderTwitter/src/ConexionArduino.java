import Arduino.Arduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

/**
 *
 * @author Hangtu
 */
public class ConexionArduino {
  
 private String dato;
 private Arduino leonardo=new Arduino();
  
  SerialPortEventListener evento=new SerialPortEventListener() {
    // este metodo se ejecuta cuando arduino manda datos a java;
  public void serialEvent(SerialPortEvent spe) {
  if(leonardo.MessageAvailable()==true){ //MessageAvaliable significa que el mensaje esta listo para mandarse
            dato=leonardo.PrintMessage();
            System.out.println(dato);
       }
    }
};
  
 
  public void conectarArduino(String puerto){
      try {
        puerto=puerto.toUpperCase();
        leonardo.ArduinoRXTX(puerto, 2000,9600,evento);
    } catch (Exception ex) {
          System.out.println("ocurrio un error en el metodo conectarArduino");
    }
  }
  
  public void enviarArduino(String dato) throws Exception{
      leonardo.SendData(dato);
  }
  
  public int RecibirArduino() throws Exception{
     int dato=leonardo.ReceiveData();
     return dato;
  }
  
  public String getDato(){
      return dato;
  }
}
