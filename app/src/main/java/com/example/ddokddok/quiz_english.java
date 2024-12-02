package com.example.ddokddok;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class quiz_english extends AppCompatActivity {
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;  // 맞힌 문제 수
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
            new OXQuestion("eradicate : 뿌리 뽑다", true, "eradicate는 '뿌리 뽑다'라는 의미로 맞는 설명입니다."),
            new OXQuestion("bin : 콩", false, "bin은 '쓰레기통'을 의미하고, '콩'은 'bean'입니다."),
            new OXQuestion("coma : 혼수상태", true, "coma는 '혼수상태'를 의미하는 단어입니다."),
            new OXQuestion("anguish : 화나다", false, "anguish는 '심한 고통'이나 '괴로움'을 의미하며, '화나다'는 'anger'입니다."),
            new OXQuestion("guru : 권위자", true, "guru는 '권위자'를 의미하며, 전문가 또는 스승을 의미합니다.")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_english);

        // UI 요소 초기화
        text_quiz = findViewById(R.id.text_quiz);
        ImageButton oButton = findViewById(R.id.button_o);
        ImageButton xButton = findViewById(R.id.button_x);
        Button Button_myeong_eon = findViewById(R.id.button_myeong_eon2);
        Button Button_sangsik2 = findViewById(R.id.button_sangsik2);
        Button Button_quiz = findViewById(R.id.button_quiz2);

        // '명언' 버튼 클릭 시
        Button_myeong_eon.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_english.this, myeong_eon_categori.class);
            startActivity(intent);
        });

        // '상식' 버튼 클릭 시
        Button_sangsik2.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_english.this, sang_sik_categori.class);
            startActivity(intent);
        });

        // '퀴즈' 버튼 클릭 시
        Button_quiz.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_english.this, quiz_categori.class);
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
            showFinalResult();  // 퀴즈 종료 후 결과 보기
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
