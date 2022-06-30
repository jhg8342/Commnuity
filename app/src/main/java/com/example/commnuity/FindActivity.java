package com.example.commnuity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FindActivity extends AppCompatActivity {

    private EditText Email_Text;
    private Button Back_button;
    private Button Send_button;

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
                Intent send = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(send);
            }
        });
    }


}
