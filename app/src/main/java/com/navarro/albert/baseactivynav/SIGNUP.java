package com.navarro.albert.baseactivynav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.navarro.albert.baseactivynav.database.MyDataBaseHelper;

public class SIGNUP extends AppCompatActivity {
    Button signup;
    EditText password, username;

    MyDataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        helper = MyDataBaseHelper.getInstance(this);
        password = (EditText) findViewById(R.id.psw) ;
        username = (EditText) findViewById(R.id.usr) ;
        signup = (Button) findViewById(R.id.button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = username.getText().toString();
                String b = password.getText().toString();
                helper.signup(a,b);
            }
        });
    }


}
