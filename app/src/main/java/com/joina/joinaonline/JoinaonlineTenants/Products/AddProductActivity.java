package com.joina.joinaonline.JoinaonlineTenants.Products;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.Brand;
import com.joina.joinaonline.model.Category;
import com.joina.joinaonline.model.Discount;
import com.joina.joinaonline.model.ProductDto;
import com.joina.joinaonline.model.Promotion;
import com.joina.joinaonline.model.SubCategory;
import com.joina.joinaonline.model.Tax;
import com.joina.joinaonline.viewModel.BrandViewModel;
import com.joina.joinaonline.viewModel.CategoryViewModel;
import com.joina.joinaonline.viewModel.DiscountViewModel;
import com.joina.joinaonline.viewModel.ProductViewModel;
import com.joina.joinaonline.viewModel.PromotionViewModel;
import com.joina.joinaonline.viewModel.SubcategoryViewModel;
import com.joina.joinaonline.viewModel.TaxViewModel;
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

public class AddProductActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    ImageView addProductImage;
    EditText pname, pdescription, pprice,pbrand;
    AutoCompleteTextView edtbrand;
    private List<String> brandlist = new ArrayList<>();
    private List<String> categoylist = new ArrayList<>();
    private List<String> subCategorylist = new ArrayList<>();
    private List<String> discountList= new ArrayList<>();
    private List<String> promotionList = new ArrayList<>();
    private List<String> taxList = new ArrayList<>();
    private static final int GalleryPick = 1;
    private Uri ImageUri;

    private static final int READ_STORAGE_PERMISSION_REQUEST = 123;

    private static final int PICK_IMAGE_REQUEST = 1;

    public static final int RC_PHOTO_PICKER_PERM = 123;
    public static final int RC_FILE_PICKER_PERM = 321;
    private static final int CUSTOM_REQUEST_CODE = 532;
    private int MAX_ATTACHMENT_COUNT = 10;
    private ArrayList<Uri> photoPaths = new ArrayList<>();
    private ArrayList<Uri> docPaths = new ArrayList<>();
    private List<String> imagePaths = new ArrayList<>();

    private ImageView imageView, imageview2, imageview3;

    HorizontalScrollView scrollView;
    private ImageButton imageButton;
    private TextInputEditText etxtProductName, etxtProductDescription,etxtPrice,etxtQuantity;
    //    private TextInputEditText
    private ProductViewModel productViewModel;
    private BrandViewModel brandViewModel;
    private DiscountViewModel discountViewModel;
    private PromotionViewModel promotionViewModel;
    private TaxViewModel taxViewModel;
    private CategoryViewModel categoryViewModel;
    private SubcategoryViewModel subcategoryViewModel;
    private HorizontalScrollView horizontalScrollView;
    Button saveBtn;
    Spinner productStatusSpinner, categorySpinner, subCategorySpinner, discountSpinner, taxSpinner,promotionSpinner,brandSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        imageView = findViewById(R.id.imageView);
        imageview2 = findViewById(R.id.imageView2);
        imageview3 = findViewById(R.id.imageView3);
        imageButton = findViewById(R.id.addImageBtn);
        scrollView = findViewById(R.id.imagesHolder);
        discountSpinner = findViewById(R.id.spDiscount);
        taxSpinner = findViewById(R.id.spProductTax);
        promotionSpinner = findViewById(R.id.spProductPromotion);
        subCategorySpinner = findViewById(R.id.spSubcategory);
        categorySpinner = findViewById(R.id.spCategory);
        productStatusSpinner = findViewById(R.id.spProductStatus);
        brandSpinner = findViewById(R.id.spProductBrand);
        etxtProductName = findViewById(R.id.edt_product_name);
        etxtProductDescription = findViewById(R.id.edt_product_description);
        etxtPrice = findViewById(R.id.edt_price);
        etxtQuantity = findViewById(R.id.edt_quantity);
        saveBtn = findViewById(R.id.btnSaveProduct);
        horizontalScrollView = findViewById(R.id.imagesHolder);




        String[] stringarrayStatus = getResources().getStringArray(R.array.status);



        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        brandViewModel = ViewModelProviders.of(this).get(BrandViewModel.class);
        taxViewModel = ViewModelProviders.of(this).get(TaxViewModel.class);
        discountViewModel = ViewModelProviders.of(this).get(DiscountViewModel.class);
        promotionViewModel =ViewModelProviders.of(this).get(PromotionViewModel.class);
        brandViewModel = ViewModelProviders.of(this).get(BrandViewModel.class);
        subcategoryViewModel =ViewModelProviders.of(this).get(SubcategoryViewModel.class);
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);

        brandViewModel.getBrands();
        taxViewModel.getVendorTaxes(1L);
        discountViewModel.getVendorDiscount(1L);
        promotionViewModel.getVendorPromotion(1L);
        categoryViewModel.getCategories();
        subcategoryViewModel.getSubCategories();




        brandViewModel.getBrandResponseList().observe(this, new Observer<List<Brand>>() {
            @Override
            public void onChanged(List<Brand> brandResponses) {
                if(brandResponses != null){
                    for (Brand brands :brandResponses
                    ) {
                        brandlist.add(brands.getId()+" "+brands.getName());
                    }
                }else{

                    Toast.makeText(AddProductActivity.this, "No brands", Toast.LENGTH_LONG).show();
                }
            }
        });

        promotionViewModel.getPromotionResponseList().observe(this, new Observer<List<Promotion>>() {
            @Override
            public void onChanged(List<Promotion> promotionResponses) {
                if(!promotionResponses.isEmpty()){
                    for (int i=0; i<promotionResponses.size(); i++){
                        if(promotionResponses.get(i)!=null) {
                            promotionList.add(promotionResponses.get(i).getId().toString() + " " + promotionResponses.get(i).getName());
                        }
                    }

                }else{

                    Toast.makeText(AddProductActivity.this, "No Promotion", Toast.LENGTH_LONG).show();
                }
            }
        });

        taxViewModel.getTaxVendroResponseList().observe(this, new Observer<List<Tax>>() {
            @Override
            public void onChanged(List<Tax> taxResponses) {
                if(!taxResponses.isEmpty()){
                    for (int i=0; i<taxResponses.size(); i++){
                        if(taxResponses.get(i)!=null) {
                            taxList.add(taxResponses.get(i).getId().toString() + " " + taxResponses.get(i).getName());
                        }
                    }

                }else{

                    Toast.makeText(AddProductActivity.this, "No Tax", Toast.LENGTH_LONG).show();
                }
            }
        });

        discountViewModel.getDiscountResponseList().observe(this, new Observer<List<Discount>>() {
            @Override
            public void onChanged(List<Discount> discountResponses) {
                if(!discountResponses.isEmpty()){
                    for (int i=0; i<discountResponses.size(); i++){
                        if(discountResponses.get(i)!=null) {
                            discountList.add(discountResponses.get(i).getId().toString() + " " + discountResponses.get(i).getName());
//                            Toast.makeText(AddProductActivity.this, discountResponses.get(i).getId().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }else{

                    Toast.makeText(AddProductActivity.this, "No Discount", Toast.LENGTH_LONG).show();
                }
            }
        });


        subcategoryViewModel.getSubCategoryResponseList().observe(this, new Observer<List<SubCategory>>() {
            @Override
            public void onChanged(List<SubCategory> subCategoriesResponses) {
                if(subCategoriesResponses != null){
                    for (SubCategory subCategory :subCategoriesResponses) {
                        subCategorylist.add(subCategory.getId()+" "+subCategory.getName());
                    }
                }else{

                    Toast.makeText(AddProductActivity.this, "No Sub Category", Toast.LENGTH_LONG).show();
                }
            }
        });

//        categoryViewModel.getCategoryResponseList().observe(this, new Observer<List<Category>>() {
//            @Override
//            public void onChanged(List<Category> categoriesResponses) {
//                if(categoriesResponses != null){
//                    for (Category category :categoriesResponses) {
//                        categoylist.add(category.getId()+" "+category.getName());
//                    }
//                }else{
//
//                    Toast.makeText(AddProductActivity.this, "No Category", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                openPhotoPicker();
                imageView.setVisibility(View.VISIBLE);
                imageview2.setVisibility(View.VISIBLE);
                imageview3.setVisibility(View.VISIBLE);
                pickPhotoClicked();
            }
        });

        ArrayAdapter statusArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, stringarrayStatus);
        statusArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        productStatusSpinner.setAdapter(statusArray);
        statusArray.notifyDataSetChanged();

        categoylist.add("Choose Category");
        ArrayAdapter categoryArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categoylist);
        categoryArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categoryArray);
        categoryArray.notifyDataSetChanged();


        subCategorylist.add("Choose Sub Category");
        ArrayAdapter subCategoryArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, subCategorylist);
        subCategoryArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subCategorySpinner.setAdapter(subCategoryArray);
        subCategoryArray.notifyDataSetChanged();

        promotionList.add("Choose Promotion");
        ArrayAdapter promotionArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, promotionList);
        promotionArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        promotionSpinner.setAdapter(promotionArray);
        promotionArray.notifyDataSetChanged();

        brandlist.add("Choose Brand");
        ArrayAdapter brandArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brandlist);
        brandArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(brandArray);
        brandArray.notifyDataSetChanged();

        discountList.add("Choose Discount");
        ArrayAdapter discountArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, discountList);
        discountArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        discountSpinner.setAdapter(discountArray);
        discountArray.notifyDataSetChanged();


        taxList.add("Choose Tax");
        ArrayAdapter taxArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, taxList);
        taxArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        taxSpinner.setAdapter(taxArray);
        taxArray.notifyDataSetChanged();

