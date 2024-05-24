package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Campanha24 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_campanha24);
    }
    public void Mercado(View view){

        Intent intent = new Intent(this, Campanha10.class);
        startActivity(intent);
    }
    public void IrZec2(View view){

        Intent intent = new Intent(this, Campanha25.class);
        startActivity(intent);
    }
}