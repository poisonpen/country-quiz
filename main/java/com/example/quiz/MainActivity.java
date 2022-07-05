package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionText;
    RadioButton trueButton;
    RadioButton falseButton;
    Button nextButton;
    Quiz[] questionBank;
    int questionIndex;
    Boolean answer;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        questionText = (TextView)findViewById(R.id.questionText);
        trueButton = (RadioButton) findViewById(R.id.trueButton);
        falseButton = (RadioButton) findViewById(R.id.falseButton);
        nextButton = (Button) findViewById(R.id.nextQuestionButton);
        questionBank = new Quiz[] {
           new Quiz(getString(R.string.america_question), true),
           new Quiz(getString(R.string.british_question), false),
           new Quiz(getString(R.string.ghana_question), false),
           new Quiz(getString(R.string.independence_question), true),
           new Quiz(getString(R.string.nigeria_question), true)
        };

        questionIndex = 0;
        questionText.setText(questionBank[questionIndex].getQuestion());
        answer = questionBank[questionIndex].getAnswer();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                falseButton.setChecked(false);
                trueButton.setChecked(false);

                questionIndex++;
                questionIndex = questionIndex%questionBank.length;
                questionText.setText(questionBank[questionIndex].getQuestion());
                answer = questionBank[questionIndex].getAnswer();
            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer == true){
                    Toast.makeText(context, getString(R.string.correct), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, getString(R.string.incorrect), Toast.LENGTH_SHORT).show();
                }
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer == false){
                    Toast.makeText(context, getString(R.string.correct), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, getString(R.string.incorrect), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

// new modifications, interface