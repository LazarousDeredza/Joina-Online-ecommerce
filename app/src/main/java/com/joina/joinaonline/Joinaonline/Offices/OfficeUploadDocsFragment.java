package com.joina.joinaonline.Joinaonline.Offices;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.joina.joinaonline.R;
import com.joina.joinaonline.Tenants.GuestUser.TenantsGuestApplicationUploadActivity;

import java.io.File;
import java.util.ArrayList;


public class OfficeUploadDocsFragment extends Fragment {

    TextView uploadcr14,tvpath2,uploadcr6 ,tv_path3;
    ImageView tvPath,tv_path3i;
    ArrayList<Uri> docs = new ArrayList<>();
    AppCompatButton btnsave;
    ActivityResultLauncher<Intent> resultLauncher, resultLaunchercr6;

    public OfficeUploadDocsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_office_upload_docs, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // assign variable
        uploadcr14 = view.findViewById(R.id.uploadcr14);
        uploadcr6 = view.findViewById(R.id.uploadcr6);
        btnsave = view.findViewById(R.id.next);
        tvPath = view.findViewById(R.id.tv_path);
        tvpath2 = view.findViewById(R.id.tv_path2);
        tv_path3 = view.findViewById(R.id.tv_path3);
        tv_path3i = view.findViewById(R.id.tv_path3i);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), docs.get(1).toString(), Toast.LENGTH_SHORT).show();
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

//        uploadcr6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (ActivityCompat.checkSelfPermission(
//                        Glass.this,
//                        Manifest.permission
//                                .READ_EXTERNAL_STORAGE)
//                        != PackageManager
//                        .PERMISSION_GRANTED) {
//                    // When permission is not granted
//                    // Result permission
//                    ActivityCompat.requestPermissions(
//                            Glass.this,
//                            new String[] {
//                                    Manifest.permission
//                                            .READ_EXTERNAL_STORAGE },
//                            2);
//                }
//                else {
//                    // When permission is granted
//                    // Create method
//                    selectPDFcr();
//                }
//
//
//            }
//        });
        uploadcr6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission
                                .READ_EXTERNAL_STORAGE)
                        != PackageManager
                        .PERMISSION_GRANTED) {
                    // When permission is not granted
                    // Request permission
                    requestPermissions(
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

        uploadcr14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission
                                .READ_EXTERNAL_STORAGE)
                        != PackageManager
                        .PERMISSION_GRANTED) {
                    // When permission is not granted
                    // Request permission
                    requestPermissions(
                            new String[] {
                                    Manifest.permission
                                            .READ_EXTERNAL_STORAGE },
                            1);
                }
                else {
                    // When permission is granted
                    // Create method
                    selectPDFcr();
                }
            }
        });

//        uploadcr14.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override public void onClick(View v)
//                    {
//                        // check condition
//                        if (ActivityCompat.checkSelfPermission(
//                                getContext(),
//                                Manifest.permission
//                                        .READ_EXTERNAL_STORAGE)
//                                != PackageManager
//                                .PERMISSION_GRANTED) {
//                            // When permission is not granted
//                            // Result permission
//                            ActivityCompat.requestPermissions(
//                                    getContext(),
//                                    new String[] {
//                                            Manifest.permission
//                                                    .READ_EXTERNAL_STORAGE },
//                                    1);
//                        }
//                        else {
//                            // When permission is granted
//                            // Create method
//                            selectPDF();
//                        }
//                    }
//                });
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
                    .makeText(getContext(),
                            "Permission Denied",
                            Toast.LENGTH_SHORT)
                    .show();
        }
    }


}