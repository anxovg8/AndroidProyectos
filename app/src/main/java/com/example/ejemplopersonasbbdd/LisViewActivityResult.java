package com.example.ejemplopersonasbbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ejemplopersonasbbdd.entidades.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class LisViewActivityResult extends AppCompatActivity {
    ListView listView;
    ArrayList<String> usuarios;
    ArrayAdapter<String> adapter;

    Button bt;

    protected static final int CODIGO_INTENT = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lis_view_result);
        bt =(Button) findViewById(R.id.btSi);
        bt.setOnClickListener(v->IntentResult());
        listView = (ListView) findViewById(R.id.listViewSS);
        usuarios = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,usuarios);
        listView.setAdapter(adapter);
    }

    public void IntentResult(){
        this.startActivityForResult(new Intent(this, PruebaAtivityResult.class), CODIGO_INTENT);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Usuario u;
        if(resultCode == RESULT_OK && requestCode == CODIGO_INTENT) {
             u = new Usuario();
             String id=data.getStringExtra("ID");
             Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();
             u.setId(Integer.parseInt(id));
             u.setNombre(data.getStringExtra("NOMBRE"));
             u.setTelefono(data.getStringExtra("TELEFONO"));
             usuarios.add(u.getId()+" - "+u.getNombre()+" - "+u.getTelefono());
             adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(),"furrula",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"No furrula",Toast.LENGTH_LONG).show();
        }
    }
}