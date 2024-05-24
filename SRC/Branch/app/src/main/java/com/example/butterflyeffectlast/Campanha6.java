package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Campanha6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha6);
    }
    public void IrParque(View view){

        Intent intent = new Intent(this, Cutscene7.class);
        startActivity(intent);
    }
    public void IrMercado(View view){

        Intent intent = new Intent(this, Cutscene3.class);
        startActivity(intent);
    }
}