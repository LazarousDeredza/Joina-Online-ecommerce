package com.joina.joinaonline.JoinaonlineAdmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.joina.joinaonline.JoinaonlineTenants.Settings.ShopProfileActivity;
import com.joina.joinaonline.JoinaonlineTenants.fragments.SettingsFragment;
import com.joina.joinaonline.R;

import java.util.ArrayList;

public class JoinaAdminProfileManagementActivity extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<LinearPojo> arrayList;
    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joina_admin_profile_management);

//        toolbar=findViewById(R.id.toolbar);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(JoinaAdminProfileManagementActivity.this, JoinaAdminMainActivity.class);
//                startActivity(intent);
//            }
//        });

        linearListData();

        recyclerView = findViewById(R.id.linear_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterRecycler = new AdapterRecycler(this,arrayList);
        recyclerView.setAdapter(adapterRecycler);

    }

    private void linearListData() {
        arrayList = new ArrayList<LinearPojo>();

        arrayList.add(new LinearPojo("Edgars","Clothes","1"));
        arrayList.add(new LinearPojo("Posh","Clothes","2"));
        arrayList.add(new LinearPojo("Bata","Shoes","1"));
    }

}