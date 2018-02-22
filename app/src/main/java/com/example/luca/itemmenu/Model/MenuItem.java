package com.example.luca.itemmenu.Model;

/**
 * Created by Luca on 21/02/2018.
 */

public class MenuItem {
    private String nomePiatto;
    private int costo;
    private String categoria;

    public MenuItem(String nomePiatto, int  costo, String categoria) {
        this.nomePiatto = nomePiatto;
        this.costo = costo;
        this.categoria = categoria;
    }

    public String getNomePiatto() {
        return nomePiatto;
    }

    public void setNomePiatto(String nomePiatto) {
        this.nomePiatto = nomePiatto;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
