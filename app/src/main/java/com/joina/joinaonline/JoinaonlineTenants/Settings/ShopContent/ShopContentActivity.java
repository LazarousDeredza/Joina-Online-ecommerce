package com.joina.joinaonline.JoinaonlineTenants.Settings.ShopContent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests.JoinaAdminCategoryRequestsActivity;
import com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests.JoinaOnlineAdminAddSubcategoryActivity;
import com.joina.joinaonline.JoinaonlineTenants.fragments.SettingsFragment;
import com.joina.joinaonline.R;

public class ShopContentActivity extends AppCompatActivity {

    MaterialButton aboutShop,privacy_policy,terms_and_conditions;
    RelativeLayout aboutShopRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_content);

        aboutShop = findViewById(R.id.about_shop);
        aboutShopRL = findViewById(R.id.aboutShopRL);
        privacy_policy = findViewById(R.id.privacy_policy);
        terms_and_conditions = findViewById(R.id.terms_and_conditions);


        aboutShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutShop.setBackgroundColor(getResources().getColor(R.color.white));
                aboutShopRL.setVisibility(view.VISIBLE);
            }
        });

        privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aboutShopRL.setVisibility(view.GONE);
                Intent intent = new Intent(ShopContentActivity.this, PrivacyPolicyActivity.class);
                startActivity(intent);

            }
        });

        terms_and_conditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutShopRL.setVisibility(view.GONE);
                Intent intent = new Intent(ShopContentActivity.this, TermsAndConditionsActivity.class);
                startActivity(intent);
            }
        });
    }
}