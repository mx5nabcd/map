package com.example.ddokddok;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class sang_sik_sajasunger extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "가가대소: 너무 우스워서 껄껄 크게 웃음",
            "가급인족: 집집마다 살림이 넉넉하고, 사람마다 의식에 부족함이 없음",
            "가기이방: 그럴듯한 말로 속일 수 있음",
            "가농성진: 처음에 장난삼아 한 일이 나중에 정말이 됨",
            "가담항설: 길거리에 떠도는 소문"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sang_sik_sajasunger);

        TextView textView = findViewById(R.id.text_sang_sik); // TextView 참조
        ImageButton button = findViewById(R.id.button_next); // Button 참조
        ImageButton button1 = findViewById(R.id.button_previous);

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
