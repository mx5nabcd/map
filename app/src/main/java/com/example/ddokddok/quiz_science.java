package com.example.ddokddok;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class quiz_science extends AppCompatActivity {
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;  // 맞춘 문제 수
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
            new OXQuestion("개구리는 배꼽이 있다", false, "개구리는 배꼽이 없고, 배꼽은 사람과 같은 포유류에서만 존재합니다."),
            new OXQuestion("이산화탄소를 풍선에 넣으면 소리가 잘 전달된다.", true, "이산화탄소는 공기보다 밀도가 높아, 소리가 잘 전달되는 환경을 만듭니다."),
            new OXQuestion("농도가 약한 물이 농도가 진한 쪽으로 이동하는 원리를 삼투압이라고 한다.", true, "삼투압은 농도가 낮은 쪽에서 높은 쪽으로 물이 이동하는 현상을 의미합니다."),
            new OXQuestion("드라이아이스는 질소로 만들어진다.", false, "드라이아이스는 이산화탄소로 만들어지며, 질소와는 다릅니다."),
            new OXQuestion("종이는 전기가 통하지 않는다.", true, "종이는 전기 전도성이 없어서 전기를 통하지 않습니다.")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_science);

        // UI 요소 초기화
        text_quiz = findViewById(R.id.text_quiz);
        ImageButton oButton = findViewById(R.id.button_o);
        ImageButton xButton = findViewById(R.id.button_x);
        Button Button_myeong_eon = findViewById(R.id.button_myeong_eon2);
        Button Button_sangsik2 = findViewById(R.id.button_sangsik2);
        Button Button_quiz = findViewById(R.id.button_quiz2);

        // '명언' 버튼 클릭 시
        Button_myeong_eon.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_science.this, myeong_eon_categori.class);
            startActivity(intent);
        });

        // '상식' 버튼 클릭 시
        Button_sangsik2.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_science.this, sang_sik_categori.class);
            startActivity(intent);
        });

        // '퀴즈' 버튼 클릭 시
        Button_quiz.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_science.this, quiz_categori.class);
            startActivity(intent);
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
            showFinalResult();  // 퀴즈가 끝난 후 결과 표시
            return;
        }
        // 현재 문제 표시
        text_quiz.setText(questions[currentQuestionIndex].question);
    }

    private void checkAnswer(boolean selectedAnswer) {
        OXQuestion currentQuestion = questions[currentQuestionIndex];
        boolean isCorrect = (selectedAnswer == currentQuestion.correctAnswer);

        if (isCorrect) {
            correctAnswersCount++;  // 맞은 문제 수 증가
        }

        // 정답 체크 및 결과 표시
        showResultDialog(isCorrect, currentQuestion.explanation);
    }

    private void showResultDialog(boolean isCorrect, String explanation) {
        String message = isCorrect ? "정답입니다!" : "틀렸습니다!";
        String correctAnswer = questions[currentQuestionIndex].correctAnswer ? "O" : "X";

        String resultMessage = message + "\n정답: " + correctAnswer;
        if (!isCorrect) {
            resultMessage += "\n해설: " + explanation;  // 틀린 문제에 해설 추가
        }

        // 마지막 문제인지 확인
        boolean isLastQuestion = currentQuestionIndex == questions.length - 1;
        String positiveButtonText = isLastQuestion ? "결과 보기" : "다음 문제";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("결과")
                .setMessage(resultMessage)
                .setPositiveButton(positiveButtonText, (dialog, which) -> {
                    if (isLastQuestion) {
                        showFinalResult();  // 마지막 문제를 푼 후 결과 보기
                    } else {
                        currentQuestionIndex++;
                        displayQuestion();
                    }
                })
                .setCancelable(false)  // 다이얼로그 밖을 눌러도 닫히지 않게
                .show();
    }

    private void showFinalResult() {
        // 퀴즈가 끝났을 때 맞힌 문제 수를 보여주는 다이얼로그
        String finalMessage = "퀴즈 종료!\n맞힌 문제: " + correctAnswersCount + " / " + questions.length;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("최종 결과")
                .setMessage(finalMessage)
                .setPositiveButton("다시 시작", (dialog, which) -> {
                    // 퀴즈를 처음부터 다시 시작
                    currentQuestionIndex = 0;
                    correctAnswersCount = 0;
                    displayQuestion();
                })
                .setNegativeButton("종료", (dialog, which) -> finish())
                .setCancelable(false)
                .show();
    }
}
