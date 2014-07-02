package com.example.handlermessage;

import android.os.Message;
import android.widget.Toast;

public class ProgressBarThread extends Thread {
	private boolean running=false;

	public ProgressBarThread() {
		// TODO Auto-generated constructor stub
	}

	public void run()
	{
		
		while(running)
		{
			//envia un mensaje al handler de la activity
			Message msg=new Message();
			msg.what = 1;
			MainActivity.miHandler.sendMessage(msg);
			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//envia mensaje avisando thread ha finalizado
		Message msg=new Message();
		msg.what=2;
		MainActivity.miHandler.sendMessage(msg);
		
	
	}
	public void setRunning(boolean r)
	{
		this.running=r;
	}
}
