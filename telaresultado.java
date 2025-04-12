package com.example.aulaantesdaprova;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class telaResultado extends AppCompatActivity {

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_resultado);

        //mét0do:
        inicializaTelaResultado();

    }

    private void inicializaTelaResultado() {
        resultado = findViewById(R.id.telaResultado_textViewResultado);
        int notaFinal = calculaNota();
        if (notaFinal == 10){
            resultado.setText("Parabéns você tirou nota 10");
        }else if (notaFinal == 5){
            resultado.setText("Você tirou nota 5");
        }else resultado.setText("Nota ZERO!");
    }


//mét0odo pra dar a nota do aluno:
    private int calculaNota() {
        String resposta1 = getIntent().getStringExtra("chaveResposta1");
        String resposta2 = getIntent().getStringExtra("chaveResposta2");
        if(resposta1.equals("Paris") && resposta2.equals("Jupiter"))
            return 10;
        else if (resposta1.equals("Paris") || resposta2.equals("Jupiter"))
            return 5;

        return 0;
    }
}
