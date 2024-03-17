package com.example.recipes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LanguageActivity extends AppCompatActivity {
    Button back_to, russian_btn, english_btn, chinese_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_activity);

        back_to = findViewById(R.id.back_to);
        russian_btn = findViewById(R.id.russian_btn);
        english_btn = findViewById(R.id.english_btn);
        chinese_btn = findViewById(R.id.chinese_btn);

        back_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        english_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageHelper.setLocale(LanguageActivity.this, "en");
                setResult(RESULT_OK);
                onBackPressed();
            }
        });

        chinese_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageHelper.setLocale(LanguageActivity.this, "zh");
                setResult(RESULT_OK);
                onBackPressed();
            }
        });

        russian_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageHelper.setLocale(LanguageActivity.this, "ru");
                setResult(RESULT_OK);
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
