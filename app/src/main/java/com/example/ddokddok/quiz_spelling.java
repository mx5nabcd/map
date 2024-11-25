package com.example.ddokddok;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class quiz_spelling extends AppCompatActivity {
    private int currentQuestionIndex = 0;
    private TextView text_quiz;
    private static class OXQuestion {
        String question;
        boolean correctAnswer; // true는 O, false는 X

        OXQuestion(String question, boolean correctAnswer) {
            this.question = question;
            this.correctAnswer = correctAnswer;
        }
    }

    private OXQuestion[] questions = {
            new OXQuestion("대한민국의 수도는 서울이다.", true),
            new OXQuestion("지구는 평평하다.", false),
            new OXQuestion("물의 끓는점은 100도이다.", true),
            new OXQuestion("오징어는 척추동물이다.", false),
            new OXQuestion("태양은 지구의 위성이다.", false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_spelling);

        // UI 요소 초기화
        text_quiz = findViewById(R.id.text_quiz);
        ImageButton oButton = findViewById(R.id.button_o);
        ImageButton xButton = findViewById(R.id.button_x);

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
        showResultDialog(isCorrect);
    }

    private void showResultDialog(boolean isCorrect) {
        String message = isCorrect ? "정답입니다!" : "틀렸습니다!";
        String correctAnswer = questions[currentQuestionIndex].correctAnswer ? "O" : "X";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("결과")
                .setMessage(message + "\n정답: " + correctAnswer)
                .setPositiveButton("다음 문제", (dialog, which) -> {
                    currentQuestionIndex++;
                    displayQuestion();
                })
                .setNegativeButton("종료", (dialog, which) -> finish())
                .setCancelable(false)
                .show();
    }

}