package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Flashcard extends AppCompatActivity {
    TextView topV;
    TextView botV;
    TextView op;
    Button submit;
    EditText inputN;
    int prev_ans;
    int count;
    int ans;
    protected void randomG (){
        Random random = new Random();
        int val1 = ThreadLocalRandom.current().nextInt(1, 101);
        int val2 = ThreadLocalRandom.current().nextInt(1, 21);
        int o = random.nextInt(2);
        topV.setText(Integer.toString(val1));
        botV.setText(Integer.toString(val2));
        if (o == 0) {
            op.setText("+");
        }
        else {
            op.setText("-");
        }
        if (count == 10) {
            Toast.makeText(getApplicationContext(),Integer.toString(ans) + "/10",Toast.LENGTH_LONG).show();
            count = 0;
            ans = 0;
        }
            int curr_ans;
            if (o == 0){
                curr_ans = val1 + val2;
            }
            else {
                curr_ans = val1 - val2;
            }
            String val = inputN.getText().toString();
            System.out.println(val + "     " + Integer.toString(prev_ans));
            if (prev_ans == -999){
                prev_ans = curr_ans;
            }
            if (val.equals(Integer.toString(prev_ans))) {
                ans += 1;
            }
            prev_ans = curr_ans;
        count++;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        topV = findViewById(R.id.topValue);
        botV = findViewById(R.id.bottomValue);
        op = findViewById(R.id.operator);
        submit = findViewById(R.id.submit);
        inputN = findViewById(R.id.inputNumber);
        count = 0;
        ans = 1;
        prev_ans = -999;
        randomG();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomG();
            }
        });
    }
}