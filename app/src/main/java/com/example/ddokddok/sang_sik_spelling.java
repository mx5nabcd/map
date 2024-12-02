package com.example.ddokddok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class sang_sik_spelling extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "안되x 안돼o",
            "왠만하면x 웬만하면o",
            "않되나요x 안 되나요o",
            "바램x 바람o",
            "잠궜다x 잠갔다o"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sang_sik_spelling);

        TextView textView = findViewById(R.id.text_sang_sik); // TextView 참조
        ImageButton button = findViewById(R.id.button_next); // Button 참조
        ImageButton button1 = findViewById(R.id.button_previous);
        Button Button_myeong_eon =findViewById(R.id.button_myeong_eon2);
        Button Button_sangsik2 =findViewById(R.id.button_sangsik2);
        Button Button_quiz =findViewById(R.id.button_quiz2);

        Button_myeong_eon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_spelling.this, myeong_eon_categori.class);
                startActivity(intent);
            }
        });

        Button_sangsik2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_spelling.this, sang_sik_categori.class);
                startActivity(intent);
            }
        });

        Button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sang_sik_spelling.this, quiz_categori.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(v -> {
            // 다음 인덱스로 이동 (배열의 끝이면 0으로 순환)
            currentIndex = (currentIndex + 1) % texts.length;

            // 현재 텍스트를 TextView에 설정
            textView.setText(texts[currentIndex]);

        });

        button1.setOnClickListener(v -> {
            // 다음 인덱스로 이동 (배열의 끝이면 0으로 순환)
            currentIndex = (currentIndex - 1 + texts.length) % texts.length;

            // 현재 텍스트를 TextView에 설정
            textView.setText(texts[currentIndex]);
        });

    }
}