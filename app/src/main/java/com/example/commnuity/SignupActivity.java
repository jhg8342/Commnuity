package com.example.commnuity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText Email_Text;
    private EditText PWD_Text;
    private EditText Name_Text;
    private EditText Phone_Text;
    private Button Signup_Button;
    private Button Back_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        RecallView();
        BackListener();
        SignupListener();
    }

    public void RecallView(){
        Email_Text = findViewById(R.id.sign_email_text);
        PWD_Text = findViewById(R.id.sign_password_text);
        Name_Text = findViewById(R.id.sign_name_text);
        Phone_Text = findViewById(R.id.sign_password_text);
        Signup_Button = findViewById(R.id.sign_next_button);
        Back_Button = findViewById(R.id.sign_BACK_button);
    }

    public void BackListener(){
        Back_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent Back_intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(Back_intent);
            }
        });
    }

    public void SignupListener(){
        Signup_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent signup = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(signup);
            }
        });
    }



}
