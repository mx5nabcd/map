package com.example.ddokddok;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myeong_eon_success extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "우리의 목표는 이것이다. 우리에게 주어진 이 삶을 최대한 의미있게 사는 것, 자부심을 느낄 수 있도록 올바르게 사는 것, 죽은 후에도 우리의 일부가 영속도록 올바르게 행동하는 것.",
            "인류는 세상을 다른 시각으로 보는 사람들에게 냉담할 수 있다.",
            "성공은 중요한 생일이 다가왔는데 당신은 전과 똑같다는 사실을 발견하는 것이다.",
            "사람들이 대게 기회를 놓치는 이유는 기회가 작업복 차림의 일꾼 같아 일로 보이기 때문이다.",
            "성공이란 열정을 잃지 않고 실패를 거듭할 수 있는 능력이다.",
            "나는 성공의 열쇠는 모른다. 그러나 실패의 열쇠는 모두의 비위를 맞추려 하는 것이다.",
            "순간을 사랑하라. 그러면 그 순간의 에너지가 모든 경계를 넘어 퍼져나갈 것이다.",
            "인생에 있는 큰 비밀은 큰 비밀 따위는 없다는 것이다. 당신의 목표가 무엇이든 열심히 할 의지가 있다면 달성할 수 있다.",
            "인간은 운명의 포로가 아니라 단지 자기 마음의 포로일 뿐이다.",
            "팀에는 내가 없지만 팀의 승리에는 내가 있다 (Team이란 단어에는 I 자가 없지만 win이란 단어에는 있다.)"
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "오스왈드 스펭글러",
            "에릭 A. 번스",
            "오드리 햅번",
            "토마스 A. 에디슨",
            "윈스턴 처칠",
            "빌 코스비",
            "코리타 켄트",
            "오프라 윈프리",
            "프랭클린 D. 루스벨트",
            "마이클 조던"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_success);

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
