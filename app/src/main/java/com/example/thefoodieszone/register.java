package com.example.thefoodieszone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText name,pass,rpass;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        componentIntialize();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper db = new DatabaseHelper(register.this);

                if(db.insertRecord(name.getText().toString(),pass.getText().toString(),rpass.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Record had been added!",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),loginActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Something went wrong!",Toast.LENGTH_LONG).show();

                }

            }
        });


//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatabaseHelper db = new DatabaseHelper(register.this);
//
//
//                Integer a = db.deleteRecord(name.getText().toString());
//
//                if(a>0)
//                {
//                    Toast.makeText(getApplicationContext(),"Record had been deleted",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//
//                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                DatabaseHelper db = new DatabaseHelper(register.this);
//                Cursor res = db.getAllData();
//                if(res.getCount()==0)
//                {
//                    return;
//                }
//
//                StringBuffer buffer = new StringBuffer();
//
//                while (res.moveToNext())
//                {
//                    buffer.append("ID : "+res.getString(0)+"\n");
//                    buffer.append("NAME : "+res.getString(1)+"\n");
//                    buffer.append("SURNAME : "+res.getString(2)+"\n");
//                    buffer.append("ADDRESS : "+res.getString(3)+"\n");
//
//                }
//
//                showMessage("Data ",buffer.toString());
//
//
//            }
//        });
//
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatabaseHelper db = new DatabaseHelper(register.this);
//
//                boolean t = db.updateData(name.getText().toString(),surname.getText().toString(),address.getText().toString());
//
//                if(t)
//                {
//                    Toast.makeText(getApplicationContext(),"Record has been updated",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//
//                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
//                }
//
//            }
//        });

    }

//    private void showMessage(String title, String msg) {
//
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(msg);
//        builder.show();
//
//    }

    private void componentIntialize() {
        name = (EditText)findViewById(R.id.username);
        pass= (EditText)findViewById(R.id.password);
        rpass = findViewById(R.id.repassword);
        register = findViewById(R.id.register);

    }



}