//        saveProductObserver();
//        ErrorOnsaveProductObserver();
        ErrorDiscountObserver();
        ErrorTaxObserver();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct();
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

                scrollView.setVisibility(View.VISIBLE );
                imageButton.setVisibility(View.GONE);
                horizontalScrollView.setVisibility(View.VISIBLE);
                //ProductImages productImages = new ProductImages((List<MultipartBody.Part>) data);
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
//                    Toast.makeText(this, files[0].body().contentType().toString(), Toast.LENGTH_LONG).show();
                }

                productViewModel.uploadImages(files);
                brandViewModel.uploadbrand(files[0]);
                imageList();

                ErrorInitView();
                if(!photoPaths.isEmpty()){
                    Picasso.get().load(photoPaths.get(0)).into(imageView);
                    Picasso.get().load(photoPaths.get(2)).into(imageview3);
                    Picasso.get().load(photoPaths.get(1)).into(imageview2);
                }
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

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
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
                    .setMaxCount(3)
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
                    Toast.makeText(AddProductActivity.this, "no error"+error, Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(AddProductActivity.this,error +"we have error", Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    private void imageList() {

        productViewModel.getProductImagesObserver().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> images) {
                if(images == null) {
                    Toast.makeText(AddProductActivity.this, "failed to upload" , Toast.LENGTH_LONG).show();
                } else {
                    imagePaths = images;

                    Toast.makeText(AddProductActivity.this, images.get(0), Toast.LENGTH_LONG).show();


                }
            }
        });
    }

