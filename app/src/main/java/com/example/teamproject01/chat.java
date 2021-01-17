package com.example.teamproject01;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class chat extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat01);
    }

    public void clicksaving1(View v){

        String username1 = ((MainActivity) MainActivity.forstatic).returnUsername();
        String usercode1 = ((MainActivity) MainActivity.forstatic).returnUsercode();
        String classcode1 = ((MainActivity) MainActivity.forstatic).returnClasscode();
        final EditText chatdata1 = (EditText) findViewById(R.id.enroll_data);

        FirebaseDatabase DB1 = FirebaseDatabase.getInstance();
        Date currentTime = Calendar.getInstance().getTime();

        DatabaseReference myRef = DB1.getReference("check").child(classcode1).child("chat").child(currentTime.toString());
        myRef.setValue( username1  + ":"  +  chatdata1.getText().toString() + '\n');
        //Map<String, Object> childUpdates = new HashMap<>();
        //childUpdates.put(chatdata1.getText().toString() , username1);
        //childUpdates.put("/user-posts/" + userId + "/" + key, postValues);
        //myRef.updateChildren(childUpdates);
    }


    public void clickupdate1(View v){

        String username1 = ((MainActivity) MainActivity.forstatic).returnUsername();
        String usercode1 = ((MainActivity) MainActivity.forstatic).returnUsercode();
        String classcode1 = ((MainActivity) MainActivity.forstatic).returnClasscode();
        final TextView chatupdatedata1 = (TextView) findViewById(R.id.chat_contents);

        FirebaseDatabase DB1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef = DB1.getReference("check").child(classcode1).child("chat");


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
              Object data = dataSnapshot.getValue();
              chatupdatedata1.setText(data.toString());
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a messag
                // ...
            }

        };
        myRef.addValueEventListener(postListener);
       chatupdatedata1.setText(myRef.get().toString());
    }

}
