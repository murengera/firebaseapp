package com.example.a217090265;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private Button btnlogin;
    private EditText editTextemail,editTextpassword;
    private TextView textViewlogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextemail=findViewById(R.id.editTextemail);
        editTextpassword=findViewById(R.id.editTextpassword);
        btnlogin=findViewById(R.id.btnlogin);
        textViewlogin=findViewById(R.id.textviewlogin);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),welcome.class));

        }

        btnlogin.setOnClickListener(this);
        textViewlogin.setOnClickListener(this);
    }
    public void userlogin()
    {
        String email=editTextemail.getText().toString().trim();
        String password=editTextpassword.getText().toString();
        if (TextUtils.isEmpty(email))
        {

            Toast.makeText(this, "email field is empty", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, " password field is empty", Toast.LENGTH_LONG).show();
            return;
        }


        if (password.length()<8)
        {
            Toast.makeText(this, "your password must be greater than eight ", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage(" wait....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful())
                {
                    finish();
                  startActivity(new Intent(getApplicationContext(),welcome.class));
                }


            }
        });

    }
    @Override
    public void onClick(View v) {

        if (v==btnlogin)
        {

 userlogin();
        }
        if (v==textViewlogin)
        {
 finish();
            startActivity(new Intent(this,MainActivity.class));
        }

    }
}
