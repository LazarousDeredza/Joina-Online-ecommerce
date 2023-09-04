package com.joina.joinaonline.Tenants.PropertyManager.PropertyManagement;

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

public class PropertyManagerPropertyManagementActivity extends AppCompatActivity {
  ArrayList<PropertyManagementModelClass> propertyManagementModelClassArrayList = new ArrayList<>();

  FloatingActionButton addFab;
  ExtendedFloatingActionButton addFab1, addFab2;
  Animation fabOpen, fabClose, rotateForward, rotateBackward;

  boolean isOpen = false;

  public PropertyManagerPropertyManagementActivity() {
    // Required empty public
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_property_manager_property_management);

    RecyclerView recyclerView = findViewById(R.id.propertyMgtRecyclerView);
    setUpPropertyManagementModelClassArrayList();

    PropertyManagementRecyclerViewAdapter adapter = new PropertyManagementRecyclerViewAdapter(this, propertyManagementModelClassArrayList);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    addFab = findViewById(R.id.addFab);
    addFab1 = findViewById(R.id.addFab1);
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

    addFab1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        animateFab();
//
        Intent intent = new Intent(getApplicationContext(), PropertyManagementAddCompartmentActivity.class);
        startActivity(intent);
      }
    });

    addFab2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        animateFab();
        Intent intent = new Intent(getApplicationContext(), PropertyManagementAddPropertyActivity.class);
        startActivity(intent);
      }
    });

  }
  private void setUpPropertyManagementModelClassArrayList(){
    String[] propertyName = getResources().getStringArray(R.array.propertyMgt_list_propertyName);
    String[] propertyAddress = getResources().getStringArray(R.array.propertyMgt_list_propertyAddress);
    String[] propertyDate = getResources().getStringArray(R.array.propertyMgt_list_propertyDate);

    for(int i=0;i<propertyName.length; i++){
      propertyManagementModelClassArrayList.add(new PropertyManagementModelClass(
              propertyName[i],propertyAddress[i],propertyDate[i]
      ));

    }
  };

  private void animateFab() {

    if (isOpen) {
      addFab.startAnimation(rotateForward);
      addFab1.startAnimation(fabClose);
      addFab2.startAnimation(fabClose);

      addFab1.setClickable(false);
      addFab2.setClickable(false);
      isOpen = false;
    } else {
      addFab.startAnimation(rotateBackward);
      addFab1.startAnimation(fabOpen);
      addFab2.startAnimation(fabOpen);

      addFab1.setClickable(true);
      addFab2.setClickable(true);
      isOpen = true;
    }
  }
}
