package com.example.android.testwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_FOOD_LIST = "BAKING_FOOD_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String word=getIntent().getStringExtra(MainActivity.EXTRA_FOOD_LIST);

        if (word==null) {
            word="We did not get a word!";
        }

        Toast.makeText(this, word, Toast.LENGTH_LONG).show();

        //finish();
    }
}
