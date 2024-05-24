package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Campanha5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_campanha5);}
    public void BotaoIrParque2(View view){

        Intent intent = new Intent(this, Cutscene7.class);
        startActivity(intent);
    }
    public void SalaVerTeve(View view){

        Intent intent = new Intent(this, Campanha21.class);
        startActivity(intent);
    }
}