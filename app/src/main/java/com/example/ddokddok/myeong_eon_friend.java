package com.example.ddokddok;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myeong_eon_friend extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "친구의 충고는 신중하게 곱씹어 받아들여야 한다. 옳건 그르건, 자신의 생각을 포기하고 친구의 충고를 무조건 따라서는 안된다.",
            "누군가는 성공하고 누군가는 실수할 수도 있다. 하지만 이런 차이에 너무 집착하지 말라. 타인과 함께, 타인을 통해서 협력할 때에야 비로소 위대한 것이 탄생한다.",
            "우정은 실연의 상처를 치유하는 최고의 치료제다.",
            "뭉치면 서고, 갈라지면 넘어진다.",
            "만약 누군가를 당신의 편으로 만들고 싶다면, 먼저 당신이 그의 진정한 친구임을 확신시켜라.",
            "어머니는 낯선 사람이란 없으며, 아직 만나지 않은 친구가 있을 뿐이라고 말씀 하셨다. 어머니는 지금 호주에서 최고 보안시설의 치매노인요양소에 계시다.",
            "자신의 벗을 최선의 적으로 삼아야 한다. 그대의 벗과 적대할 때 그대의 마음은 벗을 더없이 가깝게 여겨야 한다.",
            "친구는 제 2의 자신이다.",
            "풍요 속에서는 친구들이 나를 알게 되고, 역경 속에서는 내가 친구를 알게 된다.",
            "아무도 꽃을 보지 않는다. 정말이다. 너무 작아서 알아보는 데 시간이 걸리기 때문이다. 우리에겐 시간이 없고, 무언가를 보려면 시간이 필요하다. 친구를 사귀는 것처럼."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "피에르 샤롱",
            "생텍쥐페리",
            "제인 오스틴",
            "이솝",
            "에이브러햄 링컨",
            "데임 에드나 에브리지",
            "프레드리히 니체",
            "아리스토텔레스",
            "존 철튼 콜린스",
            "조지아 오키프"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_friend);

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