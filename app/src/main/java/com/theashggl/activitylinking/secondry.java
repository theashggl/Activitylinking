package com.theashggl.activitylinking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondry extends AppCompatActivity {
TextView addac,forget;
Button log;
EditText user, passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondry);

        passwd = findViewById(R.id.paswd);
        user = findViewById(R.id.id);
        log = findViewById(R.id.login);
        addac= findViewById(R.id.register);
        forget= findViewById(R.id.forgt);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(secondry.this,Form.class));
            }
        });
        addac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go=new Intent(secondry.this,Form.class);
            }
        });
    }
}