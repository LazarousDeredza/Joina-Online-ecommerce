package com.joina.joinaonline.JoinaonlineTenants.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.joina.joinaonline.JoinaonlineTenants.PaymentsOverview;
import com.joina.joinaonline.JoinaonlineTenants.Settings.Discount.DiscountActivity;
import com.joina.joinaonline.JoinaonlineTenants.Settings.Promotions.PromotionsActivity;
import com.joina.joinaonline.JoinaonlineTenants.Settings.SellerAccountActivity;
import com.joina.joinaonline.JoinaonlineTenants.Settings.ShippingAndDeliveryActivity;
import com.joina.joinaonline.JoinaonlineTenants.Settings.ShopContent.ShopContentActivity;
import com.joina.joinaonline.JoinaonlineTenants.Settings.TaxDetails.TaxDetailsActivity;
import com.joina.joinaonline.R;


public class SettingsFragment extends Fragment implements View.OnClickListener {

    View view;
    MaterialButton payments,shop_content,seller_account,shipping_and_delivery,tax_details,discount,promotions;
    TextView title;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_settings_joina_tenants, container, false);

        title =view.findViewById(R.id.title);


        payments=view.findViewById(R.id.payments);
        payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PaymentsOverview.class);
                startActivity(intent);
            }
        });

        shop_content=view.findViewById(R.id.shop_content);
        shop_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShopContentActivity.class);
                startActivity(intent);
            }
        });

        seller_account=view.findViewById(R.id.seller_account);
        seller_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SellerAccountActivity.class);
                startActivity(intent);
            }
        });

        shipping_and_delivery=view.findViewById(R.id.shipping_and_delivery);
        shipping_and_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShippingAndDeliveryActivity.class);
                startActivity(intent);
            }
        });
        tax_details=view.findViewById(R.id.tax_details);
        tax_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TaxDetailsActivity.class);
                startActivity(intent);
            }
        });
        discount=view.findViewById(R.id.discount);
        discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DiscountActivity.class);
                startActivity(intent);
            }
        });

        promotions=view.findViewById(R.id.promotions);
        promotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PromotionsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}