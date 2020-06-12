package com.example.android.testwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.testwidget.Model.BakingFood;
import com.example.android.testwidget.Model.Ingredient;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_FOOD_LIST = "BAKING_FOOD_LIST";

    public static final String EXTRA_FOOD_LIST_INGREDIENT = "BAKING_FOOD_LIST_INGREDIENT";

    public static final String BUNDLE_FOOD_LIST_INGREDIENT = "BUNDLE_FOOD_LIST_INGREDIENT";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<BakingFood> bakingFood = (List<BakingFood>) getIntent().getSerializableExtra(EXTRA_FOOD_LIST);
        /*String word=getIntent().getStringExtra(MainActivity.EXTRA_FOOD_LIST);

        if (word==null) {
            word="We did not get a word!";
        }

        Toast.makeText(this, word, Toast.LENGTH_LONG).show();*/

        String toastMsg;
        if (bakingFood==null) {
            toastMsg="We did not get a word!";
        }

        toastMsg = bakingFood.get(0).getName();
        Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();

        //finish();
    }
}
