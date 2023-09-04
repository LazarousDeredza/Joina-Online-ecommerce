package com.joina.joinaonline.JoinaonlineTenants.Settings.Promotions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.joina.joinaonline.JoinaonlineTenants.Settings.Discount.AddDiscountActivity;
import com.joina.joinaonline.R;
import pub.devrel.easypermissions.AfterPermissionGranted;

import java.util.Calendar;
import java.util.Date;

import pub.devrel.easypermissions.EasyPermissions;

public class AddPromotionsActivity extends AppCompatActivity  {
    private DatePickerDialog picker;
    private DatePickerDialog picker2;
    private TextInputEditText endDate;
    private TextInputEditText startDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promotions);

        endDate = (TextInputEditText)findViewById(R.id.endDate);
        startDate = (TextInputEditText)findViewById(R.id.startDate);

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                // date picker dialog
                picker = new DatePickerDialog(AddPromotionsActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                cldr.set(year, monthOfYear, dayOfMonth);

                                Date current = cldr.getTime();
                                int diff1 =new Date().compareTo(current);

                                if(diff1<0){
                                    Toast.makeText(AddPromotionsActivity.this, "Please select a valid date",  Toast.LENGTH_LONG).show();
                                    return;
                                }
                                else{
                                    startDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                }

                            }
                        }, year, month, day);
                picker.show();
            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr2 = Calendar.getInstance();
                int day = cldr2.get(Calendar.DAY_OF_MONTH);
                int month = cldr2.get(Calendar.MONTH);
                int year = cldr2.get(Calendar.YEAR);

                // date picker dialog
                picker2 = new DatePickerDialog(AddPromotionsActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                cldr2.set(year, monthOfYear, dayOfMonth);

                                Date current = cldr2.getTime();
                                int diff2 =new Date().compareTo(current);

                                if(diff2<0){
                                    Toast.makeText(AddPromotionsActivity.this, "Please select a valid date",  Toast.LENGTH_LONG).show();
                                    return;
                                }
                                else{
                                    endDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                }

                            }
                        }, year, month, day);
                picker2.show();
            }
        });

    }
}