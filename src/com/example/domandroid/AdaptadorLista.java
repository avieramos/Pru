package com.example.domandroid;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class AdaptadorLista extends BaseAdapter{
	
	ArrayList<HashMap<String,Object>> listaModulos;
    LayoutInflater layoutinflator;
    Context context;
    
    AdaptadorLista(ArrayList<HashMap<String,Object>> lista,Context con)
    {
   
    	listaModulos=lista;
        layoutinflator=LayoutInflater.from(con);
        this.context=con;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listaModulos.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listaModulos.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        VistaMods miVistaMods;
        if(convertView==null){
        	convertView=layoutinflator.inflate(R.layout.act_configmod, null);
	        miVistaMods = new VistaMods();
	        miVistaMods.v1=(TextView)convertView.findViewById(R.id.txtConfigModNombre);
	        miVistaMods.s2=(Spinner)convertView.findViewById(R.id.desplConfigModTipo);
	        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.context, R.array.tipoModulos, android.R.layout.simple_spinner_item);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			miVistaMods.s2.setAdapter(adapter);
	        miVistaMods.v3=(TextView)convertView.findViewById(R.id.txtConfigModEntrada);
	        miVistaMods.v4=(TextView)convertView.findViewById(R.id.txtConfigModSalida);
	        convertView.setTag(miVistaMods);
        }
        else{
        	miVistaMods=(VistaMods) convertView.getTag();
        }
       
        miVistaMods.v1.setText((String) listaModulos.get(position).get("nombre"));
        /*miVistaMods.s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/
        miVistaMods.s2.setSelection((Integer) listaModulos.get(position).get("tipo"));
        miVistaMods.v3.setText((String) listaModulos.get(position).get("entrada"));
        miVistaMods.v4.setText((String) listaModulos.get(position).get("salida"));
       
        return convertView;
    }


}
