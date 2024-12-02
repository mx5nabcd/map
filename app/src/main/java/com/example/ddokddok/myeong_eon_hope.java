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

public class myeong_eon_hope extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "웃음 없는 하루는 낭비한 하루다.",
            "희망은 날개 달린 것, 영혼에 내려앉아 가사 없는 노래 부르네. 그치지 않는 그 노래.",
            "진정으로 웃으려면 고통을 참아야 하며, 나아가 고통을 즐길 줄 알아야 해!",
            "아마도 인간이 가장 원하는 일들이 가장 할만한 가치가 있는 일들일 것이다.",
            "꿈은 이루어진다. 이루어질 가능성이 없었다면 애초에 자연이 우리를 꿈꾸게 하지도 않았을 것이다.",
            "우리가 무슨 생각을 하느냐가 우리가 어떤 사람이 되는지를 결정한다.",
            "두려움은 희망 없이 있을 수 없고 희망은 두려움 없이 있을 수 없다.",
            "위대한 성취를 하려면 행동하는 것뿐만 아니라, 꿈꾸는 것도 반드시 필요하다.",
            "사람이 유머감각이 있는 게 아니다. 유머 감각이 사람을 움직이는 것이다.",
            "삶의 목적은 자기계발이다. 자신의 본성을 완벽하게 실현하는 것, 바로 그 목적을 위해 우리 모두가 지금 여기 존재한다."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "찰리 채플린",
            "에밀리 디킨스",
            "찰리 채플린",
            "위니프레드 홀트비",
            "존 업다이크",
            "오프라 윈프리",
            "바뤼흐 스피노자",
            "아나톨 프랑스",
            "래리 겔바트",
            "오스카 와일드"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_hope);

        TextView textView = findViewById(R.id.text_myeong_eon); // TextView 참조
        TextView textView1 = findViewById(R.id.text_author); // TextView 참조
        ImageButton button = findViewById(R.id.button_next); // Button 참조
        ImageButton button1 = findViewById(R.id.button_previous);
        Button Button_myeong_eon =findViewById(R.id.button_myeong_eon2);
        Button Button_sangsik2 =findViewById(R.id.button_sangsik2);
        Button Button_quiz =findViewById(R.id.button_quiz2);

        button.setOnClickListener(v -> {
            // 다음 인덱스로 이동 (배열의 끝이면 0으로 순환)
            currentIndex = (currentIndex + 1) % texts.length;

            // 현재 텍스트를 TextView에 설정
            textView.setText(texts[currentIndex]);
            textView1.setText(secondTexts[currentIndex]);

        });

        button1.setOnClickListener(v -> {
            // 다음 인덱스로 이동 (배열의 끝이면 0으로 순환)
            currentIndex = (currentIndex - 1 + texts.length) % texts.length;

            // 현재 텍스트를 TextView에 설정
            textView.setText(texts[currentIndex]);
            textView1.setText(secondTexts[currentIndex]);
        });

        Button_myeong_eon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_hope.this, myeong_eon_categori.class);
                startActivity(intent);
            }
        });

        Button_sangsik2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_hope.this, sang_sik_categori.class);
                startActivity(intent);
            }
        });

        Button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_hope.this, quiz_categori.class);
                startActivity(intent);
            }
        });

    }
}
