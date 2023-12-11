package com.example.ejemplopersonasbbdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ejemplopersonasbbdd.entidades.Usuario;

import java.util.ArrayList;

public class UsuariosAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Usuario> usuarios;
    private int layout;

    public UsuariosAdapter(Context context, ArrayList<Usuario> usuarios, int layout) {
        this.context = context;
        this.usuarios = usuarios;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Usuario getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return usuarios.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View v = view;
        if(v==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(layout, null);
        }

        Usuario usuario = getItem(position);
        TextView id = (TextView) v.findViewById(R.id.iduser);
        TextView nombre = (TextView) v.findViewById(R.id.nombreuser);

        id.setText(usuario.getId().toString());
        nombre.setText(usuario.getNombre());

        return v;
    }
}
