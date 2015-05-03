package com.example.easyshop;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Thread thr = new Thread(){
			 @Override
			public void run()
			 {
				
				try{ sleep(6000);
				
				}catch(InterruptedException e){
					e.printStackTrace();
					
				}finally{
					
					startActivity(new Intent("android.intent.action.log"));
				}
				 
				 
			 }};
			 thr.start();
			 
			
	}

	
}
