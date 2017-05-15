package com.example.lapnguyen.calculator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public String sign = "";
    public Double double1 ,double2 , NumberSwitch ;

    private EditText edtNumber;
    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;

    private Button btnPlus;
    private Button btnSub;
    private Button btnMulti;
    private Button btnDiv;
    private Button btnResult;

    private Button btnClear;
    private Button btnReset;
    private Button btnPosiNegaSwitch;
    private Button btnDecimalPoint;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
    }

    public void initWidget()
    {
        edtNumber= (EditText) findViewById(R.id.edtNumber);
        btnNumber0=(Button) findViewById(R.id.btnNumber0);
        btnNumber1=(Button) findViewById(R.id.btnNumber1);
        btnNumber2=(Button) findViewById(R.id.btnNumber2);
        btnNumber3=(Button) findViewById(R.id.btnNumber3);
        btnNumber4=(Button) findViewById(R.id.btnNumber4);
        btnNumber5=(Button) findViewById(R.id.btnNumber5);
        btnNumber6=(Button) findViewById(R.id.btnNumber6);
        btnNumber7=(Button) findViewById(R.id.btnNumber7);
        btnNumber8=(Button) findViewById(R.id.btnNumber8);
        btnNumber9=(Button) findViewById(R.id.btnNumber9);

        btnPlus     =(Button) findViewById(R.id.btnPlus);
        btnSub      =(Button) findViewById(R.id.btnSub);
        btnMulti    =(Button) findViewById(R.id.btnMulti);
        btnDiv      =(Button) findViewById(R.id.btnDiv);
        btnResult   =(Button) findViewById(R.id.btnResult);

        btnClear        =(Button) findViewById(R.id.btnClear);
        btnReset        =(Button) findViewById(R.id.btnReset);
        btnDecimalPoint =(Button) findViewById(R.id.btnDecimalPoint);
        btnPosiNegaSwitch=(Button) findViewById(R.id.btnPosiNegaSwitch);
    }

    public void setEventClickViews()
    {
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnResult.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnDecimalPoint.setOnClickListener(this);
        btnPosiNegaSwitch.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnNumber0:
                edtNumber.append("0");
                break;
            case R.id.btnNumber1:
                edtNumber.append("1");
                break;
            case R.id.btnNumber2:
                edtNumber.append("2");
                break;
            case R.id.btnNumber3:
                edtNumber.append("3");
                break;
            case R.id.btnNumber4:
                edtNumber.append("4");
                break;
            case R.id.btnNumber5:
                edtNumber.append("5");
                break;
            case R.id.btnNumber6:
                edtNumber.append("6");
                break;
            case R.id.btnNumber7:
                edtNumber.append("7");
                break;
            case R.id.btnNumber8:
                edtNumber.append("8");
                break;
            case R.id.btnNumber9:
                edtNumber.append("9");
                break;

            case R.id.btnPlus:
                double1 = Double.parseDouble(edtNumber.getText().toString());
                edtNumber.setText("");
                sign="+";
                break;
            case R.id.btnSub:
                double1 = Double.parseDouble(edtNumber.getText().toString());
                edtNumber.setText("");
                sign="-";
                break;
            case R.id.btnMulti:
                double1 = Double.parseDouble(edtNumber.getText().toString());
                edtNumber.setText("");
                sign="*";
                break;
            case R.id.btnDiv:
                double1 = Double.parseDouble(edtNumber.getText().toString());
                edtNumber.setText("");
                sign="/";
                break;
            case R.id.btnResult:
                double2 = Double.parseDouble(edtNumber.getText().toString());
            {
                if (sign == "+") {
                    edtNumber.setText(Double.toString(double1 + double2));
                }
                else if (sign=="-"){
                    edtNumber.setText(Double.toString(double1 - double2));
                }
                else if (sign=="*"){
                    edtNumber.setText(Double.toString(double1 * double2));
                }
                else if (sign=="/"){
                    if (double2 == 0)
                    {
                     edtNumber.setText("Cannot Divide By Zero!");
                    }
                    else
                    {
                    edtNumber.setText(Double.toString(double1 / double2));
                    }
                }
            }
                break;
            case R.id.btnClear:
                edtNumber.setText("0");
                break;
            case R.id.btnReset:
                edtNumber.setText("");
                break;
            case R.id.btnPosiNegaSwitch:
                NumberSwitch = Double.parseDouble(edtNumber.getText().toString());
                NumberSwitch = -NumberSwitch;
                edtNumber.setText(Double.toString(NumberSwitch));
                break;
            case R.id.btnDecimalPoint:
                edtNumber.append(".");
                break;



        }
    }
}
