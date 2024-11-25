package com.example.ddokddok;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class quiz_english extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_english);

        ImageButton Button_o = findViewById(R.id.button_o);
        ImageButton Button_x = findViewById(R.id.button_x);

        Button_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                True_log();
            }
        });

        Button_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                False_log();
            }
        });
    }

    private void True_log() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("") // 팝업창 제목
                .setMessage("정답입니다.") // 팝업창 내용
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 확인 버튼 클릭 시 실행할 동작
//                        Toast.makeText(quiz_english.this,
//                                "확인 버튼이 클릭되었습니다.",
//                                Toast.LENGTH_SHORT).show();
                    }
                });


        // 팝업창 생성 및 표시
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void False_log() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("") // 팝업창 제목
                .setMessage("오답입니다.") // 팝업창 내용
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 확인 버튼 클릭 시 실행할 동작
//                        Toast.makeText(quiz_english.this,
//                                "확인 버튼이 클릭되었습니다.",
//                                Toast.LENGTH_SHORT).show();
                    }
                });


        // 팝업창 생성 및 표시
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
