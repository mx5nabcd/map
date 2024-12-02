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

public class myeong_eon_challenge extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "내 마음에 동요가 일고 마음 속에서 원해, 정말 원해, 정말 정말 원해!라고 외쳤다. 그 소리는 매일 오후면 들렸고 떨쳐버리려 노력할수록 커졌다.",
            "자신은 위험을 무릅쓰고 하지 않을 행동을 충동질 하는 이를 조심하라.",
            "다른 사람들이 할 수 있거나 할 일을 하지 말고, 다른 이들이 할 수 없고 하지 않을 일들을 하라.",
            "인생이 끝날까 두려워하지마라. 당신의 인생이 시작조차 하지 않을 수 있음을 두려워하라.",
            "시작이 반이다.",
            "조금도 위험을 감수하지 않는 것이 인생에서 가장 위험한 일일 것이라 믿는다.",
            "나를 믿어라. 인생에서 최대의 성과와 기쁨을 수확하는 비결은 위험한 삶을 사는 데 있다.",
            "모든 것이 흑백이 아니라면, '대체 왜 아닌가?'라고 나는 묻는다.",
            "아무런 위험없이 승리하는 것은 영광없는 승리에 다름 아니다.",
            "절망은 마약이다. 절망은 생각을 무관심으로 잠재울 뿐이다."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "솔 벨로",
            "호아킨 세탄티",
            "아멜리아 에어하트",
            "그레이스 한센",
            "아리스토텔레스",
            "오프라 윈프리",
            "프레드리히 니체",
            "존 웨인",
            "피에르 코르네유",
            "찰리 채플린"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_challenge);

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
                Intent intent = new Intent(myeong_eon_challenge.this, myeong_eon_categori.class);
                startActivity(intent);
            }
        });

        Button_sangsik2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_challenge.this, sang_sik_categori.class);
                startActivity(intent);
            }
        });

        Button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_challenge.this, quiz_categori.class);
                startActivity(intent);
            }
        });


    }
}
