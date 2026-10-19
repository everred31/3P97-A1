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
                if (!second) {
                    saved = Integer.parseInt(display.getText().toString());
                    operand = 1;
                    display.setText("0");
                    second = true;
                }
            });
        subtract.setOnClickListener(v -> {
                    if (!second) {
                        saved = Integer.parseInt(display.getText().toString());
                        operand = 2;
                        display.setText("0");
                        second = true;
                    }
                });
        multiply.setOnClickListener(v -> {
                    if (!second) {
                        saved = Integer.parseInt(display.getText().toString());
                        operand = 3;
                        display.setText("0");
                        second = true;
                    }
                });
        division.setOnClickListener(v -> {
                    if (!second) {
                        saved = Integer.parseInt(display.getText().toString());
                        operand = 4;
                        display.setText("0");
                        second = true;
                    }
                });
        equal.setOnClickListener(v -> {
            if (second){
                switch (operand){
                    case 0: //i dont think this is necessary but it is here in case i need to add behaviour
                        break;
                    case 1:
                        result = saved + Integer.parseInt(display.getText().toString());
                        display.setText(String.valueOf(result));
                        break;
                    case 2:
                        result = saved - Integer.parseInt(display.getText().toString());
                        display.setText(String.valueOf(result));
                        break;
                    case 3:
                        result = saved * Integer.parseInt(display.getText().toString());
                        display.setText(String.valueOf(result));
                        break;
                    case 4:
                        if (Integer.parseInt(display.getText().toString()) == 0){
                            display.setText("Error");
                            break;
                        }
                        result = saved / Integer.parseInt(display.getText().toString());
                        display.setText(String.valueOf(result));
                        break;
                }


                saved = 0;
                second = false;
                operation = false;
            }
        });
        allClear.setOnClickListener(v -> {
            operand = 0;
            display.setText("0");
            operation = true;
            second = false;
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
}