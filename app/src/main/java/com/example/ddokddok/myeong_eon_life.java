package com.example.ddokddok;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myeong_eon_life extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "노인이 젊은이에게 얘기하듯이 망자도 산자에게 이야기하려고 노력한다면 좋을텐데.",
            "여행을 할 때는 여행하고 있는 국가가 너에게 편의를 제공하기 위해 설계된 것이 아니라는 점을 기억하라. 그 나라는 자국민들이 편안하게 살도록 설계되었다.",
            "나는 죽음 후에 계속될 미성숙이 기대된다.",
            "결코 눈덩이를 던져보고 싶은 충동이 생기지 않으면, 당신은 노화의 손아귀에 꽉 붙잡힌 것이다.",
            "인생은 본래 녹록지 않다. 하지만 멍청한 사람에게는 더욱 녹록지 않다.",
            "늘 행복하고 지혜로운 사람이 되려면 자주 변해야 한다.",
            "인생이란 진지하게 이야기하기에는 너무나 중요한 것이다.",
            "어진 사람을 보면 그와 같이 되기를 생각하고, 어질지 않은 사람을 보면 속으로 스스로 반성하라.",
            "인생은 다만 한 통의 쓰레기일 뿐이다.",
            "태어나면서부터 현명한 이는 없다."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "윌라 카서",
            "클리프턴 패디먼",
            "데이브 배리",
            "더그 라슨",
            "존 웨인",
            "공자",
            "오스카 와일드",
            "공자",
            "로드니 데인저필드",
            "미겔 데 세르반테스"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_life);

        TextView textView = findViewById(R.id.text_myeong_eon); // TextView 참조
        TextView textView1 = findViewById(R.id.text_author); // TextView 참조
        ImageButton button = findViewById(R.id.button_next); // Button 참조
        ImageButton button1 = findViewById(R.id.button_previous);

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

    }
}
