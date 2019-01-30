package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_view_note extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        mAuth = FirebaseAuth.getInstance();
    }

    public void save(View view){
        /*Save the result on the firebase cloud*/
        FirebaseUser user = mAuth.getCurrentUser();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(user.getUid());
        EditText body_ET = (EditText) findViewById(R.id.body);
        EditText title_ET = (EditText) findViewById(R.id.title);
        String title = title_ET.getText().toString();
        String body = body_ET.getText().toString();
        note new_note = new note(title,body);

        myRef.push().setValue(new_note);
        /*-------------------------------------*/

        Intent i = new Intent(activity_view_note.this, activity_note_list.class);
        startActivityForResult(i, 0);
    }

    public void discard(View view){
        Intent i = new Intent(activity_view_note.this, activity_note_list.class);
        startActivityForResult(i, 0);
    }

}
