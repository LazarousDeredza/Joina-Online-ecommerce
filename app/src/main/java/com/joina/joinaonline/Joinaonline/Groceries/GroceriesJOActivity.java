package com.joina.joinaonline.Joinaonline.Groceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.joina.joinaonline.Joinaonline.ListStoresActivities.GroceriesListStoresActivity;
import com.joina.joinaonline.Joinaonline.adapter.Categories;
import com.joina.joinaonline.Joinaonline.adapter.CategoryAdapter;
import com.joina.joinaonline.Joinaonline.adapter.Product;
import com.joina.joinaonline.Joinaonline.adapter.ProductAdapter;
import com.joina.joinaonline.Joinaonline.StorefrontLayout;
import com.joina.joinaonline.JoinaonlineTenants.Products.AddProductActivity;
import com.joina.joinaonline.ProductAdapter2;
import com.joina.joinaonline.R;
import com.joina.joinaonline.model.ProductDto;
import com.joina.joinaonline.viewModel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class GroceriesJOActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, productRecycler;
    CategoryAdapter categoryAdapter;
    ProductAdapter2 productAdapter;
    TextView seeAll;

    List<Categories> productCategoryList = new ArrayList<>();
    List<ProductDto> productList = new ArrayList<>();

    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries_joactivity);

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        List<SlideModel> slideModelList = new ArrayList<>();
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/special-offer-final-sale-banner-600w-1387497926.jpg","PSMAS Promotion", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/99-shopping-day-poster-banner-600w-2024061551.jpg", "Valentines Promotion", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Hello Promo", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Terrific Tuesday", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/special-offer-final-sale-banner-600w-1387497926.jpg","PSMAS Promotion", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/99-shopping-day-poster-banner-600w-2024061551.jpg", "Valentines Promotion", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Hello Promo", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Terrific Tuesday", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/special-offer-final-sale-banner-600w-1387497926.jpg","PSMAS Promotion", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/99-shopping-day-poster-banner-600w-2024061551.jpg", "Valentines Promotion", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Hello Promo", ScaleTypes.FIT));
        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Terrific Tuesday", ScaleTypes.FIT));

        imageSlider.setImageList(slideModelList);

        seeAll = findViewById(R.id.seeAll);
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GroceriesJOActivity.this, GroceriesListStoresActivity.class);
                startActivity(intent);
            }
        });

        categoryRecycler = findViewById(R.id.categories_list);

        productCategoryList.add(new Categories(1, "Beverages"));
        productCategoryList.add(new Categories(2, "Bread/Bakery"));
        productCategoryList.add(new Categories(3, "Canned/Jarred Goods"));
        productCategoryList.add(new Categories(4, "Dairy"));
        productCategoryList.add(new Categories(5, "Meat"));
        productCategoryList.add(new Categories(6, "Other"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(GroceriesJOActivity.this, RecyclerView.HORIZONTAL, false);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(GroceriesJOActivity.this, productCategoryList);
        categoryRecycler.setAdapter(categoryAdapter);
//
//        try {

        productRecycler = findViewById(R.id.products_list);

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getProductObserver().observe(this, new Observer<List<ProductDto>>() {

//            Toast.makeText(GroceriesJOActivity.this, "WINNIE ! This is an observer test toast, bro !", Toast.LENGTH_SHORT).show();

            @Override
            public void onChanged(List<ProductDto> products) {
                if(products != null) {
                    productList = products;
                    productAdapter.setProductList(products);

                    Toast.makeText(GroceriesJOActivity.this, "List is not EMPTY !",Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(GroceriesJOActivity.this, "List is EMPTY !",Toast.LENGTH_SHORT).show();
                }
            }
        });
        productViewModel.getProducts();
        Toast.makeText(GroceriesJOActivity.this, "WINNIE ! It worked but something went wrong!",Toast.LENGTH_SHORT).show();

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(GroceriesJOActivity.this, RecyclerView.HORIZONTAL, false);
        productRecycler.setLayoutManager(layoutManager1);
        productAdapter = new ProductAdapter2(GroceriesJOActivity.this, productList);
        productRecycler.setAdapter(productAdapter);



//        }
//        catch (Exception e) {
//
//            Toast.makeText(GroceriesJOActivity.this, "Didnt work, something went wrong WINNET!",Toast.LENGTH_SHORT).show();
//
//        }




//        productList.add(new Product(1, "Proton Bread","brand", "ZWL 90", R.drawable.bread));
//        productList.add(new Product(2, "White Sugar","brand","ZWL 217", R.drawable.sugar));
//        productList.add(new Product(3, "Potatoes","brand", "ZWL 990", R.drawable.potatoes));
//        productList.add(new Product(4, "Knorrox","brand", "ZWL 359", R.drawable.knorrox));
//        productList.add(new Product(5, "Spuds","brand", "ZWL 199", R.drawable.spuds));
//
//        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(GroceriesJOActivity.this, RecyclerView.HORIZONTAL, false);
//        productRecycler.setLayoutManager(layoutManager2);
//        productAdapter = new ProductAdapter(GroceriesJOActivity.this, productList);
//        productRecycler.setAdapter(productAdapter);

    }


    //***************************************************************************
    public void viewDetails(int pos) {

        Intent intent = new Intent(this, StorefrontLayout.class);
        intent.putExtra("name",productList.get(pos).getName());
        intent.putExtra("floor",productList.get(pos).getUnit_price());
        intent.putExtra("image",productList.get(pos).getImage1());
        startActivity(intent);

    }
}