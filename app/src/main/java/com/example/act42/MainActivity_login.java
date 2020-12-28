package com.example.act42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_login extends AppCompatActivity {
    EditText e1,e2 = findViewById(R.id.editPassword);
    Button button;
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        db=new DataBaseHelper(this);
        e1= findViewById(R.id.PersonName);
        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean checkmailpwd = db.mailpwdCheck(email, password);
                if (checkmailpwd)
                    Toast.makeText(MainActivity_login.this.getApplicationContext(), "successfully login", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity_login.this.getApplicationContext(), "wrong mail or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}