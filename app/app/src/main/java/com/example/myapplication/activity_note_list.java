package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class activity_note_list extends AppCompatActivity {
    private DatabaseReference myRef;
    private FirebaseAuth mAuth;
    private ListView note_list;
    private ArrayList<String> notes_title = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        myRef = FirebaseDatabase.getInstance().getReference(user.getUid());
        note_list = (ListView) findViewById(R.id.note_list);


        final ArrayAdapter<String> note_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1
                , notes_title);
        note_list.setAdapter(note_adapter);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                note value = dataSnapshot.getValue(note.class);
                notes_title.add(value.getTitle() + '\n' + value.getBody());
                note_adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void add_new_note(View view){
        Intent i = new Intent(activity_note_list.this, activity_view_note.class);
        Toast.makeText(activity_note_list.this, "Authentication failed:",
                Toast.LENGTH_SHORT).show();
        startActivityForResult(i, 0);
    }


}
