package com.example.proj1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2, et3;
    Button btn;
    String type="";
    double first;
    double d = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        btn = findViewById(R.id.btn);
        type = et1.getText().toString();
        first = Double.parseDouble(et2.getText().toString());
        d = Double.parseDouble(et2.getText().toString());

    }
    public void next(View view) {
        if(type!="invoicing" && type!="engineering"){
            Toast.makeText(this, "you need to choose between invoicing or engineering", Toast.LENGTH_SHORT).show();
            type = et1.getText().toString();
        }
        if(first<-1000000.0 || first>1000000.0){
            Toast.makeText(this, "you need to choose a number between -1000000 to 1000000", Toast.LENGTH_SHORT).show();
            first = Double.parseDouble(et2.getText().toString());
        }
        if(first<-1000000.0 || first>1000000.0){
            Toast.makeText(this, "you need to choose a number between -1000000 to 1000000", Toast.LENGTH_SHORT).show();
            d = Double.parseDouble(et3.getText().toString());
        }
        Intent si = new Intent(MainActivity.this, SecondActivity.class);
        si.putExtra("Type", type);
        si.putExtra("First", first);
        si.putExtra("delta", d);
        startActivity(si);
    }
}