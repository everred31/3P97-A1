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
        });
        equal.setOnClickListener(v -> {
            if (second){
                int current = Integer.parseInt(display.getText().toString());
                result = calculate(saved, current, operand);
                display.setText(String.valueOf(result));


                saved = 0;
                second = false;
                operation = false;
                operand = 0;
                opDisplay.setText("");
            }
        });
        allClear.setOnClickListener(v -> {
            operand = 0;
            display.setText("0");
            operation = true;
            second = false;
            opDisplay.setText("");
        });
    }
    private void setupNumberButton(Button button, String number) {
        button.setOnClickListener(v -> {
            String current = display.getText().toString();

            if (current.equals("0") || !operation) {
                display.setText(number);
                operation = true;
            } else {
                display.append(number);
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
                display.setText("Error");
                if (second == 0){
                    throw new RuntimeException();
                }
                return first / second;
        }
        return second;
    }
}