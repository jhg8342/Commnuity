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

public class LoginActivity extends AppCompatActivity {

    private Button LoginButton;
    private Button SignupButton;
    private Button FindButton;
    private EditText ID_Text;
    private EditText PWD_Text;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        RecallView();
        LoginFunction();
        SignupButtonListener();
        FindButtonListener();

        firebaseAuth = firebaseAuth.getInstance();

    }




    //
    public void RecallView(){
        LoginButton = (Button) findViewById(R.id.login_login_Button);
        SignupButton = (Button) findViewById(R.id.login_signup_Button);
        FindButton = (Button) findViewById(R.id.login_find_Button);
        ID_Text = (EditText) findViewById(R.id.login_text_id);
        PWD_Text = (EditText) findViewById(R.id.login_text_password);
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

    public void LoginFunction(){

        LoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String Idinfo = ID_Text.getText().toString().trim();
                String Pwdinfo = PWD_Text.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(Idinfo, Pwdinfo)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(LoginActivity.this,"아이디와 비밀번호가 틀립니다.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
