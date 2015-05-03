package com.example.easyshop;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	ListView lv = (ListView) findViewById(R.id.listView1);
	
	final String[] mak = getResources().getStringArray(R.array.supa);
	ArrayAdapter<String> adapmak = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mak);
	lv.setAdapter(adapmak);
	lv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			parent.getItemAtPosition(position);
			
			if(position == 0)
			{
				chooseuchumi();
			}else if (position==1){
	           choosenakumat();
	            } else if (position==2){
	         choosenaivas();
	            }else if(position == 3)
	            {
	            	choosetuskys();
	            }
			
			
			
		}
	});
	
	}

	protected void choosetuskys() {
		// TODO Auto-generated method stub
		startActivity(new Intent("android.intent.action.tuskys"));
	}

	protected void choosenaivas() {
		// TODO Auto-generated method stub
		startActivity(new Intent("android.intent.action.naivas"));
	}

	protected void choosenakumat() {
		// TODO Auto-generated method stub
		startActivity(new Intent("android.intent.action.nakumatt"));
	}

	protected void chooseuchumi() {
		// TODO Auto-generated method stub
		startActivity(new Intent("android.intent.action.uchumi"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
