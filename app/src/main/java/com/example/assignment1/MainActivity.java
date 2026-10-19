    package com.example.assignment1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView display;
    TextView opDisplay;
    int operand; // 1, 2, 3, 4
    boolean second = false;
    boolean operation = true;
    int saved;
    int result;
    boolean num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        opDisplay = findViewById(R.id.opDisplay);

        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button zero = findViewById(R.id.zero);

        setupNumberButton(one, "1");
        setupNumberButton(two, "2");
        setupNumberButton(three, "3");
        setupNumberButton(four, "4");
        setupNumberButton(five, "5");
        setupNumberButton(six, "6");
        setupNumberButton(seven, "7");
        setupNumberButton(eight, "8");
        setupNumberButton(nine, "9");
        setupNumberButton(zero, "0");

        Button add = findViewById(R.id.addition);
        Button subtract = findViewById(R.id.subtraction);
        Button multiply = findViewById(R.id.multiplication);
        Button division = findViewById(R.id.division);
        Button equal = findViewById(R.id.equal);
        Button allClear = findViewById(R.id.allClear);
        Button clear = findViewById(R.id.clear);

        add.setOnClickListener(v -> {
            int current = Integer.parseInt(display.getText().toString());
                if (second) {
                    saved = calculate(saved, current, operand);
                    display.setText(String.valueOf(saved));
                }
                else{
                    saved = current;
                }
            operand = 1;
            opDisplay.setText("+");
                second = true;
                operation = false;
                num = false;
            });
        subtract.setOnClickListener(v -> {
            int current = Integer.parseInt(display.getText().toString());

                if (second) {
                    saved = calculate(saved, current, operand);
                    display.setText(String.valueOf(saved));
                }
                else{
                    saved = current;
                }
            operand = 2;
            opDisplay.setText("-");
                second = true;
                operation = false;
            num = false;
                });
        multiply.setOnClickListener(v -> {
            int current = Integer.parseInt(display.getText().toString());

                if (second) {
                    saved = calculate(saved, current, operand);
                    display.setText(String.valueOf(saved));
                }
                else{
                    saved = current;
                }
                second = true;
                operation = false;
            operand = 3;
            opDisplay.setText("*");
            num = false;
                });
        division.setOnClickListener(v -> {
            int current = Integer.parseInt(display.getText().toString());

            if (second) {

                saved = calculate(saved, current, operand);
                display.setText(String.valueOf(saved));


            }
            else{
                saved = current;
            }
            operand = 4;
            opDisplay.setText("/");
            second = true;
            operation = false;
            num = false;
        });
        equal.setOnClickListener(v -> {
            if (second){
                int current = Integer.parseInt(display.getText().toString());

                if (operand == 4 && current == 0) {
                    display.setText("Error");
                } else {
                    result = calculate(saved, current, operand);
                    display.setText(String.valueOf(result));
                }

                saved = 0;
                second = false;
                operation = false;
                operand = 0;
                opDisplay.setText("");
                num = false;
            }
        });
        allClear.setOnClickListener(v -> {
            operand = 0;
            display.setText("0");
            operation = true;
            second = false;
            opDisplay.setText("");
        });
        clear.setOnClickListener(v -> {
            if (!num){
                operand = 0;
                opDisplay.setText("");
                num = true;
            }
            else{
                display.setText("0");
                num = false;
            }
        });
    }
    private void setupNumberButton(Button button, String number) {
        button.setOnClickListener(v -> {
            String current = display.getText().toString();

            if (current.equals("0") || !operation) {
                display.setText(number);
                operation = true;
                num = true;
            } else {
                display.append(number);
                num = true;
            }
        });
    }

    private int calculate(int first, int second, int operand) {
        switch (operand) {
            case 1:
                return first + second;
            case 2:
                return first - second;
            case 3:
                return first * second;
            case 4:

                if (second == 0){
                    display.setText("Error");
                    return 0;
                }else{
                    return first / second;
                }

        }
        return second;
    }
}