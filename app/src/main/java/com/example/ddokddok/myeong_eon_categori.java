package com.example.ddokddok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myeong_eon_categori extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_categori);

        Button Button_love =findViewById(R.id.button_categori_love);
        Button Button_friend =findViewById(R.id.button_categori_friend);
        Button Button_life =findViewById(R.id.button_categori_life);
        Button Button_study =findViewById(R.id.button_categori_study);
        Button Button_book =findViewById(R.id.button_categori_book);
        Button Button_success =findViewById(R.id.button_categori_success);
        Button Button_time =findViewById(R.id.button_categori_time);
        Button Button_bye =findViewById(R.id.button_categori_bye);
        Button Button_hope =findViewById(R.id.button_categori_hope);
        Button Button_effort =findViewById(R.id.button_categori_effort);
        Button Button_confidence =findViewById(R.id.button_categori_confidence);
        Button Button_challenge =findViewById(R.id.button_categori_challenge);


        Button_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_love.class);
                startActivity(intent);
            }
        });

        Button_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_friend.class);
                startActivity(intent);
            }
        });

        Button_life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_life.class);
                startActivity(intent);
            }
        });

        Button_study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_study.class);
                startActivity(intent);
            }
        });

        Button_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_book.class);
                startActivity(intent);
            }
        });

        Button_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_success.class);
                startActivity(intent);
            }
        });

        Button_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_time.class);
                startActivity(intent);
            }
        });

        Button_bye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_bye.class);
                startActivity(intent);
            }
        });

        Button_hope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_hope.class);
                startActivity(intent);
            }
        });

        Button_effort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_effort.class);
                startActivity(intent);
            }
        });

        Button_confidence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_confidence.class);
                startActivity(intent);
            }
        });

        Button_challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_categori.this, myeong_eon_challenge.class);
                startActivity(intent);
            }
        });
    }
}