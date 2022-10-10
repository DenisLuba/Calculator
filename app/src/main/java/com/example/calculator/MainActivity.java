package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFirst, etSecond;
    Button btnPlus, btnMinus, btnDivide, btnMultiply;
    TextView tvOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirst = findViewById(R.id.first);
        etSecond = findViewById(R.id.second);
        btnPlus = findViewById(R.id.plus);
        btnMinus = findViewById(R.id.minus);
        btnMultiply = findViewById(R.id.multiply);
        btnDivide = findViewById(R.id.divide);
        tvOut = findViewById(R.id.textView);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float num1 = 0;
        float num2 = 0;
        float res = 0;

        if (TextUtils.isEmpty(etFirst.getText().toString()) || TextUtils.isEmpty(etSecond.getText().toString())) return;

        try {
            num1 = Float.parseFloat(etFirst.getText().toString());
            num2 = Float.parseFloat(etSecond.getText().toString());
        } catch (NumberFormatException e) {}

        switch (view.getId()) {
            case R.id.plus:
                res = num1 + num2;
                break;
            case R.id.minus:
                res = num1 - num2;
                break;
            case R.id.multiply:
                res = num1 * num2;
                break;
            case R.id.divide:
                res = num1 / num2;
                break;
        }

        Button b = (Button) view;
        String result = String.format("%.1f %s %.1f = %.1f", num1, b.getText(), num2, res);

        tvOut.setText(result);
    }
}