package com.example.handlermessage;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	static Context context;
	Button b1,b2;
	ProgressBar pb1;
	TextView t1;
	static Handler miHandler;
	ProgressBarThread miThread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//variables
		context=getApplicationContext();
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		pb1=(ProgressBar)findViewById(R.id.progressBar1);
		t1=(TextView)findViewById(R.id.textView2);
		
		miHandler=new Handler()
		{

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				//incrementa en 5 la barra...
				 switch (msg.what) {
		            case 1:
		                // Invalidar vista para repintado
		        		if(pb1.getProgress()<90){
		  				  pb1.setProgress(pb1.getProgress()+10);
		  				  pb1.invalidate();
		  				  t1.setText(t1.getText()+"\nEl Thread background ha enviado mensaje");
		  				  t1.setText(t1.getText()+"\nprogreso = "+pb1.getProgress());
		        		}else {
		        			
		        			miThread.setRunning(false);
		        		}
		                
		                break;
		            case 2:
		            	//el Thread en background ha finalizado
		            	t1.setText(t1.getText()+"\nEl Thread en background ha finalizado");
		            	break;
		            }
		
			
			}
			
		};
		//Listeners
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 
				//Arranca el Thread en background...
				miThread=new ProgressBarThread();
				miThread.setRunning(true);
				miThread.start();
			
				
			}
		});
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	public static  Context agetApplicationContext()
	{
		return context;
	}
	
	
}
