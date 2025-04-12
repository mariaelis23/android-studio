package com.example.aulaantesdaprova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //importante colocar no código:
    private RadioGroup pergunta1;

    private RadioGroup pergunta2;

    private Button botaoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //criar mét0do:
        inicializaTela();

    }

    private void inicializaTela() {             //tem que colocar as coisas que serão manipuladas
        pergunta1 = findViewById(R.id.activityMain_pergunta1);
        pergunta2 = findViewById(R.id.activityMain_pergunta2);

        botaoEnviar = findViewById(R.id.activityMain_buttonEnviar);
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarProva();
            }
        });

    }

    private void enviarProva() {
        //mét0do pra fazer tudo de uma vez só:
        String resposta1 = verificaResposta(pergunta1);
        String resposta2 = verificaResposta(pergunta2);

        //mét0do para chamar a segunda tela          this_> tela de origem  class-> tela de destino
        //Intent telaResultado = new Intent(this, telaResultado.class);
        Intent telaResultado = new Intent(this, com.example.aulaantesdaprova.telaResultado.class);
        telaResultado.putExtra("chaveResposta1", resposta1);
        telaResultado.putExtra("chaveResposta2", resposta2);

        startActivity(telaResultado);
    }

    private String verificaResposta(RadioGroup pergunta) {


        int idOpcaoSelecionada = pergunta.getCheckedRadioButtonId();
        RadioButton radioButtonSelecionado = findViewById(idOpcaoSelecionada);
        String resposta = radioButtonSelecionado.getText().toString();
        return resposta;
    }


}


//importante remover o ViewCompat antes de começar
//arrumar as constraint pro texto não mudar a posição e trocar ID da classe pai, o "RadioGRoup"
//os mét0dos são independentes, e ficam dentro de classes, tem adicionar constraints nas coisas que usar na tela

