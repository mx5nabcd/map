package com.example.ddokddok;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myeong_eon_study extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "아마도 모든 교육을 통해 얻을 수 있는 가장 귀중한 결과는, 할 일이 있을 때 좋든 싫든 스스로 그것을 하게 하는 능력이다. 그것이 맨 처음 배워야 할 교훈이다. 그것은 또한 얼마나 일찍부터 교육받았는지와 관계없이 교육받은 자가 완전히 이해하게 되는 마지막 교훈일 것이다.",
            "정직과 미덕의 샘이자 근원은 훌륭한 교육에 있다.",
            "배우나 생각하지 않으면 공허하고, 생각하나 배우지 않으면 위험하다.",
            "아이들이 무엇을 할 수 있는지 확인해보고 싶다면 주는 것을 멈추어 보면 된다.",
            "옛사람들이 '신을 위해서' 행했던 것을 요즘 사람들은 돈을 위해서 행한다.",
            "자유와 정의 다음으로 중요한 것은 대중 교육인데, 대중 교육 없이는 자유도 정의도 영원히 유지될 수 없다.",
            "나는 내 행동으로 말미암아 삶의 밑바닥까지 왔다. 이 상황을 결코 받아들일 수 없다. 그러므로 나는 내가 해온 일을 멈춰야 한다.",
            "교육은 배운 것이 잊혀졌을 때 살아 남는 것이다.",
            "행동의 가치는 그 행동을 끝까지 이루는 데 있다.",
            "군자는 말하기 전에 행동하고, 그후 자신의 행동에 맞춰 말을 한다."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "토마스 헉슬리",
            "플루타르코스",
            "공자",
            "노먼 더글러스",
            "프레드리히 니체",
            "제임스 A. 가필드",
            "앨리스 콜러",
            "B. F. 스키너",
            "칭기즈칸",
            "공자"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_study);

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