//    private void ErrorBrandViewModelResult() {
//
//        brandViewModel.getBrandImagesErrorObserver().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String error) {
//                if(error == null) {
//                    Toast.makeText(AddProductActivity.this, "no error"+error, Toast.LENGTH_LONG).show();
//                } else {
//
//                    Toast.makeText(AddProductActivity.this,error  , Toast.LENGTH_LONG).show();
//
//
//                }
//            }
//        });
//    }

//    private void brandViewModelResults() {
//
//        brandViewModel.getBrandImagesObserver().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String images) {
//                if(images == null) {
//                    Toast.makeText(AddProductActivity.this, "failed to upload" , Toast.LENGTH_LONG).show();
//                } else {
//
//                    Toast.makeText(AddProductActivity.this, images, Toast.LENGTH_LONG).show();
//
//
//                }
//            }
//        });
//    }

    private void saveProduct(){
        String brand = brandSpinner.getSelectedItem().toString();
        String promotion = brandSpinner.getSelectedItem().toString();
        String tax = taxSpinner.getSelectedItem().toString();
        String discount = discountSpinner.getSelectedItem().toString();
        String category = categorySpinner.getSelectedItem().toString();
        String subCategory = subCategorySpinner.getSelectedItem().toString();

        String brandId = "1";
        long brandid = Long.parseLong(brandId);
        String promotionId = "1";
        long promotionid = Long.parseLong(promotionId);  //*************************************
        String discountId = "1";
        String taxId = "1";
        String categoryId = "1";
        String subCategoryId = "1";
        String image1 = "No image" ;
        String image2="No image";
        String image3 = "No image";
        String status = productStatusSpinner.getSelectedItem().toString();
        double quantity = Double.parseDouble(etxtQuantity.getText().toString());
        double price = Double.parseDouble(etxtPrice.getText().toString());
        String productName = etxtProductName.getText().toString();
        String productDiscription = etxtProductDescription.getText().toString();


        if(promotion.equals("Choose Promotion")){
            Toast.makeText(this, "You didn't choose promotion", Toast.LENGTH_SHORT).show();
        }else{
            if (promotion.contains(" ")) {
                promotionId = promotion.substring(0, promotion.indexOf(" "));
                Toast.makeText(this, promotionId, Toast.LENGTH_LONG).show();
            }
        }
        if(brand.equals("Choose Brand")){
            Toast.makeText(this, "You didn't choose Brand", Toast.LENGTH_SHORT).show();
        }else{
            if (brand.contains(" ")) {
                brandId = brand.substring(0, brand.indexOf(" "));
                Toast.makeText(AddProductActivity.this, brandId, Toast.LENGTH_LONG).show();
            }
        }
        if (discount.equals("Choose Discount")){
            Toast.makeText(this, "You didn't choose Discount", Toast.LENGTH_SHORT).show();
        }else{
            if (discount.contains(" ")) {
                discountId = discount.substring(0, discount.indexOf(" "));
                Toast.makeText(AddProductActivity.this, discountId, Toast.LENGTH_LONG).show();
            }
        }

        if (tax.equals("Chose Tax")){
            Toast.makeText(this, "You didn't choose Tax", Toast.LENGTH_SHORT).show();
        }else{
            if (tax.contains(" ")) {
                taxId = tax.substring(0, tax.indexOf(" "));
                Toast.makeText(AddProductActivity.this, taxId, Toast.LENGTH_LONG).show();
            }
        }

        if (category.equals("Choose Category")){
            Toast.makeText(this, "You didn't choose Category", Toast.LENGTH_SHORT).show();
        }else{
            if (category.contains(" ")) {
                categoryId = category.substring(0, category.indexOf(" "));
                Toast.makeText(AddProductActivity.this, categoryId, Toast.LENGTH_LONG).show();
            }
        }

        if (subCategory.equals("Choose Sub Category")){
            Toast.makeText(this, "You didn't choose Sub Category", Toast.LENGTH_SHORT).show();
        }else{
            if (subCategory.contains(" ")) {
                subCategoryId = subCategoryId.substring(0, subCategory.indexOf(" "));
                Toast.makeText(AddProductActivity.this, subCategoryId, Toast.LENGTH_LONG).show();
            }
        }
        if(imagePaths.size()==3){
            image1 = "http://165.22.126.3:4100/media/"+imagePaths.get(0);
            image2 = "http://165.22.126.3:4100/media/"+imagePaths.get(1);
            image3 = "http://165.22.126.3:4100/media/"+imagePaths.get(2);
        }

        if(imagePaths.size()==2){
            image1 = "http://165.22.126.3:4100/media/"+imagePaths.get(0);
            image2 = "http://165.22.126.3:4100/media/"+imagePaths.get(1);
        }

        if(imagePaths.size()==1){
            image1 = "http://165.22.126.3:4100/media/"+imagePaths.get(0);
        }

        ProductDto productDto = new ProductDto(productName,productDiscription,price,quantity,image1,image2,image3,status,1L,promotionid,Long.parseLong(discountId),Long.parseLong(taxId),brandid,Long.parseLong(categoryId),Long.parseLong(subCategoryId));
        productViewModel.saveProduct(productDto);
        saveProductObserver();
        ErrorOnsaveProductObserver();

    }

    private void saveProductObserver() {

        productViewModel.getSaveProductResponse().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {
                if(response == null) {
                    Toast.makeText(AddProductActivity.this, "failed to save" , Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(AddProductActivity.this, response, Toast.LENGTH_LONG).show();


                }
            }
        });
    }
    private void ErrorOnsaveProductObserver() {

        productViewModel.getErrorOnSave().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {
                if(response == null) {
                    Toast.makeText(AddProductActivity.this, "No error" , Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(AddProductActivity.this,"error"+ response, Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    private void ErrorDiscountObserver() {

        discountViewModel.getErrorOnResponseList().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {
                if(response == null) {
                    Toast.makeText(AddProductActivity.this, "No error" , Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(AddProductActivity.this, response, Toast.LENGTH_LONG).show();


                }
            }
        });
    }


    private void ErrorTaxObserver() {

        taxViewModel.getErrorResponseTax().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {
                if(response == null) {
                    Toast.makeText(AddProductActivity.this, "No error" , Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(AddProductActivity.this, response, Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}