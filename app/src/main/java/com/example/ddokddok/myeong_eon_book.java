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

public class myeong_eon_book extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "좋은 책을 읽는 것은 과거 몇 세기의 가장 훌륭한 사람들과 이야기를 나누는 것과 같다.",
            "단순히 읽기 시작했다는 이유만으로 결코 책을 끝까지 읽지 말라.",
            "책이 천장에, 하늘에 닿는다. 내가 쌓은 책은 높이가 1마일은 된다. 내가 얼마나 이 책들을 사랑하는지! 내게 이 책이 얼마나 필요한지! 내가 이 책들을 읽을 때 쯤이면 나는 긴 수염을 기르고 있을 것이다.",
            "독서할 때 당신은 항상 가장 좋은 친구와 함께 있다.",
            "사람들은 인생이 모든 것이라고 말하지만 나는 독서가 좋다.",
            "책 한 권 읽기를 간절히 바라는 사람과 읽을 만한 책을 기다리다 지친 사람 사이에는 매우 큰 차이가 있다.",
            "독서가 정신에 미치는 효과는 운동이 신체에 미치는 효과와 같다.",
            "가장 발전한 문명사회에서도 책은 최고의 기쁨을 준다. 독서의 기쁨을 아는 자는 재난에 맞설 방편을 얻은 것이다.",
            "이 책을 읽는 것은 첫 신을 신고 발 떼기를 기다리는 것과 같다.",
            "내가 우울한 생각의 공격을 받을 때 내 책에 달려가는 일처럼 도움이 되는 것은 없다. 책은 나를 빨아들이고 마음의 먹구름을 지워준다."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "르네 데카르트",
            "존 위더스푼",
            "아놀드 로벨",
            "시드니 스미스",
            "로건 피어설 스미스",
            "G. K. 체스터튼",
            "리처드 스틸",
            "랄프 왈도 에머슨",
            "랠프 노박",
            "미셸 드 몽테뉴"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_book);

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
                Intent intent = new Intent(myeong_eon_book.this, myeong_eon_categori.class);
                startActivity(intent);
            }
        });

        Button_sangsik2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_book.this, sang_sik_categori.class);
                startActivity(intent);
            }
        });

        Button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myeong_eon_book.this, quiz_categori.class);
                startActivity(intent);
            }
        });

    }
}
