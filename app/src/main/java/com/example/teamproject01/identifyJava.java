package com.example.teamproject01;

import android.content.Intent;
import android.net.wifi.aware.PublishConfig;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class identifyJava extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identifyjava);
    }



    public void clicksaving(View v){
        EditText username1 = (EditText) findViewById(R.id.username);
        final EditText usercode1 = (EditText) findViewById(R.id.usercode);
        final EditText base_data1 = (EditText) findViewById(R.id.base_data);

        FirebaseDatabase DB1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef = DB1.getReference(username1.getText().toString());
        myRef.setValue(usercode1.getText().toString());

        myRef.addValueEventListener((new ValueEventListener() {

            String Value;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Value= snapshot.getValue(String.class);
                base_data1.setText(Value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                base_data1.setText("error in getting");
            }
        }));




        ((MainActivity)MainActivity.forstatic).changingUsername(username1.getText().toString());
        ((MainActivity)MainActivity.forstatic).changingUsercode(usercode1.getText().toString());
    }
}
