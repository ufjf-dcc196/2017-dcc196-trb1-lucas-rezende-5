package com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.R;

public class DetalhesLivro extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtEditora;
    private TextView txtAno;
    private String[] detalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_livro);

       // txtNome = (TextView)findViewById(R.id.txtLivroTitulo);
       // txtEditora = (TextView)findViewById(R.id.txtLivroEditora);
       // txtAno = (TextView)findViewById(R.id.txtAnoLivro);


        //detalhes = getIntent().getStringExtra("livro").split(";");
        //(0)titulo (1)editora (2)Ano
        //txtNome.setText(detalhes[0]);
        //txtEditora.setText(detalhes[1]);
        //txtAno.setText(detalhes[2]);


    }
}
