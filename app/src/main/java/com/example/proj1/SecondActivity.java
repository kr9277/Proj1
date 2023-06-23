package com.example.proj1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;
    ListView lv;
    Intent gi;
    String kind;
    double a1;
    double delta;
    double[] arr = new double[20];
    String[] arr_string = new String[20];
    double eser=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        lv = (ListView) findViewById(R.id.lv);
        gi = getIntent();
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        kind = gi.getStringExtra("Type");
        a1 = gi.getDoubleExtra("First", 0.0);
        delta = gi.getDoubleExtra("delta", 0.0);
        arr[0]=a1;
        arr_string[0]= String.valueOf(a1);
        if(kind.equals("invoicing")){
            for(int i=1;i<20;i++){
                arr[i]=arr[i-1]+delta;
                arr_string[i]= String.valueOf(arr[i]);
            }
        }
        else{
            for(int i=1;i<20;i++){
                arr[i]=arr[i-1]*delta;
                arr_string[i]=String.valueOf(arr[i]);
            }
        }
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr_string);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int n = position + 1;
                tv1.setText(arr_string[0]);
                tv2.setText(String.valueOf((delta)));
                tv3.setText(String.valueOf((n)));
                if(kind.equals("invoicing")){
                    eser = (n * (2*a1 + delta*(n-1)))/2;
                }
                else{
                    eser = a1 * (Math.pow(delta, n)-1)/(delta-1);
                }
                tv4.setText(String.valueOf((eser)));
            }
        });
    }
}