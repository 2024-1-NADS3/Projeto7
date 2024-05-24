package com.example.butterflyeffectlast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }
    

    public void BotaoAvancar(View view){
        TextView campoForm;
        String form;
        campoForm = findViewById(R.id.Senha);
        form = campoForm.getText().toString();

        User user1 = new User(form);

        Intent mudarTela2 = new Intent(getApplicationContext(), Cutscene1.class);
        mudarTela2.putExtra("objeto", user1);
        startActivity(mudarTela2);
    }
}