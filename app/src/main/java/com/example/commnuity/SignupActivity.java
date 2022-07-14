package com.example.commnuity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private EditText Email_Text;
    private EditText PWD_Text;
    private EditText Name_Text;
    private EditText Phone_Text;
    private Button Signup_Button;
    private Button Back_Button;
    //파이어베이스 변수 선언
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        RecallView();
        BackListener();
        SignupListener();
    }






    //
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

    //임시용
    public void SignupListener(){
        Signup_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String Emailinfo = Email_Text.getText().toString().trim();
                String Pwdinfo = PWD_Text.getText().toString().trim();
                String Nameinfo = Name_Text.getText().toString().trim();
                String Phoneinfo = Phone_Text.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(Emailinfo,Pwdinfo)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){

                                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(SignupActivity.this,"Fail to Sign up", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
            }
        });
    }



}
