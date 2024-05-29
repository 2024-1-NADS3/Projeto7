package com.example.butterflyeffectlast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class Campanha13 extends AppCompatActivity {

    private static final int TEMPO_DE_ATRASO = 5000; // Tempo em milissegundos (5 segundos)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha13);

        // Usando um Handler para adicionar um atraso de 5 segundos antes de iniciar a Jogo3Activity
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // Criando uma Intent para iniciar a Jogo3Activity
                Intent intent = new Intent(Campanha13.this, Campanha27.class);
                startActivity(intent);
                // Finalizando a Jogo2Activity para impedir que o usuário retorne a ela pressionando o botão "Voltar"
                finish();
            }
        }, TEMPO_DE_ATRASO);
    }
}