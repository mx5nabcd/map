package com.example.ddokddok;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class sang_sik_economy extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "한정된 물량만 판매해 소비자의 구매 욕구를 더욱 자극시키는 마케팅 기법을 헝거 마케팅이라고 한다.",
            "경제지표를 평가하는 과정에서 기준 시점과 비교시점의 상대적인 수치에 따라 그 결과에 큰 차이가 나타나는 현상은 기저효과이다.",
            "물가 불안이나 경기 침체에 대응하기 위한 정부의 시장개입이 과도하거나 변덕스러울 경우 발생하는 역효과를 경고하는 말을 샤워실의 바보라고 한다.",
            "대중에게 잘 알려지지 않았으나 세계시장을 지배하며 경쟁력 있는 우량기업(중소기업)을 히든 챔피언이라고 한다.",
            "기업이나 정부기관 내의 불법적인 행위나 부정행위를 봐주지 않고 지적하는 밀고자, 내부고발자를 휘슬블로어라고 한다."
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sang_sik_economy);

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