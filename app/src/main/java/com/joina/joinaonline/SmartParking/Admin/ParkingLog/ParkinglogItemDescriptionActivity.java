package com.joina.joinaonline.SmartParking.Admin.ParkingLog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class ParkinglogItemDescriptionActivity extends AppCompatActivity {

    ImageSlider footageImageSlider;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parkinglog_item_description);

//        <com.denzcoskun.imageslider.ImageSlider
//        android:id="@+id/footageImageSlider"
//        android:layout_width="match_parent"
//        android:layout_height="200dp"
//        android:layout_centerHorizontal="true"
//        android:alpha="0.8"
//        app:iss_auto_cycle="true"
//        app:iss_delay="2"
//        app:iss_error_image="@drawable/passingboomgate"
//        app:iss_period="3000"
//        app:iss_placeholder="@drawable/cs5" />

//        footageImageSlider = findViewById(R.id.footageImageSlider);

//        List<SlideModel> slideModelList = new ArrayList<>();
//        slideModelList.add(new SlideModel("@drawable/passingboomgate","Number Plate", ScaleTypes.FIT));
//        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/99-shopping-day-poster-banner-600w-2024061551.jpg", "Back", ScaleTypes.FIT));
//        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Left", ScaleTypes.FIT));
//        slideModelList.add(new SlideModel("https://www.shutterstock.com/shutterstock/photos/517779547/display_1500/stock-photo-empty-parking-lots-aerial-view-517779547.jpg", "right", ScaleTypes.FIT));
//
//        footageImageSlider.setImageList(slideModelList);


        String cardNumber = getIntent().getStringExtra("CARDNUMBER");
        String parkerName = getIntent().getStringExtra("NAME");
        String parkerMobile = getIntent().getStringExtra("PARKERMOBILE");
        String  parkerTimeIn= getIntent().getStringExtra("TIMEIN");
        String parkerTimeOut = getIntent().getStringExtra("TIMEOUT");
        String parkerDuration = getIntent().getStringExtra("DURATION");
       // int parkerImage = getIntent().getIntExtra("IMAGE", 0);

        TextView cardNumberTv = findViewById(R.id.cardNumber);
        TextView parkerNameTv = findViewById(R.id.parkerName);
        TextView parkerMobileTv = findViewById(R.id.parkerMobile);
        TextView parkerTimeInTv = findViewById(R.id.startDate);
        TextView parkerTimeOutTv = findViewById(R.id.endDate);
        TextView parkerDurationTv = findViewById(R.id.userStatus);


        cardNumberTv.setText(cardNumber);
        parkerNameTv.setText(parkerName);
        parkerMobileTv.setText(parkerMobile);
        parkerTimeInTv.setText(parkerTimeIn);
        parkerTimeOutTv.setText(parkerTimeOut);
        parkerDurationTv.setText(parkerDuration);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ParkinglogItemDescriptionActivity.this, ParkingLogActivity.class);
        startActivity(intent);
//        ParkingLogActivity filteredActivity = (ParkingLogActivity) getParent();
//        filteredActivity.clearFilteredData();
    }
}