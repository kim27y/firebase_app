package com.example.teamproject01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class identifyJava extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identifyjava);
    }



    public void clicksaving(View v){
        EditText username1 = (EditText) findViewById(R.id.username);
        EditText usercode1 = (EditText) findViewById(R.id.usercode);

        ((MainActivity)MainActivity.forstatic).changingUsername(username1.getText().toString());
        ((MainActivity)MainActivity.forstatic).changingUsercode(usercode1.getText().toString());
    }
}
