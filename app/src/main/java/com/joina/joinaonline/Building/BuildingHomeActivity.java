package com.joina.joinaonline.Building;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.joina.joinaonline.R;

import java.util.ArrayList;
import java.util.List;

public class BuildingHomeActivity extends AppCompatActivity {

    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_home);

        imageSlider = findViewById(R.id.imageSlider);

        List<SlideModel> slideModelList = new ArrayList<>();
        slideModelList.add(new SlideModel(R.drawable.bread, ScaleTypes.FIT));
        slideModelList.add(new SlideModel(R.drawable.spuds, ScaleTypes.FIT));
        slideModelList.add(new SlideModel(R.drawable.knorrox, ScaleTypes.FIT));
        imageSlider.setImageList(slideModelList);
    }
}