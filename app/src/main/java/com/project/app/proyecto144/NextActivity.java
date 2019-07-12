package com.project.app.proyecto144;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    String Email;
    TextView textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Bundle bundle=getIntent().getExtras();
        Email=bundle.getString("Email");

        textEmail = findViewById(R.id.textEmail);

        textEmail.setText(Email.toString());

    }
}
