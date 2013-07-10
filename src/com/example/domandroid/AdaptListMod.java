package com.example.domandroid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdaptListMod extends ArrayAdapter {

	public static Modul[] mods;
	
	Activity context;

	@SuppressWarnings("unchecked")
	AdaptListMod(Activity context, Modul[] mods) {
	        super(context, R.layout.mod_item , mods);
	        this.context = context;
	        this.mods=mods;
	    }

	    public View getView(int position, View convertView, ViewGroup parent) {
	    	try
			{
	    	View item = convertView;
	    	
	    	 if(item == null){
		        LayoutInflater inflater = context.getLayoutInflater();
		        item = inflater.inflate(R.layout.mod_item , null);
	    	 }
	        TextView lblDesc = (TextView)item.findViewById(R.id.txtlstModDesc  );
	        lblDesc.setText(mods[position].Desc);

	        TextView lblUM = (TextView)item.findViewById(R.id.txtlstModUM );
	        lblUM.setText(mods[position].ValAct);
        
	        item.setTag(mods[position]);

	        return(item);
	    }catch(Exception e )
		{
			return null;
		}
	}
}

