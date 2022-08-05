package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionText;
    RadioButton trueButton;
    RadioButton falseButton;
    ImageButton previousButton;
    ImageButton nextButton;
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
        nextButton = (ImageButton) findViewById(R.id.nextQuestionButton);
        previousButton = (ImageButton) findViewById(R.id.previousQuestionButton);

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

        previousButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                reset();
                questionIndex--;
                updateQuestion();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                questionIndex++;
                updateQuestion();
            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer == true){
                    showCorrectFeedback(context);
                } else {
                    showIncorrectFeedback(context);
                }
                trueButton.setChecked(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer == false){
                    showCorrectFeedback(context);
                } else {
                    showIncorrectFeedback(context);
                }
                falseButton.setChecked(true);
            }
        });

    }

    public void showCorrectFeedback (Context context) {
        Toast.makeText(context, getString(R.string.correct), Toast.LENGTH_SHORT).show();
    }
    public void showIncorrectFeedback (Context context) {
        Toast.makeText(context, getString(R.string.incorrect), Toast.LENGTH_SHORT).show();
    }
    public void updateQuestion () {
        questionIndex=(questionIndex+questionBank.length)%questionBank.length;
        questionText.setText(questionBank[questionIndex].getQuestion());
        answer = questionBank[questionIndex].getAnswer();
    }
    public void reset() {
    }

}


// fix selection
// make previous and next into imagebuttons with arrows