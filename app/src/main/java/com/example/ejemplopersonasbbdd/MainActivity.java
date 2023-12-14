package com.example.ejemplopersonasbbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btRegistro;
    Button btConsultar;
    Button btConsultarSpinner;

    Button btConsultarListView;

    Button activityR;
    Button btFrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "BDUsuarios", null, 1);
        btRegistro = (Button) findViewById(R.id.btRegistrar);
        btConsultar = (Button) findViewById(R.id.btConsultarUsuarios);
        btConsultarSpinner = (Button) findViewById(R.id.btConsultarConSpinner);
        btConsultarListView = (Button) findViewById(R.id.btConsultaListView);
        activityR = (Button) findViewById(R.id.btListOnActivity);
        btFrg = (Button) findViewById(R.id.btFragment);

        btRegistro.setOnClickListener(view -> intentRegistro());
        btConsultar.setOnClickListener(view -> intentConsulta());
        btConsultarSpinner.setOnClickListener(view -> intentConsultaSpinner());
        btConsultarListView.setOnClickListener(view -> intentConsultaLv());
        activityR.setOnClickListener(view -> activityRR());
        btFrg.setOnClickListener(view->intentFrg());
    }


    public void intentRegistro() {
        Intent intent = new Intent(this, RegistroUsuariosActivity.class);
        startActivity(intent);
    }

    public void intentConsulta() {
        Intent intent = new Intent(this, ConsultarUsuariosActivity.class);
        startActivity(intent);
    }

    public void intentConsultaSpinner() {
        Intent intent = new Intent(this, ConsultaComboActivity.class);
        startActivity(intent);
    }

    public void intentConsultaLv() {
        Intent intent = new Intent(this, ConsultarListViewActivity.class);
        startActivity(intent);
    }

    public void activityRR() {
        Intent intent = new Intent(this, LisViewActivityResult.class);
        startActivity(intent);
    }

    public void intentFrg() {
        Intent intent = new Intent(this, EjemploFragments.class);
        startActivity(intent);
    }

}