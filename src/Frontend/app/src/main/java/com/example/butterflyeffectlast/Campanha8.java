package com.example.butterflyeffectlast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;

public class Campanha8 extends AppCompatActivity {

    private static final int TEMPO_DE_ATRASO = 5000; // Tempo em milissegundos (10 segundos)

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha8);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(Campanha8.this, GoodEND.class);
                startActivity(intent);
                finish();
            }
        }, TEMPO_DE_ATRASO);
    }
}