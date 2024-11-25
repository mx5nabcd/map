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

public class quiz_categori extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_categori);

        Button Button_eng =findViewById(R.id.button_categori_english);
        Button Button_economy =findViewById(R.id.button_categori_economy);
        Button Button_geography =findViewById(R.id.button_categori_geography);
        Button Button_spelling =findViewById(R.id.button_categori_spelling);
        Button Button_sajasunger =findViewById(R.id.button_categori_sajasunger);
        Button Button_sport =findViewById(R.id.button_categori_sport);
        Button Button_history =findViewById(R.id.button_categori_history);
        Button Button_science =findViewById(R.id.button_categori_science);
        Button Button_meong_eon =findViewById(R.id.button_categori_myeong_eon);


        Button_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_categori.this, quiz_english.class);
                startActivity(intent);
            }
        });

        Button_economy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_categori.this, quiz_economy.class);
                startActivity(intent);
            }
        });

        Button_geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_categori.this, quiz_geography.class);
                startActivity(intent);
            }
        });

        Button_spelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_categori.this, quiz_spelling.class);
                startActivity(intent);
            }
        });

        Button_sajasunger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_categori.this, quiz_sajasunger.class);
                startActivity(intent);
            }
        });

        Button_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_categori.this, quiz_sport.class);
                startActivity(intent);
            }
        });

        Button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_categori.this, quiz_history.class);
                startActivity(intent);
            }
        });

        Button_science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_categori.this, quiz_science.class);
                startActivity(intent);
            }
        });

        Button_meong_eon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_categori.this, quiz_myeong_eon.class);
                startActivity(intent);
            }
        });

    }
}
