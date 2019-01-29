package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_note_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
    }

    public void add_new_note(View view){
        Intent i = new Intent(view.getContext(), activity_view_note.class);
        startActivityForResult(i, 0);
    }
}
