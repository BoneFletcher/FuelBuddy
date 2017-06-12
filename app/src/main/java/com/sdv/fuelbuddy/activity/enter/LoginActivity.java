package com.sdv.fuelbuddy.activity.enter;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.sdv.fuelbuddy.R;
import com.sdv.fuelbuddy.activity.map.MapsActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText emailView;
    private EditText passView;
    private ProgressWheel myProgressBar;
    private TextView tvReg;


    public Cursor c;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        setContentView(R.layout.activity_login);

        tvReg = (TextView) findViewById(R.id.tv_reg);
        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        emailView = (EditText) findViewById(R.id.email);
        passView = (EditText) findViewById(R.id.pass);
        myProgressBar = (ProgressWheel) findViewById(R.id.progress_wheel);




        AppCompatButton loginButton = (AppCompatButton) findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    signIn(emailView.getText().toString(), passView.getText().toString());
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = emailView.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailView.setError("Required.");
            valid = false;
        } else {
            emailView.setError(null);
        }

        String password = passView.getText().toString();
        if (TextUtils.isEmpty(password)) {
            passView.setError("Required.");
            valid = false;
        } else {
            passView.setError(null);
        }

        return valid;
    }

    private void signIn(String email, String password) {

        if (!validateForm()) {
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(LoginActivity.this, MapsActivity.class));

                        }
                        if (!task.isSuccessful()) {

                        }

                    }
                });
    }




    private boolean isEmailValid(String email) {
        return email.contains("@") && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }



    @Override
    public void onResume() {
        super.onResume();
        myProgressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
