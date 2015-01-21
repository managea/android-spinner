package com.example.asanga.spinner.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asanga.spinner.R;
import com.example.asanga.spinner.models.NameValue;

import java.util.List;

/**
 * Created by asanga on 22/01/15.
 */
public class NameValueSpinnerAdapter extends ArrayAdapter<NameValue> {

    private int customeView;
    private LayoutInflater layoutInflater;

    public NameValueSpinnerAdapter(Context context, int resource, List<NameValue> objects) {
        super(context, resource, objects);
        this.customeView = resource;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View _convertView, ViewGroup parent) {

//        if (convertView == null) {
//            convertView = layoutInflater.inflate(customeView, parent,false);
//        }

        View convertView = layoutInflater.inflate(R.layout.spinner_item,parent,false);
        TextView nameTxtView = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView valueTxtView = (TextView) convertView.findViewById(R.id.valueTextView);

        if(position == 0){
            nameTxtView.setText("-");
            valueTxtView.setText("-");
        }else {
            NameValue nameValue = getItem(position);
            nameTxtView.setText(nameValue.getName());
            valueTxtView.setText(nameValue.getValue());
        }
        return convertView;

    }
}
