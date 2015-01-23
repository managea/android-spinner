package com.example.asanga.spinner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.asanga.spinner.adapters.NameValueSpinnerAdapter;
import com.example.asanga.spinner.models.NameValue;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Spinner nameValueSpinner;
    private TextView spinnerSelectionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameValueSpinner = (Spinner) findViewById(R.id.spinner);
        spinnerSelectionTextView = (TextView) findViewById(R.id.spinnerSelectionTextView);
        setupSpinner();
    }

    private void setupSpinner() {
        // Setup data
        List<NameValue> nameValues = createDummyValues();
        NameValueSpinnerAdapter nameValueSpinnerAdapter = new NameValueSpinnerAdapter(this, R.layout.spinner_item, nameValues);
        nameValueSpinner.setAdapter(nameValueSpinnerAdapter);

        // Setup behaviour
        nameValueSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                NameValue selection = (NameValue) nameValueSpinner.getItemAtPosition(position);
                spinnerSelectionTextView.setText(selection.getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<NameValue> createDummyValues() {
        List<NameValue> nameValues = new ArrayList<>();
        nameValues.add(new NameValue("Samsung", "Galaxy"));
        nameValues.add(new NameValue("HTC", "Hero"));
        nameValues.add(new NameValue("Nokia", "Lumia"));
        nameValues.add(new NameValue("Apple", "Iphone"));
        return nameValues;
    }

}