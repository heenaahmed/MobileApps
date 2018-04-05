package com.example.praveen.bmi;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends ActionBarActivity {
    private EditText weightEdiText;
    private EditText heightEdiText;
    private RadioButton englishButton, MetricButton;
    private Button calculateButton;
    private TextView resulTexxtview;
    private int height,weight;
    private RadioGroup rdgrp;
    double bmi = 0.0;
    String output=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        weightEdiText = (EditText) findViewById(R.id.weightEdiText);
        heightEdiText = (EditText) findViewById(R.id.heightEdiText);
        englishButton = (RadioButton) findViewById(R.id.englishButton);
        MetricButton = (RadioButton) findViewById(R.id.MetricButton);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        resulTexxtview = (TextView) findViewById(R.id.resultTexxtview);
        rdgrp = (RadioGroup) findViewById(R.id.coversionGroup);
        calculateButton.setOnClickListener(resltBtnListener);


    }

    private  OnClickListener resltBtnListener=new OnClickListener(){

        public void onClick(View v){
            String Input1 = weightEdiText.getText().toString();
            String Input2 = heightEdiText.getText().toString();
            weight = Integer.parseInt(Input1);
            height = Integer.parseInt(Input2);
            if(englishButton.isChecked()) {
                bmi = ((weight * 703) / height * height);
                resulTexxtview.setText(String.valueOf(bmi));
               // output= "the bmi value is" + bmi;

            }
            else
            {
                bmi = ((weight) / height * height);
                resulTexxtview.setText(String.valueOf(bmi));
                //output= "the bmi value is" + bmi + "\n" +;
            }output= "the bmi value is" + bmi + "\n" + "BMI VALUES /n UnderWeight:LessThan 18.5 /n Normal : between 18.5 and 24.9 /n Overweight :between 25 and 29.9 /n Obese : 30 or greater";
            resulTexxtview.setText(output);

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
