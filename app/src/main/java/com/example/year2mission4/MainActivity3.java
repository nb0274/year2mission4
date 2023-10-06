package com.example.year2mission4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {
    Intent in2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        in2 = getIntent();
    }

    /**
     * returns to main
     * @param view
     */
    public void goToMain(View view)
    {
        finish();
    }
}