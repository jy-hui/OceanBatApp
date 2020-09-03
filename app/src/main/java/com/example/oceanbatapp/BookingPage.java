package com.example.oceanbatapp;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookingPage extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
        String[] Services = {  "Choose","Car cleaning services", "House cleaning services", "Garden cleaning services", "Motorcycle cleaning services"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.booking);
                //Getting the instance of Spinner and applying OnItemSelectedListener on it
                Spinner spin = (Spinner) findViewById(R.id.services_spinner);
                spin.setOnItemSelectedListener(this);

                //Creating the ArrayAdapter instance having the country list
                ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Services);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //Setting the ArrayAdapter data on the Spinner
                spin.setAdapter(aa);

        }

        //Performing action onItemSelected and onNothing selected
        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                Toast.makeText(getApplicationContext(),Services[position] , Toast.LENGTH_LONG).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
        }
}