package com.example.butterflyeffectlast;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Campanha1 extends AppCompatActivity {

    private static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_campanha1);

        // Iniciar a música
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.nsc_lofi_and_so_it_begins);
            mediaPlayer.setLooping(true);
        }
        mediaPlayer.start();
    }

    public void BotaoRelaxar(View view) {
        Intent intent = new Intent(this, Campanha2.class);
        startActivity(intent);
    }

    public void BotaoSair(View view) {
        Intent intent = new Intent(this, Campanha3.class);
        startActivity(intent);
    }

    public static void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
