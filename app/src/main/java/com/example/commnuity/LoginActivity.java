package com.example.commnuity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button LoginButton;
    private Button SignupButton;
    private Button FindButton;
    private EditText ID_Text;
    private EditText PWD_Text;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        RecallView();
        LoginButtonListener();
        SignupButtonListener();
        FindButtonListener();
    }




    public void RecallView(){
        LoginButton = (Button) findViewById(R.id.login_login_Button);
        SignupButton = (Button) findViewById(R.id.login_signup_Button);
        FindButton = (Button) findViewById(R.id.login_find_Button);
        ID_Text = (EditText) findViewById(R.id.login_text_id);
        PWD_Text = (EditText) findViewById(R.id.login_text_password);
    }

    //임시용

    public void LoginButtonListener(){
        LoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent login = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(login);
            }
        });
    }

    public void SignupButtonListener(){
        SignupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent signup = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(signup);
            }
        });
    }

    public void FindButtonListener(){
        FindButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent find = new Intent(getApplicationContext(),FindActivity.class);
                startActivity(find);
            }
        });
    }
}
