package com.toybox.lucasrezende.dcc196_controle_feira_do_livro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.LivrosHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Helper.ParticipantesHelper;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.DetalhesLivro;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.DetalhesParticipante;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Livro;
import com.toybox.lucasrezende.dcc196_controle_feira_do_livro.Models.Participante;

public class Emprestimos extends AppCompatActivity {

    private ListView lstParticipantes;
    private ListView lstLivros;
    private Button   txtConfirmar;
    private TextView txtLocatario;
    private TextView txtLivro;
    private Participante temp;
    private ArrayAdapter<Participante> participanteAdapter = null;
    private ArrayAdapter<Livro> livroAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimos);


            lstLivros = (ListView) findViewById(R.id.lstExemplares);
            lstParticipantes = (ListView) findViewById(R.id.lstParticipantes);
            txtLocatario = (TextView)findViewById(R.id.txtLocatario);
            txtLivro = (TextView)findViewById(R.id.txtLivroEscolhido);

            participanteAdapter = new ArrayAdapter<Participante>(this, android.R.layout.simple_list_item_1, ParticipantesHelper.getInstance().getList());
            livroAdapter = new ArrayAdapter<Livro>(this, android.R.layout.simple_list_item_1, LivrosHelper.getInstance().getList());

            lstParticipantes.setAdapter(participanteAdapter);
            lstLivros.setAdapter(livroAdapter);

        lstParticipantes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Participante escolha = participanteAdapter.getItem(i);
                 temp = escolha;
                 txtLocatario.setText(escolha.toString());
                return true;
            }
        });

        lstLivros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Livro escolha = livroAdapter.getItem(i);
                txtLivro.setText(escolha.toString());
                escolha.setReservas(temp);
                return true;
            }
        });

        lstLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Livro escolha = livroAdapter.getItem(i);
                Intent intent = new Intent(Emprestimos.this, DetalhesLivro.class);
                intent.putExtra("livro", escolha.recuperaDetalhes());
                startActivity(intent);
            }
        });

    }

}

