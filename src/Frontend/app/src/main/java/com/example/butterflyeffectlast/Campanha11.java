package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Campanha11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha11);
    }
    public void JogarChao(View view){

        Intent intent = new Intent(this, Campanha12.class);
        startActivity(intent);
    }
    public void LataLixo(View view){

        Intent intent = new Intent(this, Campanha14.class);
        startActivity(intent);
    }
}