package com.joina.joinaonline.JoinaonlineTenants.Settings.Discount;

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
import com.joina.joinaonline.JoinaonlineTenants.Settings.TaxDetails.AddTaxActivity;
import com.joina.joinaonline.JoinaonlineTenants.Settings.TaxDetails.TaxListModelClass;
import com.joina.joinaonline.JoinaonlineTenants.Settings.TaxDetails.TaxListRecyclerViewAdapter;
import com.joina.joinaonline.R;

import java.util.ArrayList;

public class DiscountActivity extends AppCompatActivity {
   ArrayList<DiscountListModelClass> discountListModelClassArrayList = new ArrayList<>();

    FloatingActionButton addFab;
    ExtendedFloatingActionButton addFab1, addFab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;

    boolean isOpen = false;

    public DiscountActivity(){
        // Required empty public
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        RecyclerView recyclerView = findViewById(R.id.discountListRecycler);

        setUpDiscountList();

        DiscountListRecyclerViewAdapter adapter = new DiscountListRecyclerViewAdapter(this, discountListModelClassArrayList);
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
                Intent intent = new Intent(getApplicationContext(), AddDiscountActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpDiscountList(){
        String[] discName = getResources().getStringArray(R.array.discName);
        String[] discPercentage = getResources().getStringArray(R.array.discPercentage);
        String[] discType = getResources().getStringArray(R.array.discType);
        String[] startDate = getResources().getStringArray(R.array.startDate);
        String[] endDate = getResources().getStringArray(R.array.endDate);

        for(int i=0;i<discName.length; i++){
            discountListModelClassArrayList.add(new DiscountListModelClass(
                    discName[i],discPercentage[i], discType[i], startDate[i], endDate[i]
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






