package com.app.quiz.quizz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.List;
/**
 * Created by acer on 06-Apr-16.
 */
public class QuestionActivity1 extends Activity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion, times, scored;
    Button button1, button2, button3;
    private ImageView AnswerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QuizHelper db = new QuizHelper(this); // my question bank class
        quesList = db.getAllQuestions(); // this will fetch all quetonall questions
        currentQ = quesList.get(qid); // the current question
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        times = (TextView) findViewById(R.id.timers);
        AnswerImageView = (ImageView) findViewById(R.id.answer_image);
        times.setText("");
// the textview in which the question will be displayed
// the three buttons,
// the idea is to set the text of three buttons with the options from question bank
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
// the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.score);
// method which will set the things up for our game
        setQuestionView();
// button click listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// passing the button text to other method
// to check whether the anser is correct or not
// same for all three buttons
                getAnswer(button1.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });
    }
    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {
            if(score==0) {
                AnswerImageView.setImageResource(R.drawable.barca);
            }else if (score==1){
                AnswerImageView.setImageResource(R.drawable.sevilla);

            }else if (score==2){
                AnswerImageView.setImageResource(R.drawable.valence);

            }else if (score==3){
                AnswerImageView.setImageResource(R.drawable.villareal);

            }else if (score==4){
                AnswerImageView.setImageResource(R.drawable.atleticomadrid);

            }else if (score==5){
                AnswerImageView.setImageResource(R.drawable.rcd);

            }else if (score==6) {
                AnswerImageView.setImageResource(R.drawable.ajax);

            }else if (score==7) {
                AnswerImageView.setImageResource(R.drawable.chelsea);

            }else if (score==8) {
                AnswerImageView.setImageResource(R.drawable.asmonaco);

            }else if (score==9) {
                AnswerImageView.setImageResource(R.drawable.juve);

            }else if (score==10) {
                AnswerImageView.setImageResource(R.drawable.bouroussia);

            }else if (score==11) {
                AnswerImageView.setImageResource(R.drawable.milano);

            }else if (score==12) {
                AnswerImageView.setImageResource(R.drawable.bayern);

            }else if (score==13) {
                AnswerImageView.setImageResource(R.drawable.roma);

            }else if (score==14) {
                AnswerImageView.setImageResource(R.drawable.benfica);

            }else if (score==15) {
                AnswerImageView.setImageResource(R.drawable.leicester);

            }else if (score==16) {
                AnswerImageView.setImageResource(R.drawable.palermo);

            }else if (score==17) {
                AnswerImageView.setImageResource(R.drawable.psg);

            }else if (score==18) {
                AnswerImageView.setImageResource(R.drawable.lazio);

            }else if (score==19) {
                AnswerImageView.setImageResource(R.drawable.galatasaray);

            }
            score++;
            scored.setText("Score : " + score);
        } else {

            AnswerImageView.setImageResource(R.drawable.barca);
            Intent intent = new Intent(QuestionActivity1.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
        if (qid < 20) {
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {
            Intent intent = new Intent(QuestionActivity1.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }
    private void setQuestionView() {
// the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        qid++;
    }
}