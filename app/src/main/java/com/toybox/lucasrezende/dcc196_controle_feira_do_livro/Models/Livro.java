package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models;

import java.util.List;

/**
 * Created by LucasRezende on 25/10/2017.
 */

public class Livro {

    private String titulo;
    private String editora;
    private int ano;
    private List<Participante> reservas;

    public Livro(String titulo, String editora, int ano) {
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
    }

    public List<Participante> getReservas() {
        return reservas;
    }

    public void setReservas(Participante participante) {
        this.reservas.add(participante);
    }

    public String recuperaDetalhes(){
        String temp = "" + titulo + ";" + editora + ";" + ano + ";";
        for(Participante ls: reservas) {
            temp = temp + ", participante=" + ls;
        }
        return  temp;
    }

    @Override
    public String toString() {
        String temp = "Livro{" + "titulo='" + titulo + '\'' + ", editora='" + editora + '\'' + ", ano=" + ano + ", reservas=";
                for(Participante ls: reservas) {
                    temp = temp + ", participante=" + ls;
                }
        return temp;
    }
}
