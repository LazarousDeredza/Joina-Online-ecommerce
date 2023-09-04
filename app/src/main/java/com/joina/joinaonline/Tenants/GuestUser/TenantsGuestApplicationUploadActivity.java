package com.joina.joinaonline.Tenants.GuestUser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.text.Html;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import com.joina.joinaonline.R;
import com.joina.joinaonline.Tenants.TenantAuthActivity;

import java.io.File;
import java.util.ArrayList;


public class TenantsGuestApplicationUploadActivity extends AppCompatActivity {
    // Initialize variable

    TextView uploadcr14,tvpath2,uploadcr6 ,tv_path3;
    ImageView tvPath,tv_path3i;
    ArrayList<Uri> docs = new ArrayList<>();
    AppCompatButton btnsave;
    ActivityResultLauncher<Intent> resultLauncher, resultLaunchercr6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenants_guest_application_upload);

        // assign variable
        uploadcr14 = findViewById(R.id.uploadcr14);
        uploadcr6 = findViewById(R.id.uploadcr6);
        btnsave = findViewById(R.id.next);
        tvPath = findViewById(R.id.tv_path);
        tvpath2 = findViewById(R.id.tv_path2);
        tv_path3 = findViewById(R.id.tv_path3);
        tv_path3i = findViewById(R.id.tv_path3i);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TenantsGuestApplicationUploadActivity.this, docs.get(1).toString(), Toast.LENGTH_SHORT).show();

            }
        });
        // Initialize result launcher
        resultLauncher = registerForActivityResult(
                new ActivityResultContracts
                        .StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(
                            ActivityResult result)
                    {
                        // Initialize result data
                        Intent data = result.getData();
                        Resources res=getResources();
                        Drawable drawable=res.getDrawable(R.drawable.done);
                        // check condition
                        if (data != null) {

                            tvPath.setImageDrawable(drawable);

                            // Get PDf uri
                            Uri sUri = data.getData();
                            docs.add(sUri);
                            // Get PDF path
                            String sPath = sUri.getPath();
                            File file = new File(sPath);

                            // Set path on text view
                            tvpath2.setText(file.getName().toString());

                        }
                    }
                });

        resultLaunchercr6 = registerForActivityResult(
                new ActivityResultContracts
                        .StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(
                            ActivityResult result)
                    {
                        // Initialize result data
                        Intent data = result.getData();
                        Resources res=getResources();
                        Drawable drawable=res.getDrawable(R.drawable.done);
                        // check condition
                        if (data != null) {

                            tv_path3i.setImageDrawable(drawable);

                            // Get PDf uri
                            Uri sUri = data.getData();
                            docs.add(sUri);
                            // Get PDF path
                            String sPath = sUri.getPath();
                            // Set path on text view
                            tv_path3.setText(Html.fromHtml(sPath));

                        }
                    }
                });

        uploadcr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(
                        TenantsGuestApplicationUploadActivity.this,
                        Manifest.permission
                                .READ_EXTERNAL_STORAGE)
                        != PackageManager
                        .PERMISSION_GRANTED) {
                    // When permission is not granted
                    // Result permission
                    ActivityCompat.requestPermissions(
                            TenantsGuestApplicationUploadActivity.this,
                            new String[] {
                                    Manifest.permission
                                            .READ_EXTERNAL_STORAGE },
                            2);
                }
                else {
                    // When permission is granted
                    // Create method
                    selectPDFcr();
                }


            }
        });

        // Set click listener on button
        uploadcr14.setOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v)
                    {
                        // check condition
                        if (ActivityCompat.checkSelfPermission(
                                TenantsGuestApplicationUploadActivity.this,
                                Manifest.permission
                                        .READ_EXTERNAL_STORAGE)
                                != PackageManager
                                .PERMISSION_GRANTED) {
                            // When permission is not granted
                            // Result permission
                            ActivityCompat.requestPermissions(
                                    TenantsGuestApplicationUploadActivity.this,
                                    new String[] {
                                            Manifest.permission
                                                    .READ_EXTERNAL_STORAGE },
                                    1);
                        }
                        else {
                            // When permission is granted
                            // Create method
                            selectPDF();
                        }
                    }
                });
    }

    private void selectPDFcr() {
        Intent intent
                = new Intent(Intent.ACTION_GET_CONTENT);
        // set type
        intent.setType("application/pdf");
        // Launch intent
        resultLaunchercr6.launch(intent);
    }

    private void selectPDF()
    {
        // Initialize intent
        Intent intent
                = new Intent(Intent.ACTION_GET_CONTENT);
        // set type
        intent.setType("application/pdf");
        // Launch intent
        resultLauncher.launch(intent);
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions,
            @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults);

        // check condition
        if (requestCode == 1 && grantResults.length > 0
                && grantResults[0]
                == PackageManager.PERMISSION_GRANTED) {
            // When permission is granted
            // Call method
            selectPDF();

        }
        else if (requestCode == 2 && grantResults.length > 0
                && grantResults[0]
                == PackageManager.PERMISSION_GRANTED){
            // When permission is denied
            // Display toast
            selectPDFcr();

        }else{
            Toast
                    .makeText(getApplicationContext(),
                            "Permission Denied",
                            Toast.LENGTH_SHORT)
                    .show();
        }
    }


    public void back(View view) {
        Intent intent= new Intent(this, TenantsGuestApplicationFormActivity.class);
        startActivity(intent);
    }

    public void apply(View view) {
        Intent intent= new Intent(this, TenantAuthActivity.class);
        startActivity(intent);
    }
}
