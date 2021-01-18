package com.example.teamproject01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class goalcheck extends AppCompatActivity {

    private ImageView iv;
    private String text;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test1);
    }

    public void profile(View v){
        final EditText profile1 = (EditText) findViewById(R.id.getdata);
        String username1 = ((MainActivity) MainActivity.forstatic).returnUsername();

        profile1.setText(username1);
    }
}
