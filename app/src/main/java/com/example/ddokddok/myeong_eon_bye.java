package com.example.ddokddok;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myeong_eon_bye extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "작별 인사에 낙담하지 말라. 재회에 앞서 작별은 필요하다. 그리고 친구라면 잠시 혹은 오랜 뒤라도 꼭 재회하게 될 터이니.",
            "수마일의 거리가 당신과 친구를 떼어놓을 수도 있다… 하지만 사랑하는 누군가와 정말 함께 있고 싶다면, 이미 거기 가있지 않겠는가?",
            "이별의 아픔 속에서만 사랑의 깊이를 알게 된다.",
            "멀리있는 친구만큼 세상을 넓어 보이게 하는 것은 없다. 그들은 위도와 경도가 된다.",
            "당신을 만나는 모든 사람이 당신과 헤어질 때는 더 나아지고 더 행복해질 수 있도록 하라.",
            "인간의 감정은 누군가를 만날 때와 헤어질 때 가장 순수하며 가장 빛난다.",
            "떠날 때가 되었으니, 이제 각자의 길을 가자. 나는 죽기 위해서, 당신들은 살기 위해. 어느 편이 더 좋은 지는 오직 신만이 알 뿐이다.",
            "이 사랑의 꽃봉오리는 여름날 바람에 마냥 부풀었다가, 다음 만날 때엔 예쁘게 꽃필 거예요."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "리처드 바크",
            "리처드 바크",
            "조지 앨리엇",
            "헨리 데이비드 소로우",
            "마더 테레사",
            "장 폴 리히터",
            "소크라테스",
            "윌리엄 셰익스피어"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_bye);

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
