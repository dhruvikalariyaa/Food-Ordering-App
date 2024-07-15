package com.example.thefoodieszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText unm,pwd;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unm = findViewById(R.id.usernameLogin);
        pwd = findViewById(R.id.passwordLogin);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=unm.getText().toString();
                String password=pwd.getText().toString();
                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(password))
                    Toast.makeText(loginActivity.this, "all field is required", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent i=new Intent(getApplicationContext(),introActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}