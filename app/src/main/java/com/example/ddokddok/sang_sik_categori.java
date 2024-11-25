package com.example.ddokddok;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class sang_sik_categori extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sang_sik_categori);

        Button Button_english =findViewById(R.id.button_categori_english);
        Button Button_sajasunger =findViewById(R.id.button_categori_sajasunger);
        Button Button_history =findViewById(R.id.button_categori_history);
        Button Button_spelling =findViewById(R.id.button_categori_spelling);
        Button Button_economy =findViewById(R.id.button_categori_economy);
        Button Button_science =findViewById(R.id.button_categori_science);
        Button Button_geography =findViewById(R.id.button_categori_geography);
        Button Button_sport =findViewById(R.id.button_categori_sport);

        Button_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_categori.this, sang_sik_english.class);
                startActivity(intent);
            }
        });

        Button_sajasunger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_categori.this, sang_sik_sajasunger.class);
                startActivity(intent);
            }
        });

        Button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_categori.this, sang_sik_history.class);
                startActivity(intent);
            }
        });

        Button_spelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_categori.this, sang_sik_spelling.class);
                startActivity(intent);
            }
        });

        Button_economy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_categori.this, sang_sik_economy.class);
                startActivity(intent);
            }
        });

        Button_science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_categori.this, sang_sik_science.class);
                startActivity(intent);
            }
        });

        Button_geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_categori.this, sang_sik_geography.class);
                startActivity(intent);
            }
        });

        Button_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_categori.this, sang_sik_sport.class);
                startActivity(intent);
            }
        });

    }
}
