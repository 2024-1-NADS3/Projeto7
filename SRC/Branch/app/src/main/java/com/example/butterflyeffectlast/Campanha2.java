package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Campanha2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_campanha2);
    }
    public void BotaoComerfrutas(View view){

        Intent intent = new Intent(this, Cutscene4.class);
        startActivity(intent);
    }
    public void BotaoComerSalgadinhos(View view){

        Intent intent = new Intent(this, Campanha4.class);
        startActivity(intent);
    }
}