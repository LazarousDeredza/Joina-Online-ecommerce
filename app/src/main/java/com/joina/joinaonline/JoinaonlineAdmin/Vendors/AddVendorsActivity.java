package com.joina.joinaonline.JoinaonlineAdmin.Vendors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests.JoinaOnlineAdminAddCategoryActivity;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.Category;
import com.joina.joinaonline.model.Vendor;
import com.joina.joinaonline.viewModel.CategoryViewModel;
import com.joina.joinaonline.viewModel.VendorsModelView;

public class AddVendorsActivity extends AppCompatActivity {

    TextInputEditText business_Name, pass_word, e_mail, tele_phone, mo_bile;
    Button btnAddVendors;
    private VendorsModelView vendorsModelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vendors);

        business_Name = findViewById(R.id.business_Name);
        pass_word = findViewById(R.id.pass_word);
        e_mail = findViewById(R.id.e_Mail);
        tele_phone = findViewById(R.id.tele_Phone);
        mo_bile = findViewById(R.id.mobile_Number);
        btnAddVendors = findViewById(R.id.btnAddVendor);
        vendorsModelView = ViewModelProviders.of(this).get(VendorsModelView.class);

        btnAddVendors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                String name = business_Name.getText().toString();
                String password = pass_word.getText().toString();
                String email = e_mail.getText().toString();
                String telephone = tele_phone.getText().toString();
                String mobile = mo_bile.getText().toString();

               // Vendors vendors = new Vendors(name, password, email ,telephone, mobile);

                //vendorsModelView.addVendor(vendors);

                createVendorObserver();
                //errorCategoryObserver();
            }
        });
    }

    private void createVendorObserver(){
        vendorsModelView.getCreateAddVendors().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String response) {

                if(response == null){
                    Toast.makeText(AddVendorsActivity.this, "Failed", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddVendorsActivity.this, "Vendor Added"  +response, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}