package com.example.teamproject01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.microedition.khronos.egl.EGLDisplay;

public class purchasingJava extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchasingjava);
    }

    private AlertDialog.Builder builder;
    private DialogInterface.OnClickListener checking = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Date currentTime = Calendar.getInstance().getTime();
            SimpleDateFormat year = new SimpleDateFormat("yyyy", Locale.getDefault());
            SimpleDateFormat month = new SimpleDateFormat("MM", Locale.getDefault());

            String year1 = year.format((currentTime));
            String month1 = month.format((currentTime));

            if(Integer.parseInt(month1) > 6)
                month1 = "1";
            else
                month1 = "2";

            ((MainActivity)MainActivity.forstatic).changingDateenroll(year1 + month1);
        }

        public void onClick() {
            // do something when the button is clicked
            Date currentTime = Calendar.getInstance().getTime();
            SimpleDateFormat year = new SimpleDateFormat("yyyy", Locale.getDefault());
            SimpleDateFormat month = new SimpleDateFormat("MM", Locale.getDefault());

            String year1 = year.format((currentTime));
            String month1 = month.format((currentTime));

            if(Integer.parseInt(month1) > 6)
                month1 = "1";
            else
                month1 = "2";

            ((MainActivity)MainActivity.forstatic).changingDateenroll(year1 + month1);
        }
    };


    public void clicksaving1(View v){
        builder= new AlertDialog.Builder((purchasingJava.this));
        builder.setTitle("결제창");
        EditText enroll = (EditText) findViewById(R.id.enroll_date);

        builder.setMessage(enroll.getText().toString() + "을 결제하시겠습니까?");
        builder.setPositiveButton("확인", checking);
        builder.setNegativeButton("취소",null);
        builder.create().show();
    }
}
