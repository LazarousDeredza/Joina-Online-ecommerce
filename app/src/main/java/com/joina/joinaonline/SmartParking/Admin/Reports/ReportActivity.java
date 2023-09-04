package com.joina.joinaonline.SmartParking.Admin.Reports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;
import com.joina.joinaonline.R;
import com.joina.joinaonline.SmartParking.Admin.ParkingLog.ParkingLogActivity;

public class ReportActivity extends AppCompatActivity {

    private ImageView passLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        passLog = findViewById(R.id.passlog);
        passLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReportActivity.this, ParkingLogActivity.class);
                startActivity(intent);
            }
        });
    }
}