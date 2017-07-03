package com.navarro.albert.baseactivynav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.navarro.albert.baseactivynav.activities.SUPERCALCULATOR;
import com.navarro.albert.baseactivynav.database.MyDataBaseHelper;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Button signup, login;
    MyDataBaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.user) ;
        password = (EditText) findViewById(R.id.pas) ;
        signup = (Button) findViewById(R.id.sign) ;
        signup.setOnClickListener(this);
        login = (Button) findViewById(R.id.login) ;
        login.setOnClickListener(this);
        helper = MyDataBaseHelper.getInstance(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                String a = username.getText().toString();
                String b = password.getText().toString();
                String c = helper.queryRow(a);
                if(!c.equals("Not found")){
                    if (c.equals(b)){
                        Toast.makeText(getApplicationContext(), "WELCOME "+ a, Toast.LENGTH_LONG).show();
                        Intent correct = new Intent(this, SUPERCALCULATOR.class );
                        startActivity(correct);
                    }else {
                        Toast.makeText(getApplicationContext(), "WRONG PASSWORD", Toast.LENGTH_LONG).show();
                    }
                }else Toast.makeText(getApplicationContext(), "Username " + a + " Does not exist", Toast.LENGTH_LONG).show();

            case R.id.sign:
                Intent i = new Intent(this, SIGNUP.class );
                startActivity(i);

        }
    }
}
