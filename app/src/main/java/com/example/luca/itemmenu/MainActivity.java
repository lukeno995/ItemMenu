package com.example.luca.itemmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luca.itemmenu.Adapter.MenuItemAdapter;
import com.example.luca.itemmenu.Model.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MenuItem> menuList;
    private MenuItemAdapter mAdapter;
    private RecyclerView recyclerView;
    private CardView card;
    private TextView textPiatto;
    private TextView textCosto;
    private TextView textCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuList = new ArrayList<>();
        menuData();
        recyclerView = findViewById(R.id.recycler_view);
        textPiatto = findViewById(R.id.textPiatto);
        textCosto = findViewById(R.id.textCosto);
        textCategoria = findViewById(R.id.textCategoria);

        mAdapter = new MenuItemAdapter(menuList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickcListener(new MenuItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(position == 2) {
                    Toast.makeText(getApplicationContext(), "Clicked " + menuList.get(position).toString(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, ActivityDetail.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void menuData(){
        MenuItem menu = new MenuItem("Carbonara",5,"Primo");
        menuList.add(menu);
        MenuItem menu2 = new MenuItem("Carne",8,"Secondo");
        menuList.add(menu2);
        MenuItem menu3 = new MenuItem("Insalata",5,"Contorno");
        menuList.add(menu3);
        MenuItem menu4 = new MenuItem("Lasagna",5,"Primo");
        menuList.add(menu4);
    }
}
