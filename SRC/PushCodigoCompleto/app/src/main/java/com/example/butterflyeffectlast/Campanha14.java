package com.example.butterflyeffectlast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class Campanha14 extends AppCompatActivity {

    private static final int TEMPO_DE_ATRASO = 5000; // Tempo em milissegundos (10 segundos)

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha14);

        // Usando um Handler para adicionar um atraso de 10 segundos
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // Criando uma Intent para iniciar a Jogo2Activity
                Intent intent = new Intent(Campanha14.this, Cutscene6.class);
                startActivity(intent);
                finish(); // Finalizando a Jogo1Activity para impedir que o usuário retorne a ela pressionando o botão "Voltar"
            }
        }, TEMPO_DE_ATRASO);
    }
}