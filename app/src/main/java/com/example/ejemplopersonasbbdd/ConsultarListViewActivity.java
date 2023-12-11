package com.example.ejemplopersonasbbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ejemplopersonasbbdd.entidades.Usuario;
import com.example.ejemplopersonasbbdd.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarListViewActivity extends AppCompatActivity {

    ListView listViewPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;

    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_list_view);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"BDUsuarios",null,1);

        listViewPersonas= (ListView) findViewById(R.id.listViewPersonas);
        
        consultarListaPersonas();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);
        
    }

    private void consultarListaPersonas() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuario = null;
        listaUsuarios = new ArrayList<Usuario>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while(cursor.moveToNext()){
            usuario = new Usuario();

            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaUsuarios.add(usuario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();

        for(int i=0;i<listaUsuarios.size();i++){
            listaInformacion.add(listaUsuarios.get(i).getId()
                    +" - "+listaUsuarios.get(i).getNombre());
        }
    }
}