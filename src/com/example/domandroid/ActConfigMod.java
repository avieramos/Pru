package com.example.domandroid;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class ActConfigMod extends Activity{
	
	//private Spinner desplConfigModTipo;
	//final String[] tipoModulos = new String[]{"Sensor Temperatura", "Sensor Humedad", "LED", "Botón"};
	private VistaMods miVistaMods;
	static final ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_modulos);
				
		//desplConfigModTipo = (Spinner) findViewById(R.id.desplConfigModTipo);
		//ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tipoModulos, android.R.layout.simple_spinner_item);
		//adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//desplConfigModTipo.setAdapter(adapter);
		
		ListView listView = (ListView) findViewById(R.id.listaMods);
		miVistaMods = new VistaMods(); //sirve para algo?
		obtenerLista();
		
		listView.setAdapter(new AdaptadorLista(list, this));
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}
	
	public void obtenerLista(){
		HashMap<String, Object> map = new HashMap<String, Object>(2);
		map.put("nombre", "Temperatura salon");
		map.put("tipo", 2);
		map.put("entrada", "15");
		map.put("salida", "14");
		list.add(map);
		map=new HashMap<String, Object>();
		map.put("nombre", "Humedad");
		map.put("tipo", 3);
		map.put("entrada", "7");
		map.put("salida", "8");
		list.add(map);
	}

}
