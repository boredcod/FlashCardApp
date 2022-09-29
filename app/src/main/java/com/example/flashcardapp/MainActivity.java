package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                if(password.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),"Welcome " + username.getText().toString(),Toast.LENGTH_LONG).show();
                    Intent newAct = new Intent(getBaseContext(), Flashcard.class);
                    startActivity(newAct);
                }else {
                    Toast.makeText(getApplicationContext(),"Incorrect Password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}