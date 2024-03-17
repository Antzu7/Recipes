package com.example.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BreakfastActivity extends AppCompatActivity {
    Button back_to_main, first_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfast_activity);

        back_to_main = findViewById(R.id.back_to_main);
        first_btn = findViewById(R.id.first_btn);

        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BreakfastActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        first_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BreakfastActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            recreate();
            Intent intent = new Intent(BreakfastActivity.this, BreakfastActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
