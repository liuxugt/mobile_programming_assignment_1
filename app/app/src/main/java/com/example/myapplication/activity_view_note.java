package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_view_note extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
    }

    public void save(View view){
        /*Save the result on the firebase cloud*/

        /*-------------------------------------*/

        Intent i = new Intent(activity_view_note.this, activity_note_list.class);
        startActivityForResult(i, 0);
    }

    public void discard(View view){
        Intent i = new Intent(activity_view_note.this, activity_note_list.class);
        startActivityForResult(i, 0);
    }

}
