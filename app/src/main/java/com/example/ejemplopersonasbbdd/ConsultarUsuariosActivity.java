package com.example.ejemplopersonasbbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejemplopersonasbbdd.utilidades.Utilidades;

public class ConsultarUsuariosActivity extends AppCompatActivity {

    EditText campoId,campoNombre,campoTelefono;
    Button btConsultar,btActualizar,btEliminar;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"BDUsuarios",null,1);

        campoId = (EditText) findViewById(R.id.documentoId);
        campoNombre = (EditText) findViewById(R.id.campoNombreConsulta);
        campoTelefono = (EditText) findViewById(R.id.campoTelefonoConsulta);
        btConsultar = (Button) findViewById(R.id.btConsultar);
        btActualizar = (Button) findViewById(R.id.btActualizar);
        btEliminar = (Button) findViewById(R.id.btEliminar);

        btConsultar.setOnClickListener(view->consultar());
        btActualizar.setOnClickListener(view->actualizarUsuario());
        btEliminar.setOnClickListener(view->eliminarUsuario());

        campoNombre.setVisibility(View.INVISIBLE);
        campoTelefono.setVisibility(View.INVISIBLE);
    }


    /**
     * Metodo que sirve para consultar usuarios de nuestra BBDD
     */
    public void consultar(){
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {campoId.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};
        try{
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO
                    ,campos,Utilidades.CAMPO_ID+"=?"
                    ,parametros,null,null,null);

            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));
            cursor.close();

            campoNombre.setVisibility(View.VISIBLE);
            campoTelefono.setVisibility(View.VISIBLE);
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }

    }


    /**
     * Metodo que sirve para actualizar usuarios de nuestra BBDD
     */
    public void actualizarUsuario(){
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {campoId.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?",parametros);
        limpiar();
        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario",Toast.LENGTH_LONG).show();
        db.close();
    }


    /**
     * Metodo que sirve para eliminar usuarios de nuestra BBDD
     */
    public void eliminarUsuario(){
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {campoId.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se eliminó el usuario",Toast.LENGTH_LONG).show();
        campoId.setText("");
        limpiar();
        db.close();
    }




    public void limpiar(){
        campoNombre.setText("");
        campoTelefono.setText("");
    }




}