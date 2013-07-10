package com.example.domandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActConfig extends Activity {
	
	private Button btnModulos;
	private Button btnConexion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_config);
		btnModulos = (Button) findViewById(R.id.btnConfigModul);
		btnModulos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarConfigModulos(null);
			}
		});
	}
	
	public void lanzarConfigModulos(View view){
		Intent i = new Intent(this,ActConfigMod.class);
		startActivity(i);
	}

}
