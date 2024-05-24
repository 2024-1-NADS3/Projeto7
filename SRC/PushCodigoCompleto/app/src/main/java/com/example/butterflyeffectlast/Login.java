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

public class Login extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextSenha;

    private static final String BASE_URL = "https://dm8x6m-3000.csb.app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.email);
        editTextSenha = findViewById(R.id.senha);
    }

    public void Cadastrar(View view) {
        Intent intent = new Intent(Login.this, Registro.class);
        startActivity(intent);
    }

    public void EsqueceuASenha(View view) {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

    public void fazerLogin(View view) {
        String email = editTextEmail.getText().toString();
        String senha = editTextSenha.getText().toString();

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }
        fazerLoginNoServidor(email, senha);
    }

    @SuppressLint("StaticFieldLeak")
    private void fazerLoginNoServidor(final String email, final String senha) {
        final String loginUrl = BASE_URL + "/login";
        final JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("email", email);
            jsonParams.put("senha", senha);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao criar JSON para login", Toast.LENGTH_SHORT).show();
            return;
        }

        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(loginUrl).openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setDoOutput(true);
                    connection.getOutputStream().write(jsonParams.toString().getBytes());

                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        reader.close();
                        Log.d("Login", "Response: " + response.toString());

                        if (response.toString().trim().equals("Login bem-sucedido")) {
                            salvarCredenciaisUsuario(email, senha);
                            String nomeUsuario = obterNomeUsuario(email);
                            String pontosUsuario = obterPontuacaoUsuario(email);
                            salvarNomeUsuario(nomeUsuario);
                            salvarPontuacaoUsuario(pontosUsuario);
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        Log.e("Login", "Erro na solicitação: Código " + responseCode);
                        return false;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean success) {
                if (success) {
                    Toast.makeText(Login.this, "Login bem-sucedido", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Campanha1.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }

    private String obterNomeUsuario(String email) {
        final String nomeUsuarioUrl = BASE_URL + "/obterNomeUsuario";
        final JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("email", email);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(nomeUsuarioUrl).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.getOutputStream().write(jsonParams.toString().getBytes());

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            } else {
                Log.e("Login", "Erro na solicitação: Código " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String obterPontuacaoUsuario(String email) {
        final String pontuacaoUsuarioUrl = BASE_URL + "/obterPontuacaoUsuario";
        final JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("email", email);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(pontuacaoUsuarioUrl).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.getOutputStream().write(jsonParams.toString().getBytes());

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            } else {
                Log.e("Login", "Erro na solicitação: Código " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean salvarPontuacaoUsuario(String pontuacao) {
        SharedPreferences preferences = getSharedPreferences("suasPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("pontuacaoUsuario", pontuacao);
        boolean success = editor.commit();
        if (success) {
            Log.d("PontuacaoUsuario", "Pontuação do usuário salva com sucesso: " + pontuacao);
        } else {
            Log.e("PontuacaoUsuario", "Erro ao salvar a pontuação do usuário");
        }
        return success;
    }

    private void salvarNomeUsuario(String nome) {
        SharedPreferences preferences = getSharedPreferences("suasPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nomeUsuario", nome);
        editor.apply();
    }

    private void salvarCredenciaisUsuario(String email, String senha) {
        SharedPreferences preferences = getSharedPreferences("CredenciaisUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", email);
        editor.putString("senha", senha);
        editor.apply();
    }
}
