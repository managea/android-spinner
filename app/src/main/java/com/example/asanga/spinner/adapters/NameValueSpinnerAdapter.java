package com.example.asanga.spinner.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asanga.spinner.R;
import com.example.asanga.spinner.models.NameValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asanga Manage on 22/01/15.
 */
public class NameValueSpinnerAdapter extends ArrayAdapter<NameValue> {
    private int customView;
    private LayoutInflater layoutInflater;

    public NameValueSpinnerAdapter(Context context, int resource, List<NameValue> objects) {
        super(context, resource, objects);
        this.customView = resource;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(customView, parent, false);
        }

        TextView nameTxtView = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView valueTxtView = (TextView) convertView.findViewById(R.id.valueTextView);
        NameValue nameValue = getItem(position);
        nameTxtView.setText(nameValue.getName());
        valueTxtView.setText(nameValue.getValue());
        return convertView;

    }
}
