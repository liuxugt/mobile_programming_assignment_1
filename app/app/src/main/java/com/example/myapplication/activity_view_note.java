package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_view_note extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
    }

    public void save(View view){
        /*Save the result on the firebase cloud*/
        EditText body_ET = (EditText) findViewById(R.id.body);
        String body = body_ET.getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.setValue("upload success");
        DatabaseReference myRef1 = myRef.child("user");
        myRef1.setValue("children construction");
        /*-------------------------------------*/

        Intent i = new Intent(activity_view_note.this, activity_note_list.class);
        startActivityForResult(i, 0);
    }

    public void discard(View view){
        Intent i = new Intent(activity_view_note.this, activity_note_list.class);
        startActivityForResult(i, 0);
    }

}
