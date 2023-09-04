package com.joina.joinaonline.JoinaonlineAdmin.CategoryRequests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.joina.joinaonline.JoinaonlineAdmin.JoinaAdminMainActivity;
import com.joina.joinaonline.JoinaonlineTenants.Settings.Discount.DiscountListModelClass;
import com.joina.joinaonline.JoinaonlineTenants.Settings.Discount.DiscountListRecyclerViewAdapter;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.Category;
import com.joina.joinaonline.viewModel.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class JoinaAdminCategoryRequestsActivity extends AppCompatActivity implements RecyclerViewInterface{
    //ArrayList<CategoryRequestModelClass> categoryRequestModelClassArrayList = new ArrayList<>();
    //private List<MovieModel> movieModelList;
    //private MovieListAdapter adapter;
    private CategoryViewModel categoryViewModel;
    List<Category> categoryRequestModelClassArrayList ;

    FloatingActionButton addFab;
    ExtendedFloatingActionButton addFab1, addFab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;

    boolean isOpen = false;

    public JoinaAdminCategoryRequestsActivity(){
        // Required empty public
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_requests_display_list);

        RecyclerView recyclerView = findViewById(R.id.categoryRequestListRecycler);

     //   setUpCategoryRequestList();

        CategoryRequestListRecyclerViewAdapter adapter = new CategoryRequestListRecyclerViewAdapter(this, categoryRequestModelClassArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        categoryViewModel.getCategoryObserver().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categoriesModels) {
                if(categoriesModels != null) {
                    categoryRequestModelClassArrayList = categoriesModels;
                    adapter.setCategoryRequestModelClassArrayList(categoriesModels);
//                    noresult.setVisibility(View.GONE);
                } else {
//                    noresult.setVisibility(View.VISIBLE);
                }
            }
        });
        categoryViewModel.getCategories();


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
                Intent intent = new Intent(getApplicationContext(), JoinaOnlineAdminAddSubcategoryActivity.class);
                startActivity(intent);
            }
        });

        addFab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                Intent intent = new Intent(getApplicationContext(), JoinaOnlineAdminAddCategoryActivity.class);
                startActivity(intent);
            }
        });

    }

//    private void setUpCategoryRequestList(){
//        String[] categoryName = getResources().getStringArray(R.array.categoryName);
//        String[] categoryDescription = getResources().getStringArray(R.array.categoryDescription);
//
//        for(int i=0;i<categoryName.length; i++){
//            categoryRequestModelClassArrayList.add(new CategoryRequestModelClass(
//                    categoryName[i],categoryDescription[i]
//            ));
//
//        }
//    };
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

    @Override
    public void onItemClick(int position) {

    }
}