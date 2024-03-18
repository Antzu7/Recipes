package com.example.recipes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FirstActivity extends AppCompatActivity {
    Button back_to_breakfast, timer_btn_1;
    TextView timer_value_1;
    private CountDownTimer timer1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_recipe_activity);

        back_to_breakfast = findViewById(R.id.back_to_breakfast);
        timer_btn_1 = findViewById(R.id.timer_btn_1);
        timer_value_1 = findViewById(R.id.timer_value_1);

        timer_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer1 != null){
                    timer1.cancel();
                    timer_btn_1.setText(getString(R.string.timer_btn_text_1));
                    timer_btn_1.setBackgroundColor(Color.parseColor("#6750a4"));
                    timer1 = null;
                    timer_value_1.setText("05:00");
                }
                else {
                    timer_btn_1.setText(getString(R.string.stop_btn));
                    timer_btn_1.setBackgroundColor(Color.RED);
                    timer1=new CountDownTimer(3000,1000) {
                        @Override
                        public void onTick(long l) {
                            NumberFormat f = new DecimalFormat("00");
                            long sec = l/1000;
                            long min = sec/60;
                            sec = sec%60;
                            String time = f.format(min) + ":" + f.format(sec);
                            timer_value_1.setText(time);
                        }

                        @Override
                        public void onFinish() {
                            timer1.cancel();
                            timer_btn_1.setText(getString(R.string.timer_btn_text_1));
                            timer_btn_1.setBackgroundColor(Color.parseColor("#6750a4"));
                            timer1 = null;
                            timer_value_1.setText("05:00");
                            Toast.makeText(getApplicationContext(), getString(R.string.Ready_toast), Toast.LENGTH_SHORT).show();
                        }
                    };
                    timer1.start();
                }
            }
        });

        back_to_breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, BreakfastActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
