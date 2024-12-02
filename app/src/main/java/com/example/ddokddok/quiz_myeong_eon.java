package com.example.ddokddok;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class quiz_myeong_eon extends AppCompatActivity {
    private int currentQuestionIndex = 0;
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
            new OXQuestion("정직과 미덕의 샘이자 근원은 훌륭한 교육에 있다 : 공자", false, "이 말은 공자의 가르침이 아닌, 다른 철학자들의 말입니다."),
            new OXQuestion("배우나 생각하지 않으면 공허하고, 생각하나 배우지 않으면 위험하다 : 공자", true, "공자의 가르침으로, 배우고 생각하는 것이 중요한 점을 강조합니다."),
            new OXQuestion("절망은 마약이다. 절망은 생각을 무관심으로 잠재울 뿐이다 : 찰리 채플린", true, "찰리 채플린의 명언으로, 절망이 사람의 사고를 방해한다는 의미입니다."),
            new OXQuestion("지붕은 햇빛이 밝을 때 수리해야 합니다 : 오바마", false, "이 발언은 오바마의 발언이 아닌, 다른 인물의 발언입니다."),
            new OXQuestion("유행은 유행에 뒤떨어질 수 밖에 없게 만들어진다 : 가브리엘(코코)샤넬", true, "코코 샤넬의 말로, 유행은 항상 변화하기 마련이라고 설명한 명언입니다.")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_myeong_eon);

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
                Intent intent = new Intent(quiz_myeong_eon.this, myeong_eon_categori.class);
                startActivity(intent);
            }
        });

        Button_sangsik2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_myeong_eon.this, sang_sik_categori.class);
                startActivity(intent);
            }
        });

        Button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(quiz_myeong_eon.this, quiz_categori.class);
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

        // 틀렸을 때 해설도 함께 표시
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
