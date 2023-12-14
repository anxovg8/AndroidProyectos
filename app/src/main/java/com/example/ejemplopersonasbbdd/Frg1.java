package com.example.ejemplopersonasbbdd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Frg1 extends Fragment {
    EditText ed1;
    Button btMandarDatos;

    TextView tx1;
    private int id;

    public Frg1() {

        // Required empty public constructor
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg1, container, false);

        ed1 = view.findViewById(R.id.ed1);
        btMandarDatos = view.findViewById(R.id.btMandarDato);

        btMandarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx1 = getActivity().findViewById(R.id.edResultadoSuma);
                int valor1 = 0;
                int valor2 = Integer.parseInt(ed1.getText().toString());
                int suma =0;


                    if (tx1.getText().equals("")) {
                        tx1.setText("0");

                    }
                    else if(!tx1.getText().equals("")){
                        valor1 = Integer.parseInt(tx1.getText().toString());
                        suma = valor1 + valor2;
                        tx1.setText(String.valueOf(suma));

                    }








            }
        });

        return view;
    }

}