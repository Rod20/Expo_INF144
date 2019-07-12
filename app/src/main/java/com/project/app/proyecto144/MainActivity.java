package com.project.app.proyecto144;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    String Email="",Pass="";
    TextView errorEmail, errorPass;
    EditText editTextEmail;
    TextInputEditText editTextPass;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.inputEmail);
        editTextPass = findViewById(R.id.inputPassword);
        errorEmail = findViewById(R.id.textErrorEmail);
        errorPass = findViewById(R.id.textErrorPass);
        buttonNext = findViewById(R.id.buttonNext);

    }

    public void goNextActivity(View view)
    {
        Email=editTextEmail.getText().toString();
        errorEmail.setText("");
        errorPass.setText("");

        if (isValidInput(Email))
        {
            Intent intent= new Intent(getApplicationContext(), NextActivity.class);
            intent.putExtra("Email",Email);
            startActivity(intent);
            finish();
        }
    }

    public boolean isValidInput(String Email)
    {
        if (editTextEmail.getText().toString().equals(""))
        {
            errorEmail.setText(getResources().getString(R.string.these_field_are_mandatory));
            return false;
        }
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(Email);
        if(!mather.find()){
            errorEmail.setText(getResources().getString(R.string.email_not_valid));
            return false;
        }
        if (editTextPass.getText().toString().equals(""))
        {
            errorPass.setText(getResources().getString(R.string.these_field_are_mandatory));
            return false;
        }

        if(editTextPass.getText().length() < 8)
        {
            errorPass.setText(getResources().getString(R.string.passwordShort));
            return false;
        }
        return true;
    }
}
