package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    Double firstValues, secondValues, result_op;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.Result_field);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.seven:
                result.append("7");
                break;
            case R.id.eight:
                result.append("8");
                break;
            case R.id.nine:
                result.append("9");
                break;
            case R.id.six:
                result.append("6");
                break;
            case R.id.five:
                result.append("5");
                break;
            case R.id.four:
                result.append("4");
                break;
            case R.id.three:
                result.append("3");
                break;
            case R.id.two:
                result.append("2");
                break;
            case R.id.one:
                result.append("1");
                break;
            case R.id.zero:
                result.append("0");
                break;
            case R.id.dot:
              String string=(result.getText().toString().trim());
              if (string.length()>0) {
                  result.setText(string + ".");
                  break;
              }
            case R.id.Clear:
                result.setText(" ");
                break;
        }
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                operation = "+";
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "+");

                break;
            case R.id.divide:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "/");
                operation = "/";
                break;
            case R.id.multiply:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "*");
                operation = "*";
                break;
            case R.id.minus:
                firstValues = Double.valueOf(result.getText().toString());
                result.setText(firstValues + "-");
                operation = "-";
                break;
            case R.id.equal:
                if (operation != null) {
                    String two = result.getText().toString().replace(firstValues.toString() + operation, "");
                    secondValues = Double.valueOf(two);

                    switch (operation) {
                        case "+":
                            plusOperation();
                            break;
                        case "-":
                            minusOperation();
                            break;
                        case "*":
                            multiplyOperation();
                            break;
                        case "/":
                            divideOperation();
                            break;
                        case "=":
                            equalOperation();
                   }
                }
        }
    }

    private void plusOperation() {
        result_op = firstValues + secondValues;
        result.setText(firstValues + "+" + secondValues + "=" + result_op);
    }

    private void minusOperation() {
        result_op = firstValues - secondValues;
        result.setText(firstValues + "-" + secondValues + "=" + result_op);
    }

    private void multiplyOperation() {
        result_op = firstValues * secondValues;
        result.setText(firstValues + "*" + secondValues + "=" + result_op);
    }

    private void divideOperation() {
        result_op = firstValues / secondValues;
        result.setText(firstValues + "/" + secondValues + "=" + result_op);
    }

    private Double equalOperation() {
            return result_op;
    }

}


