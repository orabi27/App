package com.app.quiz.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NivActivity extends AppCompatActivity {
    Button button, button4,button5,button6,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niv);
        button = (Button) findViewById(R.id.button);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivActivity.this,niv1Activity.class);
                startActivity(intent);
                finish();
            }


        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(NivActivity.this,Niv2Activity.class);
                startActivity(intent);
                finish();

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(NivActivity.this,Niv3Activity.class);
                startActivity(intent);
                finish();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivActivity.this,Niv4Activity.class);
                startActivity(intent);
                finish();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NivActivity.this,Niv5Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }


}
