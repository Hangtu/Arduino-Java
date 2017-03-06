package com.example.proyecto_hilos;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Thread hilo;
	Handler handler;
	Runnable proceso;
	TextView hora_minutos,segundos,fecha;
	Date date;
	SimpleDateFormat format;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_main);
		hora_minutos=(TextView) findViewById(R.id.textView1);
		segundos=(TextView) findViewById(R.id.textView4);
		fecha=(TextView) findViewById(R.id.textView2);
		
		crearHilo();
	}

	private void crearHilo(){
		handler = new Handler();
		
		
		proceso = new Runnable(){
            public void run() {
                    try{
                    	date=new Date();
                    	format = new SimpleDateFormat("HH:mm:ss");
                    	
                           hora_minutos.setText(""+format.format(date).substring(0,format.format(date).length()-3));
                           segundos.setText(""+format.format(date).substring(format.format(date).length()-2,format.format(date).length()));
                           format = new SimpleDateFormat("dd/MM/yyyy");
                           fecha.setText(""+format.format(date));
                    } catch(Exception e){
                           Toast.makeText(getApplicationContext(),"Error en handler",Toast.LENGTH_SHORT).show();
                          }
            }
		};
            
		new Thread(new Runnable() {
			public void run(){
                try{
                        while(true){
                        handler.post(proceso);
                        Thread.sleep(1000);
                        }
                }
                catch(Exception e){
                        Toast.makeText(getApplicationContext(),"Error en el hilo",Toast.LENGTH_SHORT).show();
                       }
                }
		}).start();
		
	}// hilo
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
