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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



private EditText email,password;
private Button register;
private ProgressDialog progressDialog;
private TextView alreadyaccount;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email=findViewById(R.id.editTextemail);
        password=findViewById(R.id.editTextpassword);
        alreadyaccount=findViewById(R.id.alredyhaveacount);
        register=findViewById(R.id.btnregister);
        register.setOnClickListener(this);
        alreadyaccount.setOnClickListener(this);

        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();



    }



    private void  registers()
    {
        String Email=email.getText().toString().trim();
        String Password=password.getText().toString().trim();

        if (TextUtils.isEmpty(Email))
        {

            Toast.makeText(this, "email and password field is empty", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(Password))
        {
            Toast.makeText(this, "email and password field is empty", Toast.LENGTH_LONG).show();
            return;
        }


        if (Password.length()<8)
        {
            Toast.makeText(this, "your password must be greater than eight ", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("registering user....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {

                    finish();
                    startActivity(new Intent(getApplicationContext(),Login.class));


                }
                else
                {
                    Toast.makeText(MainActivity.this, "no registration !", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    @Override
    public void onClick(View v) {
    if (v==register)
    {
   registers();

    }
    if (v==alreadyaccount){

        startActivity(new Intent(getApplicationContext(),Login.class));

    }
    }
}
