package com.example.projetws;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVersAjout = findViewById(R.id.btn_vers_ajout);
        Button btnVersListe = findViewById(R.id.btn_vers_liste);

        btnVersAjout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEtudiant.class);
            startActivity(intent);
        });

        btnVersListe.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListEtudiantActivity.class);
            startActivity(intent);
        });
    }
}