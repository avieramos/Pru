package com.example.domandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ActValores extends Activity {

	protected static final int REQUEST_MOD = 1;
	
	Modul[] mods;
	ListView lstMods;
	private Button btnConfig;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_valores);
		btnConfig = (Button) findViewById(R.id.btnConfig);
		btnConfig.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarConfig(null);
				
			}
		});
				
		findViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_valores, menu);
		return true;
	}
	
	private Modul[] GetModuls(){
		Modul[] myMods;
		
		//todo Leer esto de la configuración
		
		myMods =new Modul[3];
		Modul modAct= new Modul();
		modAct.Desc="Temperatura salón";
		modAct.ValAct="21";
		myMods[0]=modAct;
		modAct= new Modul();
		modAct.Desc="Humedad jardín";
		modAct.ValAct="64";
		myMods[1]=modAct;
		modAct= new Modul();
		modAct.Desc="Humedad salón";
		modAct.ValAct="76";
		myMods[2]=modAct;

		return myMods;
	}
	
	private void findViews(){
		
		lstMods=(ListView) findViewById(R.id.lstModuls);
		
		mods=GetModuls();
		Activity context=(Activity) ActValores.this;
		AdaptListMod adapt=new AdaptListMod(context,mods) ;
		
		lstMods.setAdapter(adapt);
		lstMods.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		    	MuestraMod(mods[position]);
		    }
		  });
	
	}
	
	protected void MuestraMod(Modul myMod) {
		Intent i=new Intent(this, ActModul.class);
   
		i.putExtra(Modul.lblDesc, myMod.Desc );
		i.putExtra(Modul.lblValAct , myMod.ValAct);

    	startActivityForResult(i,REQUEST_MOD);
	}
	
	public void lanzarConfig(View view){
		Intent i = new Intent(this,ActConfig.class);
    	startActivity(i);
	}

	

}

