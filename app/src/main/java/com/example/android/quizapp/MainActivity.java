package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    //Number of questions in Quiz
    private static final int NUM_QUESTIONS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when the submit answers button is clicked.
    public void submitAnswers(View view) {

        //Question 1 get selected radio button from radioGroup
        RadioButton q1 = findViewById(R.id.q1_answer3);

        //Question 2 get selected radio button from radioGroup
        RadioButton q2 = findViewById(R.id.q2_answer1);

        //Question 3 Get text answer
        EditText q3Answer = findViewById(R.id.q3);
        String q3 = q3Answer.getText().toString().toUpperCase();

        //Question 4 Get text answer
        EditText q4Answer = findViewById(R.id.q4);
        String q4 = q4Answer.getText().toString().toUpperCase();

        //Question 5 get selected check boxes
        CheckBox q5a = findViewById(R.id.q5_CheckBox1);
        boolean q5chk1 = q5a.isChecked();

        CheckBox q5b = findViewById(R.id.q5_CheckBox2);
        boolean q5chk2 = q5b.isChecked();

        CheckBox q5c = findViewById(R.id.q5_CheckBox3);
        boolean q5chk3 = q5c.isChecked();

        scoreMessage(quizGrade(q1.isChecked(), q2.isChecked(), q3, q4, q5chk1, q5chk2, q5chk3));

    }

    /**
     * Calculates number of correct answers
     * <p>
     * QUESTION: Is there any way to consolidate these IF statments since they are all performing the same numCorrect++ call?
     */
    private int quizGrade(Boolean q1Ans, Boolean q2Ans, String q3Ans, String q4Ans, Boolean q5aAns, Boolean q5bAns, Boolean q5cAns) {
        int numCorrect = 0;

        if (q1Ans) {
            numCorrect++;
        }

        if (q2Ans) {
            numCorrect++;
        }

        if (q3Ans.equals("LEMONADE")) {
            numCorrect++;
        }

        if (q4Ans.equals("CURSE")) {
            numCorrect++;
        }

        if (q5aAns && q5bAns && q5cAns) {
            numCorrect++;
        }

        return (numCorrect);
    }

    /*
     *   Create score Message
     *
     *   QUESTION: Is there a better way to display this text below?
     */
    private void scoreMessage(int score) {
        Toast.makeText(getApplicationContext(), (getString(R.string.youAnswered) + score + getString(R.string.outOf) + NUM_QUESTIONS + getString(R.string.questionsCorrectly)), LENGTH_LONG).show();
    }

}
