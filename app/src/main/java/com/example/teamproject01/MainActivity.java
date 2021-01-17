package com.example.teamproject01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseUser user;
    private String username ="";
    private String usercode = "";
    private String classcode = "";
    private String enroll_date;
    private String returnString;
    public static Context forstatic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forstatic = this;

        Intent intent = new Intent(this, firstWindow.class);
        startActivity(intent);


        user = FirebaseAuth.getInstance().getCurrentUser();
        username = user.getDisplayName();
        usercode = user.getEmail().substring(0,8);
    }

    public void changingUsername(String data)
    {
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(data)
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "이름 변경 완료!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public String returnUsername() {return username;}

    public void changingUsercode(String data) { user.updateEmail(username+"@inha.ac.kr")
            .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "학번 변경 완료!", Toast.LENGTH_LONG).show();
                    }
                }
            }); }

    public String returnUsercode() {return usercode;}

    public void changingClasscode(String data) { classcode = data; }
    public String returnClasscode() {return classcode;}







    public void changingDateenroll(String data)
    {
       enroll_date = data;
    }

    public String getReturnString()
    {
        returnString = username + "," + usercode + "," + enroll_date;
        return returnString;
    }



    public void click01(View v){ //firebase 데이타베이스도 여기서 진행
        Intent intent1 = new Intent(getApplicationContext(), identifyJava.class);
        startActivity(intent1);
    }

    public void click02(View v){
        Intent intent1 = new Intent(getApplicationContext(), purchasingJava.class);
        startActivity(intent1);
    }

    public void click03(View v){
        Intent intent1 = new Intent(getApplicationContext(), conveyJava.class);
        startActivity(intent1);
    }

    public void click04(View v){
        Intent intent1 = new Intent(getApplicationContext(), QRcodeJava.class);
        startActivity(intent1);
    }


    public void click05(View v){
        TextView showing1 = (TextView) findViewById(R.id.showing);
        showing1.setText(getReturnString());
    }


}