package com.example.commnuity;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseAuth;

public class FindActivity extends AppCompatActivity {

    private EditText Email_Text;
    private Button Back_button;
    private Button Send_button;
    private ProgressDialog progressDialog;
    //파이어베이스 변수선언
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);
        RecallView();
        BackButtonListener();
        SendButtonListener();

    }

    public void RecallView(){
        Email_Text = findViewById(R.id.find_email_text);
        Back_button = findViewById(R.id.find_back_button);
        Send_button = findViewById(R.id.find_send_button);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();


    }

    public void BackButtonListener(){
        Back_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent back = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(back);
            }
        });
    }

    public void SendButtonListener(){
        Send_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(view == Send_button){
                    progressDialog.setMessage("처리중입니다. 잠시 기다려 주세요...");
                    progressDialog.show();
                    //비밀번호 재설정 이메일 보내기
                    String emailAddress = Email_Text.getText().toString().trim();
                    firebaseAuth.sendPasswordResetEmail(emailAddress)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(FindActivity.this, "이메일을 보냈습니다.",Toast.LENGTH_LONG).show();
                                        finish();
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                    }else{
                                        Toast.makeText(FindActivity.this, "메일을 보내지 못했습니다.",Toast.LENGTH_LONG).show();
                                    }
                                    progressDialog.dismiss();
                                }
                            });
                }
            }
        });
    }


}
