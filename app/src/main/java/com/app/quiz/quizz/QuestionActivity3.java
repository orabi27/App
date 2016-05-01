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
import android.widget.TextView;
import android.widget.ImageView;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by acer on 06-Apr-16.
 */
public class QuestionActivity3 extends Activity {
    List<Question> quesList;
    int score = 40;
    int qid = 40;
    Question currentQ;
    TextView txtQuestion, times, scored;
    Button button1, button2, button3;
    private ImageView AnswerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
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
            if(score==40) {
                AnswerImageView.setImageResource(R.drawable.bastia);
            }else if (score==41){
                AnswerImageView.setImageResource(R.drawable.brd);

            }else if (score==42){
                AnswerImageView.setImageResource(R.drawable.everton);

            }else if (score==43){
                AnswerImageView.setImageResource(R.drawable.genoa);

            }else if (score==44){
                AnswerImageView.setImageResource(R.drawable.fenerbahce);

            }else if (score==45){
                AnswerImageView.setImageResource(R.drawable.hamburger);

            }else if (score==46) {
                AnswerImageView.setImageResource(R.drawable.leverkusen);

            }else if (score==47) {
                AnswerImageView.setImageResource(R.drawable.lorient);

            }else if (score==48) {
                AnswerImageView.setImageResource(R.drawable.marseille);

            }else if (score==49) {
                AnswerImageView.setImageResource(R.drawable.montpellier);

            }else if (score==50) {
                AnswerImageView.setImageResource(R.drawable.newcastle);

            }else if (score==51) {
                AnswerImageView.setImageResource(R.drawable.olympiacos);

            }else if (score==52) {
                AnswerImageView.setImageResource(R.drawable.shakhtardonetsk);

            }else if (score==53) {
                AnswerImageView.setImageResource(R.drawable.sporting);

            }else if (score==54) {
                AnswerImageView.setImageResource(R.drawable.werderbremen);

            }else if (score==55) {
                AnswerImageView.setImageResource(R.drawable.porto);

            }else if (score==56) {
                AnswerImageView.setImageResource(R.drawable.rangers);

            }else if (score==57) {
                AnswerImageView.setImageResource(R.drawable.saintetien);

            }else if (score==58) {
                AnswerImageView.setImageResource(R.drawable.standard);

            }
            score++;
            scored.setText("Score : " + score);
        } else {

            // AnswerImageView.setImageResource(R.drawable.barca);
            Intent intent = new Intent(QuestionActivity3.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }
        if (qid < 60) {
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {
            Intent intent = new Intent(QuestionActivity3.this,
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
            Intent intent = new Intent(QuestionActivity3.this,
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