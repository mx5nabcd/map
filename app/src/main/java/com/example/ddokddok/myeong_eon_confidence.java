package com.example.ddokddok;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myeong_eon_confidence extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "군자는 작은 일에서는 진가를 알 수 없으나 큰 일은 맡을 수 있고, 소인은 큰 일은 맡을 수 없으나 작은 일은 잘 할 수도 있다.",
            "모욕 당하는 방법은 그것에 굴복하는 것이다. 사람은 요구하는 만큼만 존중을 받게 된다.",
            "내가 있는 곳이 낙원이라.",
            "내가 보기에 사람들은 엄청난 잠재력을 가지고 있다. 많은 이들이 자신감을 갖거나 위험을 무릅쓴다면 위대한 일을 해낼 수 있다. 하지만 대부분 그러지 못한다. 사람들은 티비 앞에 앉아 삶은 영원할 것이라 생각한다.",
            "사람을 알기위해서는 어떻게 목표 달성에 실패하는가 보다는, 어떻게 목표 달성에 성공하는가를 살피라. 왜냐하면 실패할 때에는 자존심이 우리를 지탱해 주지만 성공할 때에는 자존심이 우리를 배반하기 때문이다.",
            "청년기의 자존심은 혈기와 아름다움에 있지만, 노년기의 자존심은 분별력에 있다.",
            "네가 자신감 있고 안정되고 네가 하는 일을 훌륭히 처리한다는 것을 알 수는 있다. 하지만 네가 그것에 대해 자만한다는 것은 모른다.",
            "약간의 광기도 없는 위대한 천재란 있을 수 없다.",
            "자신의 부족한 점을 더 많이 부끄러워할 줄 아는 이는 더 존경받을 가치가 있는 사람이다.",
            "능력이 부족할 수록 자만심이 더 강하다."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "공자",
            "윌리엄 해즐릿",
            "볼테르",
            "필립 애덤스",
            "찰스 칼렙 콜튼",
            "데모크리토스",
            "루벤 스터다드",
            "아리스토텔레스",
            "조지 버나드 쇼",
            "아하드 하암"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_confidence);

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
