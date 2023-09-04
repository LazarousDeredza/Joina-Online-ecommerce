package com.joina.joinaonline.JoinaonlineAdmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import com.joina.joinaonline.R;

public class DeliveryChargesActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextInputLayout fixedDeliveryCharge;
    RelativeLayout deliveryChargeByOrderValue,deliveryChargeByDistance;
    RadioButton free,fixed,order,distance;
    Spinner spinner;
    String[] distances = {"0-250 Kilometres","250-500 Kilometre",">500 Kilometres"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_charges);

//        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group);
////        free_delivery = (RadioButton)findViewById(R.id.free_delivery);
//        fixedDeliveryCharge = (TextInputLayout) findViewById(R.id.fixed_delivery_charge);
//        deliveryChargeByOrderValue = (RelativeLayout)findViewById(R.id.delivery_charge_by_order_value);
//        deliveryChargeByDistance = (RelativeLayout)findViewById(R.id.delivery_charge_by_distance);
//
//        fixed = (RadioButton)findViewById(R.id.fixed);
//        free = (RadioButton)findViewById(R.id.free);
//        order = (RadioButton)findViewById(R.id.order);
//        distance = (RadioButton)findViewById(R.id.distance);
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                switch(i) {
//                    case R.id.free:
//                        Toast.makeText(getApplicationContext(),"free",Toast.LENGTH_SHORT).show();
//                        fixedDeliveryCharge.setVisibility(View.GONE);
//                        deliveryChargeByOrderValue.setVisibility(View.GONE);
//                        deliveryChargeByDistance.setVisibility(View.GONE);
//                        break;
//                    case R.id.fixed:
//                        Toast.makeText(getApplicationContext(),"fixed",Toast.LENGTH_SHORT).show();
//                        fixedDeliveryCharge.setVisibility(View.VISIBLE);
//                        deliveryChargeByOrderValue.setVisibility(View.GONE);
//                        deliveryChargeByDistance.setVisibility(View.GONE);
//                        break;
//                    case R.id.order:
//                        Toast.makeText(getApplicationContext(),"order",Toast.LENGTH_SHORT).show();
//                        fixedDeliveryCharge.setVisibility(View.GONE);
//                        deliveryChargeByOrderValue.setVisibility(View.VISIBLE);
//                        deliveryChargeByDistance.setVisibility(View.GONE);
//                        break;
//                    case R.id.distance:
//                        Toast.makeText(getApplicationContext(),"distance",Toast.LENGTH_SHORT).show();
//                        fixedDeliveryCharge.setVisibility(View.GONE);
//                        deliveryChargeByOrderValue.setVisibility(View.GONE);
//                        deliveryChargeByDistance.setVisibility(View.VISIBLE);
//                        break;
//                    default:
//                        break;
//
//                }
//            }
//        });
//
////        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
////            @Override
////            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
////                switch(checkedId) {
////                    case R.id.free_delivery:
////                        Toast.makeText(getApplicationContext(),"blahblah",Toast.LENGTH_SHORT).show();
////                        break;
////                    case R.id.fixed_delivery_charge:
////                        Toast.makeText(getApplicationContext(),"blahblah",Toast.LENGTH_SHORT).show();
////                        break;
////                    case R.id.delivery_charge_by_order_value:
////                        Toast.makeText(getApplicationContext(),"blahblah",Toast.LENGTH_SHORT).show();
////                        break;
////                    case R.id.delivery_charge_by_distance:
////                        Toast.makeText(getApplicationContext(),"blahblah",Toast.LENGTH_SHORT).show();
////                        break;
////                    default:
////                        break;
////
////                }
////            }
////        });
//
//        spinner = findViewById(R.id.spinner1);
//
//        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,distances);
//        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinner.setAdapter(arrayAdapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),distances[position],Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

    }
}