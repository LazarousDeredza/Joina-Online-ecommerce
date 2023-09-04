package com.joina.joinaonline;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import com.joina.joinaonline.Joinaonline.JoinaOnlineHomeActivity;
import com.sarnava.textwriter.TextWriter;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


//        //typeWritter
//        TextWriter textWriter = findViewById(R.id.textWriter);
//
//        textWriter
//                .setWidth(8)
//                .setDelay(30)
//                .setColor(R.color.black)
//                .setConfig(TextWriter.Configuration.INTERMEDIATE)
//                .setSizeFactor(10f)
//                .setLetterSpacing(10f)
//                .setText("THE HEART OF THE CITY")
//                .setListener(new TextWriter.Listener() {
//            @Override
//            public void WritingFinished() {
//                //
//            }
//        }).startAnimation();

        //progressLoader
        ProgressBar progressBar = findViewById(R.id.progressBar);
        ObjectAnimator anim = ObjectAnimator.ofInt(progressBar, "progress", 0, 100);
        anim.setDuration(4000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();

//        TextView textView = findViewById(R.id.my_text_view);
//        TranslateAnimation animation = new TranslateAnimation(0, 1000, 0, 0);
//        animation.setDuration(5000);
//        animation.setRepeatCount(Animation.INFINITE);
//        animation.setRepeatMode(Animation.REVERSE);
//        textView.startAnimation(animation);
//        splashscreen timer

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(SplashScreenActivity.this, NavigationActivity.class);
                Intent intent = new Intent(SplashScreenActivity.this, JoinaOnlineHomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000); // 5 seconds delay
    }
}