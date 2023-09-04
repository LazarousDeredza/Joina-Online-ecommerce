package com.joina.joinaonline.JoinaonlineTenants.Dashboard.Requests;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.joina.joinaonline.JoinaonlineTenants.Products.AddProductActivity;
import com.joina.joinaonline.R;
import com.joina.joinaonline.Systems.SystemsHomeActivity;
import com.joina.joinaonline.model.Brand;
import com.joina.joinaonline.viewModel.BrandViewModel;
import com.joina.joinaonline.viewModel.ProductViewModel;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import droidninja.filepicker.utils.ContentUriUtils;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class BrandsRequestsActivity extends AppCompatActivity {

    ImageView addProductImage;
    TextInputEditText brandName, brandDescription, pdescription, pprice,pbrand;
    private static final int GalleryPick = 1;
    private Uri ImageUri;
    Button btnSendRequests;

    private static final int READ_STORAGE_PERMISSION_REQUEST = 123;

    private static final int PICK_IMAGE_REQUEST = 1;

    public static final int RC_PHOTO_PICKER_PERM = 123;
    public static final int RC_FILE_PICKER_PERM = 321;
    private static final int CUSTOM_REQUEST_CODE = 532;
    private int MAX_ATTACHMENT_COUNT = 10;
    private ArrayList<Uri> photoPaths = new ArrayList<>();
    private ArrayList<Uri> docPaths = new ArrayList<>();

    private ImageView imageView, imageview2, imageview3;

    private ImageButton imageButton;

    private ProductViewModel productViewModel;
    private BrandViewModel brandViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands_requests);


        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);

        imageView = findViewById(R.id.imageView);
        imageButton = findViewById(R.id.addImageBtn);

        brandName = findViewById(R.id.brand_name);
        brandDescription = findViewById(R.id.brand_description);
        btnSendRequests = findViewById(R.id.btnSendRequest);

        brandViewModel = ViewModelProviders.of(this).get(BrandViewModel.class);

        btnSendRequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String brand_name = brandName.getText().toString();
                String brand_description = brandDescription.getText().toString();
                String logo_url = "www.google.com";

                Brand brand = new Brand(brand_name,brand_description,logo_url);

                brandViewModel.saveBrands(brand);

            }
        });

        saveBrandObserver();
        saveBrandErrorObserver();


