package com.joina.joinaonline.JoinaonlineTenants.Settings.Promotions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.joina.joinaonline.JoinaonlineTenants.Settings.Discount.AddDiscountActivity;
import com.joina.joinaonline.JoinaonlineTenants.Settings.Discount.DiscountListModelClass;
import com.joina.joinaonline.JoinaonlineTenants.Settings.Discount.DiscountListRecyclerViewAdapter;
import com.joina.joinaonline.R;

import java.util.ArrayList;

public class PromotionsActivity extends AppCompatActivity {
    ArrayList<PromotionsListModelClass> promotionsListModelClassArrayList = new ArrayList<>();

    FloatingActionButton addFab;
    ExtendedFloatingActionButton addFab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;

    boolean isOpen = false;

    public PromotionsActivity(){
        // Required empty public
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);

        RecyclerView recyclerView = findViewById(R.id.promotionsListRecycler);

        setUpPromotionsList();

        PromotionsListRecyclerViewAdapter adapter = new PromotionsListRecyclerViewAdapter(this, promotionsListModelClassArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        addFab = findViewById(R.id.addFab);
        addFab2 = findViewById(R.id.addFab2);

        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });


        addFab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Intent intent = new Intent(getApplicationContext(), AddPromotionsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpPromotionsList(){
        String[] promotionName = getResources().getStringArray(R.array.promotionName);
        String[] promotionPercentage = getResources().getStringArray(R.array.promotionPercentage);
        String[] promotionStatus = getResources().getStringArray(R.array.promotionStatus);
        String[] promoStartDate = getResources().getStringArray(R.array.promoStartDate);
        String[] promoEndDate = getResources().getStringArray(R.array.promoEndDate);

        for(int i=0;i<promotionName.length; i++){
            promotionsListModelClassArrayList.add(new PromotionsListModelClass(
                    promotionName[i],promotionPercentage[i], promotionStatus[i], promoStartDate[i], promoEndDate[i]
            ));

        }
    };

    private void animateFab() {

        if (isOpen) {
            addFab.startAnimation(rotateForward);
            addFab2.startAnimation(fabClose);


            addFab2.setClickable(false);
            isOpen = false;
        } else {
            addFab.startAnimation(rotateBackward);
            addFab2.startAnimation(fabOpen);

            addFab2.setClickable(true);
            isOpen = true;
        }
    }

}