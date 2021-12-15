package com.example.fizzbuzz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init all Elements from Layout
        TextView numberText = (TextView) findViewById(R.id.number_placeholder);
        Button divide3 = (Button) findViewById(R.id.divide3);
        Button divide5 = (Button) findViewById(R.id.divide5);
        Button divide3and5 = (Button) findViewById(R.id.divide3and5);
        Button plus = (Button) findViewById(R.id.plus);

        //set number to 0 at Activity start
        numberText.setText("0");

        //onClick listener for "+" button
        plus.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (getCurrentNumber() != 0) {
                         if (calculate(3) || calculate(5)) {
                             reset();
                         } else {
                             increase();
                         }
                     } else {
                         increase();
                     }
                 }
             }
        );

        //onClick listener for "divide 3" button
        divide3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(3, 0);
            }
        });

        //onClick listener for "divide 5" button
        divide5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(5, 0);
            }
        });

        //onClick listener for "divide 3 and 5" button
        divide3and5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(3, 5);
            }
        });
    }

    private boolean calculate(int operator) {
        int currentNumber = getCurrentNumber();

        if (currentNumber == 0) {
            return false;
        }

        //check if currentNumber and operator results 0
        boolean test = currentNumber % operator == 0;
        return currentNumber % operator == 0;
    }

    private void validate(int operator, int second_operator) {
        // This is because we need to validate sometimes 2 numbers in one calculation
        if (second_operator == 0) {
            if (operator == 3) {
                if(!calculate(operator) || calculate(operator) && calculate(5)) {
                    reset();
                } else {
                    increase();
                }
            } else {
                if(!calculate(operator) || calculate(operator) && calculate(3)) {
                    reset();
                } else {
                    increase();
                }
            }
        } else {
            if(calculate(operator) && calculate(second_operator)) {
                //if calculation equals 0 the number will be increased by 1
                increase();
            } else {
                // the number will be set to 0
                reset();
            }
        }
    }

    private void increase() {
        //get TextView
        TextView numberTextView = (TextView) findViewById(R.id.number_placeholder);
        //increase Number
        numberTextView.setText(String.valueOf(getCurrentNumber() + 1));
    }

    private void reset() {
        //get TextView
        TextView numberTextView = (TextView) findViewById(R.id.number_placeholder);
        //reset to 0
        numberTextView.setText("0");
    }

    private int getCurrentNumber() {
        //init number Element
        TextView numberText = (TextView) findViewById(R.id.number_placeholder);

        //get number from TextView and return current number
        return Integer.parseInt((numberText.getText().toString()));
    }
}