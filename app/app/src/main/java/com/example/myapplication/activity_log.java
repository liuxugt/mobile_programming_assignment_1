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

public class activity_log extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "activity_log";
    private Button log_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        log_btn = (Button) findViewById(R.id.log_btn);
        mAuth = FirebaseAuth.getInstance();
    }

    public void sign_in(View view){
        EditText mail_ET = (EditText) findViewById(R.id.log_user);
        EditText password_ET = (EditText) findViewById(R.id.log_password);
        String email = mail_ET.getText().toString();
        String password = password_ET.getText().toString();

        UpdateUI();
        boolean is_success = false;
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "signInWIthEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(activity_log.this, activity_note_list.class);
                            startActivityForResult(i, 0);
                        }
                        else{
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(activity_log.this, "log in failed.",
                                    Toast.LENGTH_SHORT).show();
                            RestoreUI();
                        }
                    }
                });
    }

    private void UpdateUI(){
        log_btn.setText("logging");
    }
    private void RestoreUI(){
        log_btn.setText("sign in");
    }
}
