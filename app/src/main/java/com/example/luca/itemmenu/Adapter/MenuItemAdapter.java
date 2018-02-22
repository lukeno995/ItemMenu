package com.example.luca.itemmenu.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luca.itemmenu.Model.MenuItem;
import com.example.luca.itemmenu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luca on 21/02/2018.
 */

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MyViewHolder> {
    private List<MenuItem> menuList;
    private OnItemClickListener mListener;
    public interface  OnItemClickListener{
        void onItemClick (int position);
    }

    public void setOnItemClickcListener(OnItemClickListener listener){
        mListener = listener;
    }


    public MenuItemAdapter(ArrayList<MenuItem> menuList) {
        this.menuList = menuList;
    }


    @Override
    public MenuItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_card, parent, false);
        return new MyViewHolder(itemView,mListener);
    }

    @Override
    public void onBindViewHolder(MenuItemAdapter.MyViewHolder holder, int position) {
        MenuItem menu = menuList.get(position);
        holder.nomeP.setText(menu.getNomePiatto());
        holder.costo.setText("Prezzo "+ menu.getCosto()+"€");
        holder.categoria.setText("Categoria "+menu.getCategoria());
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nomeP,costo,categoria;
        public CardView cardView;
        public MyViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            nomeP = itemView.findViewById(R.id.textPiatto);
            costo = itemView.findViewById(R.id.textCosto);
            categoria = itemView.findViewById(R.id.textCategoria);
            cardView =  itemView.findViewById(R.id.card_view);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(listener != null){
                       int pos = getAdapterPosition();
                       if(pos !=RecyclerView.NO_POSITION){
                               listener.onItemClick(pos);


                       }
                   }
                }
            });
        }
    }
}
