package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button breakfast_btn, lunch_btn, dinner_btn, language_main;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breakfast_btn = findViewById(R.id.breakfast_btn);
        lunch_btn = findViewById(R.id.lunch_btn);
        dinner_btn = findViewById(R.id.dinner_btn);
        language_main = findViewById(R.id.language_main);

//        breakfast_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, BreakfastActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        lunch_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, LunchActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        dinner_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, DinnerActivity.class);
//                startActivity(intent);
//            }
//        });

        language_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LanguageActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
}