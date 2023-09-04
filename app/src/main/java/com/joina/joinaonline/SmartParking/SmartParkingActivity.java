package com.joina.joinaonline.SmartParking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkingLogActivity;
import com.joina.joinaonline.SmartParking.Admin.Reports.ReportActivity;


public class SmartParkingActivity extends AppCompatActivity {

    private FloatingActionButton chat;
    private ImageView passLog;
    private TextView report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_parking);

        passLog = findViewById(R.id.passlog);

        passLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SmartParkingActivity.this, ParkingLogActivity.class);
                startActivity(intent);
            }
        });

        report = findViewById(R.id.reports);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SmartParkingActivity.this, ReportActivity.class);
                startActivity(intent);
            }
        });

        chat = findViewById(R.id.chat);
//        chat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SmartParkingActivity.this, AdminUserChattingActivity.class);
//                startActivity(intent);
//            }
//        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject=" + "Smart Parking Enquiry"+ "&body=" + "Joina Online Enquiry Team\n" + "&to=" + "shawntakudzwakanyemba99@gmail.com");
                mailIntent.setData(data);
                startActivity(Intent.createChooser(mailIntent, "Send mail..."));
            }
        });

    }
}