package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Campanha3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha3);
    }
    public void BotaoIrParque(View view){

        Intent intent = new Intent(this, Cutscene7.class);
        startActivity(intent);
    }
    public void BotaoIrMercado(View view){

        Intent intent = new Intent(this, Cutscene3.class);
        startActivity(intent);
    }
}