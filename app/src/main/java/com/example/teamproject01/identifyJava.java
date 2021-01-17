package com.example.teamproject01;

import android.content.Intent;
import android.net.wifi.aware.PublishConfig;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class identifyJava extends AppCompatActivity {


    private EditText classcode1;
    private TextView showname;
    private TextView showcode;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identifyjava);

        showname = (TextView) findViewById(R.id.username);
        showcode = (TextView) findViewById(R.id.usercode);

        showname.setText(((MainActivity)MainActivity.forstatic).returnUsername());
        showcode.setText(((MainActivity)MainActivity.forstatic).returnUsercode());
    }


    public void clicksaving(View v){
        classcode1 = (EditText) findViewById(R.id.classcode);

        FirebaseDatabase DB1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef = DB1.getReference("class").child(classcode1.getText().toString()).child("classUser").child(((MainActivity)MainActivity.forstatic).returnUsercode());
        myRef.setValue(((MainActivity)MainActivity.forstatic).returnUsercode());

        myRef = DB1.getReference("User").child(((MainActivity)MainActivity.forstatic).returnUsercode()).child("class");
        myRef.setValue(classcode1.getText().toString());

        ((MainActivity)MainActivity.forstatic).changingUsername(((MainActivity)MainActivity.forstatic).returnUsername());
        ((MainActivity)MainActivity.forstatic).changingUsercode(((MainActivity)MainActivity.forstatic).returnUsercode());
        ((MainActivity)MainActivity.forstatic).changingUsercode(classcode1.getText().toString());
    }


    public void clickcancel(View v) {

        classcode1 = (EditText) findViewById(R.id.classcode);

        FirebaseDatabase DB1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef = DB1.getReference("check").child(classcode1.getText().toString()).child(((MainActivity)MainActivity.forstatic).returnUsercode());

        myRef.setValue(((MainActivity)MainActivity.forstatic).returnUsername());
        myRef.removeValue();

        ((MainActivity) MainActivity.forstatic).changingUsername(((MainActivity)MainActivity.forstatic).returnUsername());
        ((MainActivity) MainActivity.forstatic).changingUsercode(((MainActivity)MainActivity.forstatic).returnUsercode());
    }


    public void clickupdate(View v) {

        classcode1 = (EditText) findViewById(R.id.classcode);
        final EditText updatefield1 = (EditText) findViewById(R.id.updatefield);

        FirebaseDatabase DB1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef = DB1.getReference("check").child(classcode1.getText().toString()).child("ALARM").child(((MainActivity)MainActivity.forstatic).returnUsername());
        myRef.setValue(updatefield1.getText().toString());
    }


    public void clickchat(View v) {
        Intent intent1 = new Intent(getApplicationContext(), chat.class);
        startActivity(intent1);
    }

}
