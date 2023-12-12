package com.example.ejemplopersonasbbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PruebaAtivityResult extends AppCompatActivity {
    protected static final int CODIGO_INTENT = 100;
    int id;
    EditText edId, edNombre, edTelefono;

    Button btRetorno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_ativity_result);


        edId = (EditText) findViewById(R.id.edId);
        edNombre = (EditText) findViewById(R.id.edNombre);
        edTelefono = (EditText) findViewById(R.id.edTelefono);
        btRetorno = (Button) findViewById(R.id.btRetorno);

        btRetorno.setOnClickListener(v -> verDatos2());
        //actualizarIntentResult();
    }

    private boolean verDatos2(){
        Intent intent = new Intent(this, LisViewActivityResult.class);
        intent.putExtra("ID", edId.getText().toString());
        intent.putExtra("NOMBRE", edNombre.getText().toString());
        intent.putExtra("TELEFONO", edTelefono.getText().toString());
        this.setResult(RESULT_OK,intent);
        this.finish();
        //startActivity(intent);
        return true;
    }
}