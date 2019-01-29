package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the register button**/
    public void turn_to_reg(View view){
        Intent i = new Intent(view.getContext(), activity_reg.class);
        startActivityForResult(i, 0);
    }

    public void turn_to_log(View view){
        Intent i = new Intent(view.getContext(), activity_log.class);
        startActivityForResult(i, 0);
    }

}
