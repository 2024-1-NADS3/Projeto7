package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Campanha1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_campanha1);
    }
    public void BotaoRelaxar(View view){

        Intent intent = new Intent(this, Campanha2.class);
        startActivity(intent);
    }
    public void BotaoSair(View view){

        Intent intent = new Intent(this, Campanha3.class);
        startActivity(intent);
    }
}