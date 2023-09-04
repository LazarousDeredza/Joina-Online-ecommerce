package com.joina.joinaonline.JoinaonlineTenants.Settings.TaxDetails;

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
import com.joina.joinaonline.R;

import java.util.ArrayList;

public class TaxDetailsActivity extends AppCompatActivity {
    ArrayList<TaxListModelClass> taxListModelClassArrayList = new ArrayList<>();

    FloatingActionButton addFab;
    ExtendedFloatingActionButton addFab1, addFab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;

    boolean isOpen = false;

    public TaxDetailsActivity(){
        // Required empty public
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_details);

        RecyclerView recyclerView = findViewById(R.id.taxListRecycler);

        setUpTaxArrayList();

        TaxListRecyclerViewAdapter adapter = new TaxListRecyclerViewAdapter(this, taxListModelClassArrayList);
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
                Intent intent = new Intent(getApplicationContext(), AddTaxActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpTaxArrayList(){
        String[] taxName = getResources().getStringArray(R.array.taxName);
        String[] taxDescription = getResources().getStringArray(R.array.taxDescription);
        String[] taxPercentage = getResources().getStringArray(R.array.taxPercentage);

        for(int i=0;i<taxName.length; i++){
            taxListModelClassArrayList.add(new TaxListModelClass(
                    taxName[i],taxDescription[i],taxPercentage[i]
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