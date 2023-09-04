package com.joina.joinaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.gson.Gson;
import com.joina.joinaonline.Joinaonline.JoinaOnlineHomeActivity;
import com.joina.joinaonline.model.master.User;
import com.joina.joinaonline.util.localstorage.LocalStorage;
import com.sarnava.textwriter.TextWriter;

import java.util.ArrayList;
import java.util.List;

public class GetStartedActivity extends AppCompatActivity {

    Button startButton;
    ImageSlider imageSlider;

    //remove this
    User user;
    LocalStorage localStorage;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        imageSlider = findViewById(R.id.imageSlider);

        List<SlideModel> slideModelList = new ArrayList<>();
        slideModelList.add(new SlideModel(R.drawable.shopingmall, ScaleTypes.FIT));
        slideModelList.add(new SlideModel(R.drawable.offices, ScaleTypes.FIT));
        slideModelList.add(new SlideModel(R.drawable.parking , ScaleTypes.FIT));
        imageSlider.setImageList(slideModelList);

        //typeWritter
            TextWriter textWriter = findViewById(R.id.textWriter);

            textWriter
                    .setWidth(8)
                    .setDelay(30)
                    .setColor(R.color.primary)
                    .setConfig(TextWriter.Configuration.INTERMEDIATE)
                    .setSizeFactor(10f)
                    .setLetterSpacing(10f)
                    .setText("JOIN A CITY")
                    .setListener(new TextWriter.Listener() {
                        @Override
                        public void WritingFinished() {
                            // Start animation again
                            textWriter.startAnimation();
                        }
                    }).startAnimation();

            startButton = findViewById(R.id.startButton);
            startButton.setOnClickListener(new View.OnClickListener() {

                //remove this once user is working
                String getFullName = "Shawn Ka";
                String getEmailId = "shawn@gmail.com";
                String getMobileNumber="0785984235";
                String getPassword = "shawn";

                @Override
                public void onClick(View view) {

                    user = new User("1", getFullName, getEmailId, getMobileNumber, getPassword);
                    gson = new Gson();
                    String userString = gson.toJson(user);
                    localStorage = new LocalStorage(getApplicationContext());
                    localStorage.createUserLoginSession(userString);
                    //to this

                    Intent i = new Intent(GetStartedActivity.this, JoinaOnlineHomeActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }
}