package com.example.butterflyeffectlast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Registro extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextSenha;

    private static final String BASE_URL = "https://dm8x6m-3000.csb.app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextEmail = findViewById(R.id.emailRegistro);
        editTextSenha = findViewById(R.id.senhaRegistro);
    }

    public void fazerRegistro(View view) {
        String email = editTextEmail.getText().toString();
        String senha = editTextSenha.getText().toString();

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        fazerRegistroNoServidor(email, senha);
    }

    @SuppressLint("StaticFieldLeak")
    private void fazerRegistroNoServidor(final String email, final String senha) {
        final String registroUrl = BASE_URL + "/cadastrarUsuario";
        final JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("email", email);
            jsonParams.put("senha", senha);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao criar JSON para registro", Toast.LENGTH_SHORT).show();
            return;
        }

        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                try {
                    Log.d("Registro", "URL: " + registroUrl);
                    Log.d("Registro", "JSON Params: " + jsonParams.toString());

                    HttpURLConnection connection = (HttpURLConnection) new URL(registroUrl).openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setDoOutput(true);
                    connection.getOutputStream().write(jsonParams.toString().getBytes());

                    int responseCode = connection.getResponseCode();
                    Log.d("Registro", "Response Code: " + responseCode);

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        reader.close();
                        Log.d("Registro", "Response: " + response.toString());

                        // Check if the response contains a success message
                        return response.toString().trim().contains("Registro bem-sucedido");
                    } else {
                        Log.e("Registro", "Erro na solicitação: Código " + responseCode);
                        return false;
                    }
                } catch (IOException e) {
                    Log.e("Registro", "IOException", e);
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean success) {
                if (success) {
                    Toast.makeText(Registro.this, "Registro bem-sucedido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registro.this, Login.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Registro.this, "Registro bem-sucedido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registro.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.execute();
    }

}
