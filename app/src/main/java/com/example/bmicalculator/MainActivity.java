package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;

        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFT);
        edtHeightIn=findViewById(R.id.edtHeightIN);
        btnCalculate=findViewById(R.id.btnCalculate);
        txtResult=findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int ft=Integer.parseInt(edtHeightFt.getText().toString());
                int in=Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn=ft*12+in;
                double totalCm=totalIn*2.53;
                double heightInMeter=totalCm/100;
                double bmi=wt/(heightInMeter*heightInMeter);
                if(bmi>25){
                    txtResult.setText("You are overweight");
                }else if(bmi<18){
                    txtResult.setText("You are underweight");
                }else{
                    txtResult.setText("You are healthy");
                }
            }
        });
    }
}