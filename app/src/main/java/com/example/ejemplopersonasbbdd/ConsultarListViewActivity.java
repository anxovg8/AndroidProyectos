package com.example.ejemplopersonasbbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ejemplopersonasbbdd.entidades.Usuario;
import com.example.ejemplopersonasbbdd.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarListViewActivity extends AppCompatActivity {
    UsuariosAdapter adaptador;
    ListView listViewPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;

    ConexionSQLiteHelper conn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_list_view);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "BDUsuarios", null, 1);

        listViewPersonas = (ListView) findViewById(R.id.listViewPersonas);

        consultarListaPersonas();

        this.adaptador = new UsuariosAdapter(
                this,
                this.listaUsuarios,
                R.layout.usuarios_adapter
        );

        listViewPersonas.setAdapter(adaptador);
        listViewPersonas.setOnItemLongClickListener((parent, view, position, id) -> verDatos(position));
        //listViewPersonas.setOnItemClickListener(((parent, view, position, id) -> verDatos2(position)));

        /*ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);*/
    }
//    private boolean verDatos2(int position){
//        Intent intent = new Intent(this, PruebaAtivityResult.class);
//        intent.putExtra("ID", listaUsuarios.get(position).getId());
//        intent.putExtra("NOMBRE", listaUsuarios.get(position).getNombre());
//        intent.putExtra("TELEFONO", listaUsuarios.get(position).getTelefono());
//        //this.setResult(RESULT_OK,intent);
//        startActivityForResult(intent,CODIGO_INTENT);
//        return true;
//    }
    private boolean verDatos(int position) {
        Intent intent = new Intent(this, prueba_intent_activity.class);
        intent.putExtra("ID", listaUsuarios.get(position).getId());
        intent.putExtra("NOMBRE", listaUsuarios.get(position).getNombre());
        intent.putExtra("TELEFONO", listaUsuarios.get(position).getTelefono());
        startActivity(intent);
        return true;
    }

    private void consultarListaPersonas() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuario = null;
        listaUsuarios = new ArrayList<Usuario>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO, null);

        while (cursor.moveToNext()) {
            usuario = new Usuario();

            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaUsuarios.add(usuario);
        }

        //return listaUsuarios;
        //obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();

        for (int i = 0; i < listaUsuarios.size(); i++) {
            listaInformacion.add(listaUsuarios.get(i).getId()
                    + " - " + listaUsuarios.get(i).getNombre());
        }
    }
}