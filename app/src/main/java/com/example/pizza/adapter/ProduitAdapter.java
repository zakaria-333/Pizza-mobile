package com.example.pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizza.R;
import com.example.pizza.classe.Produit;

import java.util.List;

public  class ProduitAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;

    public ProduitAdapter(List<Produit> produits, Activity activity) {
        this.produits = produits;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produits.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.item, null);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView duree = convertView.findViewById(R.id.duree);
        ImageView photo = convertView.findViewById(R.id.photo);
        TextView id = convertView.findViewById(R.id.id);
        TextView nbr = convertView.findViewById(R.id.nbrIngredient);



        nom.setText(produits.get(position).getNom());
        duree.setText(produits.get(position).getDuree()+"");
        photo.setImageResource(produits.get(position).getPhoto());
        id.setText(produits.get(position).getId()+"");
        nbr.setText(produits.get(position).getNbrIngredients()+"");


        return convertView;
    }
}