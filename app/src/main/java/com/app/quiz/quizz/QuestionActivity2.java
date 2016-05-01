package com.app.quiz.quizz;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuestionActivity2 extends Activity {
    List<Question> quesList;
    int score = 20;
    int qid = 20;
    Question currentQ;
    TextView txtQuestion, times, scored;
    Button button1, button2, button3;
    private ImageView AnswerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        QuizHelper db = new QuizHelper(this); // my question bank class
        quesList = db.getAllQuestions(); // this will fetch all quetonall questions
        currentQ = quesList.get(qid); // the current question
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        times = (TextView) findViewById(R.id.timers);
        AnswerImageView = (ImageView) findViewById(R.id.answer_image);
        times.setText("00:02:00");
        CounterClass timer = new CounterClass(60000, 1000);
        timer.start();
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
            if(score==20) {
                AnswerImageView.setImageResource(R.drawable.cska);
            }else if (score==21){
                AnswerImageView.setImageResource(R.drawable.deportivolacoruna);

            }else if (score==22){
                AnswerImageView.setImageResource(R.drawable.arsnal);

            }else if (score==23){
                AnswerImageView.setImageResource(R.drawable.bilbao);

            }else if (score==24){
                AnswerImageView.setImageResource(R.drawable.liverpool);

            }else if (score==25){
                AnswerImageView.setImageResource(R.drawable.celtic);

            }else if (score==26) {
                AnswerImageView.setImageResource(R.drawable.inter);

            }else if (score==27) {
                AnswerImageView.setImageResource(R.drawable.mancity);

            }else if (score==28) {
                AnswerImageView.setImageResource(R.drawable.manutd);

            }else if (score==29) {
                AnswerImageView.setImageResource(R.drawable.psv);

            }else if (score==30) {
                AnswerImageView.setImageResource(R.drawable.feynoord);

            }else if (score==31) {
                AnswerImageView.setImageResource(R.drawable.schalke);

            }else if (score==32) {
                AnswerImageView.setImageResource(R.drawable.tottenham);

            }else if (score==33) {
                AnswerImageView.setImageResource(R.drawable.twente);

            }else if (score==34) {
                AnswerImageView.setImageResource(R.drawable.udinese);

            }else if (score==35) {
                AnswerImageView.setImageResource(R.drawable.wolfsburg);

            }else if (score==36) {
                AnswerImageView.setImageResource(R.drawable.zurich);

            }else if (score==37) {
                AnswerImageView.setImageResource(R.drawable.auxerre);

            }else if (score==38) {
                AnswerImageView.setImageResource(R.drawable.basiktas);

            }
            score++;
            scored.setText("Score : " + score);
        } else {

            // AnswerImageView.setImageResource(R.drawable.barca);
            Intent intent = new Intent(QuestionActivity2.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
        if (qid < 40) {
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {
            Intent intent = new Intent(QuestionActivity2.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
    }
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
// TODO Auto-generated constructor stub
        }
        @Override
        public void onFinish() {
            times.setText("Time is up");
            Intent intent = new Intent(QuestionActivity2.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
        @Override
        public void onTick(long millisUntilFinished) {
// TODO Auto-generated method stub
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
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