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

import androidx.appcompat.app.AppCompatActivity;

public class quiz_economy extends AppCompatActivity {
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;  // 맞힌 문제 수
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
            new OXQuestion("한정된 물량만 판매해 소비자의 구매 욕구를 더욱 자극시키는 마케팅 기법을 헝거 마케팅이라고 한다.", true, "헝거 마케팅은 소비자의 부족한 느낌을 자극하여 구매욕구를 높이는 전략입니다."),
            new OXQuestion("경제지표를 평가하는 과정에서 기준 시점과 비교시점의 상대적인 수치에 따라 그 결과에 큰 차이가 나타나는 현상은 기고효과이다.", false, "이 현상은 기고효과가 아니라 '기준 효과'입니다."),
            new OXQuestion("물가 불안이나 경기 침체에 대응하기 위한 정부의 시장개입이 과도하거나 변덕스러울 경우 발생하는 역효과를 경고하는 말을 샤워실의 바보라고 한다.", true, "샤워실의 바보는 정부의 지나친 시장 개입으로 발생하는 역효과를 경고하는 말입니다."),
            new OXQuestion("대중에게 잘 알려지지 않았으나 세계시장을 지배하며 경쟁력 있는 우량기업(중소기업)을 히든 챔피언이라고 한다.", true, "히든 챔피언은 주로 경쟁력이 뛰어난 중소기업을 일컫는 용어입니다."),
            new OXQuestion("기업이나 정부기관 내의 불법적인 행위나 부정행위를 봐주지 않고 지적하는 밀고자, 내부고발자를 휘슬브로커라고 한다.", false, "내부고발자는 '휘슬블로어(whistleblower)'입니다. '휘슬브로커'는 잘못된 용어입니다.")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_economy);

        // UI 요소 초기화
        text_quiz = findViewById(R.id.text_quiz);
        ImageButton oButton = findViewById(R.id.button_o);
        ImageButton xButton = findViewById(R.id.button_x);
        Button Button_myeong_eon = findViewById(R.id.button_myeong_eon2);
        Button Button_sangsik2 = findViewById(R.id.button_sangsik2);
        Button Button_quiz = findViewById(R.id.button_quiz2);

        // '명언' 버튼 클릭 시
        Button_myeong_eon.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_economy.this, myeong_eon_categori.class);
            startActivity(intent);
        });

        // '상식' 버튼 클릭 시
        Button_sangsik2.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_economy.this, sang_sik_categori.class);
            startActivity(intent);
        });

        // '퀴즈' 버튼 클릭 시
        Button_quiz.setOnClickListener(view -> {
            Intent intent = new Intent(quiz_economy.this, quiz_categori.class);
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
