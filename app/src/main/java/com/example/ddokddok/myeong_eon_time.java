package com.example.ddokddok;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myeong_eon_time extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "지붕은 햇빛이 밝을 때 수리해야 합니다.",
            "시간은 만물을 스러지게 한다. 만물은 시간의 힘 아래 서서히 나이들고 시간이 흐르면서 잊혀진다.",
            "달력은 열정적인 이들이 아니라, 신중한 이들을 위한 것이다.",
            "미래에 사로잡혀있으면 현재를 있는 그대로 볼 수 없을 뿐 아니라 과거까지 재구성하려 들게 된다.",
            "순간들을 소중히 여기다 보면, 긴 세월은 저절로 흘러간다.",
            "과거를 애절하게 들여다보지 마라. 다시 오지 않는다. 현재를 현명하게 개선하라. 너의 것이니. 어렴풋한 미래를 나아가 맞으라. 두려움 없이.",
            "아름다운 여자의 마음에 들려고 노력할 때는 1시간이 마치 1초처럼 흘러간다. 그러나 뜨거운 난로 위에 앉아 있을 때는 1초가 마치 1시간처럼 느껴진다. 그것이 바로 상대성이다.",
            "다른 사람들을 평가한다면 그들을 사랑할 시간이 없다.",
            "우리가 진정으로 소유하는 것은 시간 뿐이다. 가진 것이 달리 아무 것도 없는 이에게도 시간은 있다.",
            "유행은 유행에 뒤떨어질 수 밖에 없게 만들어진다."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "존 F. 케네디",
            "아리스토텔레스",
            "척 사이거스",
            "에릭 호퍼",
            "마리아 에지워스",
            "헨리 워즈워스 롱펠로우",
            "알버트 아인슈타인",
            "마더 테레사",
            "발타사르 그라시안",
            "가브리엘(코코)샤넬"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_time);

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
