package com.example.ddokddok;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class quiz_spelling extends AppCompatActivity {
    private int currentQuestionIndex = 0;
    private TextView text_quiz;

    // OXQuestion 클래스에 해설(explanation) 추가
    private static class OXQuestion {
        String question;
        boolean correctAnswer; // true는 O, false는 X
        String explanation;

        OXQuestion(String question, boolean correctAnswer, String explanation) {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.explanation = explanation;
        }
    }

    private OXQuestion[] questions = {
            new OXQuestion("안되", false, "'안되'는 잘못된 표기입니다. 올바른 표기는 '안 돼'입니다."),
            new OXQuestion("웬만하면", true, "'웬만하면'은 맞는 표기입니다. 주로 '웬만하면'으로 쓸 수 있습니다."),
            new OXQuestion("않되나요", false, "'않되나요'는 잘못된 표기입니다. 올바른 표기는 '안 되나요'입니다."),
            new OXQuestion("바램", false, "'바램'은 잘못된 표기입니다. 올바른 표기는 '바람'입니다."),
            new OXQuestion("잠궜다", false, "'잠궜다'는 잘못된 표기입니다. 올바른 표기는 '잠갔다'입니다.")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_spelling);

        // UI 요소 초기화
        text_quiz = findViewById(R.id.text_quiz);
        ImageButton oButton = findViewById(R.id.button_o);
        ImageButton xButton = findViewById(R.id.button_x);
        Button Button_myeong_eon =findViewById(R.id.button_myeong_eon2);
        Button Button_sangsik2 =findViewById(R.id.button_sangsik2);
        Button Button_quiz =findViewById(R.id.button_quiz2);

        Button_myeong_eon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_spelling.this, myeong_eon_categori.class);
                startActivity(intent);
            }
        });

        Button_sangsik2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_spelling.this, sang_sik_categori.class);
                startActivity(intent);
            }
        });

        Button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_spelling.this, quiz_categori.class);
                startActivity(intent);
            }
        });

        // 버튼 클릭 리스너 설정
        oButton.setOnClickListener(v -> checkAnswer(true));
        xButton.setOnClickListener(v -> checkAnswer(false));

        // 첫 문제 표시
        displayQuestion();
    }

    private void displayQuestion() {
        // 모든 문제를 다 풀었는지 확인
        if (currentQuestionIndex >= questions.length) {
            currentQuestionIndex = 0; // 처음으로 돌아가기
        }
        // 현재 문제 표시
        text_quiz.setText(questions[currentQuestionIndex].question);
    }

    private void checkAnswer(boolean selectedAnswer) {
        OXQuestion currentQuestion = questions[currentQuestionIndex];
        boolean isCorrect = (selectedAnswer == currentQuestion.correctAnswer);

        // 정답 체크 및 결과 표시
        showResultDialog(isCorrect, currentQuestion.explanation);
    }

    private void showResultDialog(boolean isCorrect, String explanation) {
        String message = isCorrect ? "정답입니다!" : "틀렸습니다!";
        String correctAnswer = questions[currentQuestionIndex].correctAnswer ? "O" : "X";

        String resultMessage = message + "\n정답: " + correctAnswer;
        if (!isCorrect) {
            resultMessage += "\n해설: " + explanation;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("결과")
                .setMessage(resultMessage)
                .setPositiveButton("다음 문제", (dialog, which) -> {
                    currentQuestionIndex++;
                    displayQuestion();
                })
                .setNegativeButton("종료", (dialog, which) -> finish())
                .setCancelable(false)
                .show();
    }
}
