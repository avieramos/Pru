package com.example.domandroid;



import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ActModul extends  Activity{
	
	private Modul myMod;
	private TextView txtValDesead;
	private TextView txtValAct;
	private TextView txtNombrMod;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_modul);
		
		myMod=new Modul();
		findViews();
		cargaMod();
		cargaValores();
	}

	private void findViews(){
		txtNombrMod=(TextView)findViewById(R.id.txtModDesc );
		txtValDesead=(TextView)findViewById(R.id.txtModValDesad);
		txtValAct=(TextView)findViewById(R.id.txtModValAct);
		
	}
	
	private void cargaMod(){
		myMod.Desc=getIntent().getStringExtra(Modul.lblDesc );
		myMod.ValAct=getIntent().getStringExtra(Modul.lblValAct );
	}
	
	private void cargaValores(){
		txtNombrMod.setText(myMod.Desc);
		txtValAct.setText(myMod.ValAct);
		txtValDesead.setText(myMod.ValAct);
	}
}
