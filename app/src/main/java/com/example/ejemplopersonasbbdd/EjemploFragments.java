package com.example.ejemplopersonasbbdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class EjemploFragments extends AppCompatActivity {
    Fragment frg1,frg2,frg3;
    ArrayList<Frg1> fragmentos;
    TextView txResultado;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_fragments);
        frg1 = (Frg1) getSupportFragmentManager().findFragmentById(R.id.frg1);
        frg2 = (Frg1) getSupportFragmentManager().findFragmentById(R.id.frg2);
        frg3 = (Frg2) getSupportFragmentManager().findFragmentById(R.id.frg3);
        txResultado = (TextView) findViewById(R.id.edResultadoSuma);
        fragmentos.add((Frg1)frg1);
        fragmentos.add((Frg1)frg2);


    }


    public ArrayList<Frg1> getFragmentos() {
        return fragmentos;
    }
}