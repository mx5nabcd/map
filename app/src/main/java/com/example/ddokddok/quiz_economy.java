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

public class quiz_economy extends AppCompatActivity {
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
            new OXQuestion("한정된 물량만 판매해 소비자의 구매 욕구를 더욱 자극시키는 마케팅 기법을 헝거 마케팅이라고 한다.", true),
            new OXQuestion("경제지표를 평가하는 과정에서 기준 시점과 비교시점의 상대적인 수치에 따라 그 결과에 큰 차이가 나타나는 현상은 기고효과이다.", false),
            new OXQuestion("물가 불안이나 경기 침체에 대응하기 위한 정부의 시장개입이 과도하거나 변덕스러울 경우 발생하는 역효과를 경고하는 말을 샤워실의 바보라고 한다.", true),
            new OXQuestion("대중에게 잘 알려지지 않았으나 세계시장을 지배하며 경쟁력 있는 우량기업(중소기업)을 히든 챔피언이라고 한다.", true),
            new OXQuestion("기업이나 정부기관 내의 불법적인 행위나 부정행위를 봐주지 않고 지적하는 밀고자, 내부고발자를 휘슬브로커라고 한다.", false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_economy);

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