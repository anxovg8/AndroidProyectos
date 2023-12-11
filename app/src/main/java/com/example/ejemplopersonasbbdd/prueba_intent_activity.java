package com.example.ejemplopersonasbbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class prueba_intent_activity extends AppCompatActivity {
    int id;
    EditText edId, edNombre, edTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_intent);

        edId = (EditText) findViewById(R.id.edId);
        edNombre = (EditText) findViewById(R.id.edNombre);
        edTelefono = (EditText) findViewById(R.id.edTelefono);

        id = getIntent().getIntExtra("ID", -1);
        edNombre.setText(getIntent().getStringExtra("NOMBRE"));
        edTelefono.setText(getIntent().getStringExtra("TELEFONO"));

        edId.setText(String.valueOf(id));
    }
}