package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Campanha4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_campanha4);}
    public void BotaoEmbalagensLixo(View view){

        Intent intent = new Intent(this, Campanha6.class);
        startActivity(intent);
    }
    public void BotaoGuloseimas(View view){

        Intent intent = new Intent(this, Campanha7.class);
        startActivity(intent);
    }
}