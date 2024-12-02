package com.example.ddokddok;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class quiz_sport extends AppCompatActivity {
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;  // 맞춘 문제 수
    private TextView text_quiz;

    private static class OXQuestion {
        String question;
        boolean correctAnswer; // true는 O, false는 X
        String explanation;  // 해설

        OXQuestion(String question, boolean correctAnswer, String explanation) {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.explanation = explanation;
        }
    }

    private OXQuestion[] questions = {
            new OXQuestion("축구는 한 팀에 11명으로 경기를 한다.", true, "축구는 11명이 한 팀으로 구성되어 경기를 합니다."),
            new OXQuestion("농구는 전반 후반 각각 45분씩 진행한다.", false, "농구는 전반, 후반이 각각 12분씩 진행됩니다."),
            new OXQuestion("농구에서 공을 가진 팀은 24초 이내에 바스켓을 향해 공을 던져야 한다.", true, "농구에서는 24초 이내에 슛을 시도해야 하는 규칙이 있습니다."),
            new OXQuestion("농구의 최초 고안자는 제임스 네이스미스다.", true, "농구는 제임스 네이스미스가 고안한 스포츠입니다."),
            new OXQuestion("한국 프로야구(KBO)가 출범한 해는 1997년이다", false, "KBO 리그는 1982년에 출범했습니다.")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_sport);

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
