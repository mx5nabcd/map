package com.example.ddokddok;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class myeong_eon_effort extends AppCompatActivity {

    private int currentIndex = 0; // 현재 텍스트 인덱스
    private final String[] texts = { // 미리 정의된 텍스트 배열
            "나는 아직까지 어진 것을 좋아하는 사람과 어질지 못한 것을 미워하는 사람을 보지 못하였다. 어진 것을 좋아했던 자는 더할 나위가 없었더라.",
            "당신의 노력을 존중하라. 당신 자신을 존중하라. 자존감은 자제력을 낳는다. 이 둘을 모두 겸비하면, 진정한 힘을 갖게 된다.",
            "수정을 용납하지 않는 계획은 나쁜 계획이다.",
            "나의 어느 부분도 원래부터 있었던 것이 아니다. 나는 모든 지인들의 노력의 집합체다.",
            "나는 전투를 준비하면서 계획은 무용하나 계획하는 것은 꼭 필요함을 항상 발견해왔다.",
            "무얼하든 주의 깊게 하라, 그리고 목표를 바라보라.",
            "이 모든 과제는 취임 후 100일 안에 이뤄지지는 않을 것입니다. 1,000일 안에도 이뤄지지 않을 것이며, 현 정부의 임기 중에 끝나지도 않을 것이며, 어쩌면 우리가 지구상에 살아있는 동안 이루지 못할 수도 있습니다. 하지만 시작합시다.",
            "당신이 젊은이들을 위한 진로를 준비하기보다는 그 진로를 위해 준비시키는 데 더욱 노력해주길 간청한다.",
            "인간은 오직 사고(思考)의 산물일 뿐이다. 생각하는 대로 되는 법.",
            "행복은 성취의 기쁨과 창조적 노력이 주는 쾌감 속에 있다."
    };

    private final String[] secondTexts = { // 미리 정의된 텍스트 배열
            "공자",
            "클린트 이스트우드",
            "퍼블릴리어스 사이러스",
            "척 팔라닉",
            "드와이트 데이비드 아이젠하워",
            "작자 미상",
            "존 F. 케네디",
            "벤 린지",
            "마하트마 간디",
            "프랭클린 D. 루스벨트"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myeong_eon_effort);

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
