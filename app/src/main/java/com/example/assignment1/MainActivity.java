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
    double saved;
    double result;
    boolean num;
    boolean isDecimal;
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

        setupButtons(one, "1");
        setupButtons(two, "2");
        setupButtons(three, "3");
        setupButtons(four, "4");
        setupButtons(five, "5");
        setupButtons(six, "6");
        setupButtons(seven, "7");
        setupButtons(eight, "8");
        setupButtons(nine, "9");
        setupButtons(zero, "0");

        Button add = findViewById(R.id.addition);
        Button subtract = findViewById(R.id.subtraction);
        Button multiply = findViewById(R.id.multiplication);
        Button division = findViewById(R.id.division);
        Button equal = findViewById(R.id.equal);
        Button allClear = findViewById(R.id.allClear);
        Button clear = findViewById(R.id.clear);
        Button decimal = findViewById(R.id.decimal);

        add.setOnClickListener(v -> {
            double current = Double.parseDouble(display.getText().toString());
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
            double current = Double.parseDouble(display.getText().toString());

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
            double current = Double.parseDouble(display.getText().toString());

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
            double current = Double.parseDouble(display.getText().toString());

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
                double current = Double.parseDouble(display.getText().toString());

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
        decimal.setOnClickListener(v -> {
            if (!isDecimal){
                display.append(".");
                isDecimal = true;
            }
        });
    }
    private void setupButtons(Button button, String number) {
        button.setOnClickListener(v -> {
            String current = display.getText().toString();

            if (current.equals("0") || !operation) {
                display.setText(number);
                operation = true;
            } else {
                display.append(number);
            }
            num = true;
        });
    }

    private double calculate(double first, double second, int operand) {
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