//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                openPhotoPicker();
//                imageView.setVisibility(View.VISIBLE);
//                pickPhotoClicked();
//            }
//        });


    }


    private void saveBrandObserver() {
        brandViewModel.getSaveBrandsResponse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {
                if(response == null) {
                    Toast.makeText(BrandsRequestsActivity.this, "Failed", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(BrandsRequestsActivity.this,"Success !" + response, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void saveBrandErrorObserver() {
        brandViewModel.getErrorOnSaveBrand().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {
                if(response == null) {
                    Toast.makeText(BrandsRequestsActivity.this, "failed", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(BrandsRequestsActivity.this,"Error" + response, Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    @AfterPermissionGranted(RC_PHOTO_PICKER_PERM)
    public void pickPhotoClicked() {
        if (EasyPermissions.hasPermissions(this, FilePickerConst.PERMISSIONS_FILE_PICKER)) {
            onPickPhoto();
        } else {
            // Ask for one permission
            EasyPermissions.requestPermissions(this, "getString(R.string.rationale_photo_picker)",
                    RC_PHOTO_PICKER_PERM, FilePickerConst.PERMISSIONS_FILE_PICKER);
        }
    }
    @AfterPermissionGranted(123)
    private void openPhotoPicker() {

        String permission = Manifest.permission.READ_EXTERNAL_STORAGE;

        if(EasyPermissions.hasPermissions(this, permission)){

            //Creating an intent object and setting its type and action, then passing it as an input argument along with
            //the PICK_IMAGE_REQUEST code previously declared to the startActivityForResult

            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

            intent.addCategory(Intent.CATEGORY_OPENABLE);

            //setType to image/* so that only images will show up
            intent.setType("image/*");

            intent.setAction(Intent.ACTION_GET_CONTENT);

            startActivityForResult(intent, PICK_IMAGE_REQUEST);

        } else {

            EasyPermissions.requestPermissions(this, "Our App Requires a permission to access your storage", READ_STORAGE_PERMISSION_REQUEST
                    , permission);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            ArrayList<Uri> dataList = data.getParcelableArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA);
            if (dataList != null) {
                photoPaths = new ArrayList<Uri>();
                photoPaths.addAll(dataList);
                String filepath = null;

                imageButton.setVisibility(View.GONE);
//                ProductImages productImages = new ProductImages((List<MultipartBody.Part>) data);
                MultipartBody.Part[] files = new MultipartBody.Part[photoPaths.size()];

                for (int i=0 ; i < photoPaths.size(); i++) {
                    try {
                        filepath = ContentUriUtils.INSTANCE.getFilePath(this,photoPaths.get(i) );
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    File file = new File(filepath);

                    RequestBody imageBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//                    Toast.makeText(this, file.getName(), Toast.LENGTH_LONG).show();
                    files[i]= MultipartBody.Part.createFormData("file",file.getName() ,imageBody);
                    Toast.makeText(this, files[0].body().contentType().toString(), Toast.LENGTH_LONG).show();
                }

                productViewModel.uploadImages(files);
                brandViewModel.uploadbrand(files[0]);
                initViewModel();
                ErrorInitView();
                ErrorBrandViewModelResult();
                brandViewModelResults();
                Picasso.get().load("http://192.168.32.71:100/products/icons8-scream-100.png").into(imageView);
//                Picasso.get().load(photoPaths.get(2)).into(imageview3);
//                Picasso.get().load(photoPaths.get(0)).into(imageview2);
            }


            //if the user actually chose an image
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
//                && data != null && data.getData() != null) {
//
//            //chosenPhotoUri is the Uri of the image the user has picked
//            Uri chosenPhotoUri = data.getData();
//
//            //display the chosen photo in the image view
//            Picasso.get().load(chosenPhotoUri).into(imageView);
//
//        }
//



        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if(EasyPermissions.somePermissionPermanentlyDenied(this, perms)){

            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void onPickPhoto() {
        int maxCount = MAX_ATTACHMENT_COUNT - docPaths.size();
        if ((docPaths.size() + photoPaths.size()) == MAX_ATTACHMENT_COUNT) {
            Toast.makeText(this, "Cannot select more than " + MAX_ATTACHMENT_COUNT + " items",
                    Toast.LENGTH_SHORT).show();
        } else {
            FilePickerBuilder.getInstance()
                    .setMaxCount(1)
                    .setSelectedFiles(photoPaths) //this is optional
                    .setActivityTheme(R.style.Theme_JoinACity)
                    .setActivityTitle("Please select media")
                    .setImageSizeLimit(5)
                    .setVideoSizeLimit(10)
                    .setSpan(FilePickerConst.SPAN_TYPE.FOLDER_SPAN, 3)
                    .setSpan(FilePickerConst.SPAN_TYPE.DETAIL_SPAN, 4)
                    .enableVideoPicker(false)
                    .enableCameraSupport(true)
                    .showGifs(true)
                    .showFolderView(false)
                    .enableSelectAll(false)
                    .enableImagePicker(true)

                    .withOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .pickPhoto(this, CUSTOM_REQUEST_CODE);
        }
    }
    private void ErrorInitView() {

        productViewModel.getProductImagesErrorObserver().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String error) {
                if(error == null) {
                    Toast.makeText(BrandsRequestsActivity.this, "no error"+error, Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(BrandsRequestsActivity.this,error +"we have error", Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    private void initViewModel() {

        productViewModel.getProductImagesObserver().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> images) {
                if(images == null) {
                    Toast.makeText(BrandsRequestsActivity.this, "failed to upload" , Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(BrandsRequestsActivity.this, images.get(0), Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    private void ErrorBrandViewModelResult() {

        brandViewModel.getBrandImagesErrorObserver().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String error) {
                if(error == null) {
                    Toast.makeText(BrandsRequestsActivity.this, "no error"+error, Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(BrandsRequestsActivity.this,error  , Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    private void brandViewModelResults() {

        brandViewModel.getBrandImagesObserver().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String images) {
                if(images == null) {
                    Toast.makeText(BrandsRequestsActivity.this, "failed to upload" , Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(BrandsRequestsActivity.this, images, Toast.LENGTH_LONG).show();


                }
            }
        });
    }
}