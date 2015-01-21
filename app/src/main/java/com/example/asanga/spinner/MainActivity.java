package com.example.asanga.spinner;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import com.example.asanga.spinner.adapters.NameValueSpinnerAdapter;
import com.example.asanga.spinner.models.NameValue;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<NameValue> nameValues = new ArrayList<>();
        nameValues.add(new NameValue("Samsung", "Galaxy"));
        nameValues.add(new NameValue("HTC", "Hero"));
        nameValues.add(new NameValue("Nokia", "Lumia"));
        nameValues.add(new NameValue("Apple", "Iphone"));

        NameValueSpinnerAdapter nameValueSpinnerAdapter = new NameValueSpinnerAdapter(this, R.layout.spinner_item,nameValues);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(nameValueSpinnerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
