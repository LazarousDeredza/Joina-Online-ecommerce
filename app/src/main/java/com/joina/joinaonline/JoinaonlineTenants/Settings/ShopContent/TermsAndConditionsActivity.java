package com.joina.joinaonline.JoinaonlineTenants.Settings.ShopContent;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.joina.joinaonline.R;

public class TermsAndConditionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        PDFView pdfView = findViewById(R.id.pdfview);
        pdfView.fromAsset("terms_and_conditions.pdf").load();
    }
}