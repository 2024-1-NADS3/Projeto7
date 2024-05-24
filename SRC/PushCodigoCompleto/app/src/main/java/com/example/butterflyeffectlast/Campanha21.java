package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Campanha21 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha21);
    }
    public void IrZec(View view){

        Intent intent = new Intent(this, Campanha23.class);
        startActivity(intent);
    }
}