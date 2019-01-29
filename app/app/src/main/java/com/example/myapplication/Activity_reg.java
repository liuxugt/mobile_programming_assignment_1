package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_reg extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "activity_reg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        mAuth = FirebaseAuth.getInstance();
    }

    public void signup(View view){
        EditText mail_ET = (EditText) findViewById(R.id.reg_user);
        EditText password_ET = (EditText) findViewById(R.id.reg_password);
        String email = mail_ET.getText().toString();
        String password = password_ET.getText().toString();

        Button reg_btn = (Button) findViewById(R.id.reg_btn);
        reg_btn.setText("submitted");
        /**Add some requirement for password**/

        /**---------------------------------**/

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(activity_reg.this, activity_note_list.class);
                            startActivityForResult(i, 0);
                        }
                        else{
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(activity_reg.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
