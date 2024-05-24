package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Campanha12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha12);
    }
    public void SeguirCheiro(View view){

        Intent intent = new Intent(this, Campanha24.class);
        startActivity(intent);
    }
    public void IrCasa(View view){

        Intent intent = new Intent(this, Cutscene5.class);
        startActivity(intent);
    }
}