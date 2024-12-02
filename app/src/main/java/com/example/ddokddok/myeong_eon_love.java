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

public class myeong_eon_love extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "사랑은 지성에 대한 상상력의 승리다.",
            "사랑이란 한 사람과 다른 모든 사람들간 차이의 심각한 과장이다.",
            "사랑에 대한 여자의 열정은 전기 작가의 열정을 훨씬 뛰어넘는다.",
            "만유인력은 사랑에 빠진 사람을 책임지지 않는다.",
            "사랑하는 것은 천국을 살짝 엿보는 것이다.",
            "행복한 결혼 생활에서 중요한 것은 서로 얼마나 잘 맞는가보다 다른 점을 어떻게 극복해나가는가이다.",
            "사랑에 빠진 남자는 현명하고 더욱 현명해지며 사랑받는 대상을 바라볼 때마다 새롭게 보게 되고, 그의 눈과 마음은 그 사랑의 대상이 지닌 미덕을 이끌어 낸다.",
            "사랑은 거부할 수 없이 열망하게 되는 거부할 수 없는 열망이다.",
            "남편을 만나기 전, 사랑에 몇 번 발을 들여놓은 적은 있었지만 사랑에 빠진 적은 없었다.",
            "너희들이 나만큼 인생에 대해 알게 되면 강박적인 사랑의 힘을 과소평가하진 않을 게다."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "헨리 루이스 멩켄",
            "윌리엄 셰익스피어",
            "제인 오스틴",
            "알버트 아인슈타인",
            "카렌 선드",
            "레프 톨스토이",
            "랄프 왈도 에머슨",
            "로버트 프로스트",
            "리타 러드너",
            "J. R. R. 톨킨"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_love);

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
                Intent intent = new Intent(myeong_eon_love.this, myeong_eon_categori.class);
                startActivity(intent);
            }
        });

        Button_sangsik2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_love.this, sang_sik_categori.class);
                startActivity(intent);
            }
        });

        Button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_love.this, quiz_categori.class);
                startActivity(intent);
            }
        });

    }
}
