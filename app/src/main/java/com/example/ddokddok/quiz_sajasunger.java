package com.example.ddokddok;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class quiz_sajasunger extends AppCompatActivity {
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;  // 맞춘 문제 수
    private TextView text_quiz;

    // OXQuestion 클래스에 해설(explanation) 추가
    private static class OXQuestion {
        String question;
        boolean correctAnswer; // true는 O, false는 X
        String explanation;  // 해설 추가

        OXQuestion(String question, boolean correctAnswer, String explanation) {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.explanation = explanation;
        }
    }

    private OXQuestion[] questions = {
            new OXQuestion("가가대소 : 너무 우스워서 껄껄 크게 웃음", true, "‘가가대소’는 매우 웃긴 상황에서 크게 웃는 것을 의미합니다."),
            new OXQuestion("가급인족 : 집집마다 살림이 넉넉하고, 사람마다 의식에 부족함이 없음", true, "‘가급인족’은 매우 잘 살고 있는 상태를 나타내는 표현입니다."),
            new OXQuestion("가기이방 : 이로움을 보자 의로움을 잊는다", false, "‘가기이방’은 이익을 추구하다 보면 올바른 도리를 잃게 된다는 뜻입니다."),
            new OXQuestion("가농성진 : 상대방을 죽이면 결국 함께 죽는다", false, "‘가농성진’은 남을 해치면 결국 자신도 피해를 입는다는 뜻입니다."),
            new OXQuestion("가담항설 : 길거리에 떠도는 소문", false, "‘가담항설’은 소문이 아닌, 길거리에서 들려오는 잘못된 이야기를 의미합니다.")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_sajasunger);

        // UI 요소 초기화
        text_quiz = findViewById(R.id.text_quiz);
        ImageButton oButton = findViewById(R.id.button_o);
        ImageButton xButton = findViewById(R.id.button_x);
        Button Button_myeong_eon = findViewById(R.id.button_myeong_eon2);
        Button Button_sangsik2 = findViewById(R.id.button_sangsik2);
        Button Button_quiz = findViewById(R.id.button_quiz2);

        // '명언' 버튼 클릭 시
        Button_myeong_eon.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_sajasunger.this, myeong_eon_categori.class);
            startActivity(intent);
        });

        // '상식' 버튼 클릭 시
        Button_sangsik2.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_sajasunger.this, sang_sik_categori.class);
            startActivity(intent);
        });

        // '퀴즈' 버튼 클릭 시
        Button_quiz.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_sajasunger.this, quiz_categori.class);
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

        // 틀렸을 때 해설도 함께 표시
        String resultMessage = message + "\n정답: " + correctAnswer;
        if (!isCorrect) {
            resultMessage += "\n해설: " + explanation;
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
