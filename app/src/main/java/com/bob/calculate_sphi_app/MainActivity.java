package com.bob.calculate_sphi_app;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText input1, input2;
    private Button plus, minus, multiply, divide;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF018786")));

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        result = findViewById(R.id.result);

        plus.setOnClickListener(v -> add());
        minus.setOnClickListener(v -> subtract());
        multiply.setOnClickListener(v -> multiply());
        divide.setOnClickListener(v -> divide());
    }

    private boolean inputIsNotEmpty() {
        boolean b = true;
        if (input1.getText().toString().trim().isEmpty()) {
            input1.setError("Required");
            input1.requestFocus();
            b = false;
        }
        if (input2.getText().toString().trim().isEmpty()) {
            input2.setError("Required");
            input2.requestFocus();
            b = false;
        }
        return b;
    }

    private void add() {
        if (inputIsNotEmpty()) {
            BigDecimal inputdata1 = new BigDecimal(input1.getText().toString().trim());
            BigDecimal inputdata2 = new BigDecimal(input2.getText().toString().trim());
            result.setText(inputdata1.add(inputdata2).toString());
        }
    }

    private void subtract() {
        if (inputIsNotEmpty()) {
            BigDecimal inputdata1 = new BigDecimal(input1.getText().toString().trim());
            BigDecimal inputdata2 = new BigDecimal(input2.getText().toString().trim());
            result.setText(inputdata1.subtract(inputdata2).toString());
        }
    }

    private void multiply() {
        if (inputIsNotEmpty()) {
            BigDecimal inputdata1 = new BigDecimal(input1.getText().toString().trim());
            BigDecimal inputdata2 = new BigDecimal(input2.getText().toString().trim());
            result.setText(inputdata1.multiply(inputdata2).toString());
        }
    }

    private void divide() {
        if (inputIsNotEmpty()) {
            BigDecimal inputdata1 = new BigDecimal(input1.getText().toString().trim());
            BigDecimal inputdata2 = new BigDecimal(input2.getText().toString().trim());

            if (inputdata2.compareTo(BigDecimal.ZERO) == 0) {
                input2.setError("invalid input");
            } else {
                result.setText(inputdata1.divide(inputdata2, 2, RoundingMode.HALF_UP).toString());
            }
        }
    }
}