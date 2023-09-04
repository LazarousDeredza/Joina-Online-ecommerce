package com.joina.joinaonline.Joinaonline.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.button.MaterialButton;

import com.joina.joinaonline.Joinaonline.Banking.BankingJOActivity;
import com.joina.joinaonline.Joinaonline.Electronics.ElectronicsJOActivity;
import com.joina.joinaonline.Joinaonline.Entertainment.EntertainmentJOActivity;
import com.joina.joinaonline.Joinaonline.EventsAndBooking.EventsAndBookingJOActivity;
import com.joina.joinaonline.Joinaonline.Fashion.FashionJOActivity;
import com.joina.joinaonline.Joinaonline.FoodandDrink.FoodandDrinkJOActivity;
import com.joina.joinaonline.Joinaonline.Groceries.GroceriesJOActivity;
import com.joina.joinaonline.Joinaonline.Medical.MedicalJOActivity;
import com.joina.joinaonline.Joinaonline.OnlineAuction.OnlineAuctionJOActivity;
import com.joina.joinaonline.Joinaonline.ProductActivity;
import com.joina.joinaonline.Joinaonline.adapter.Categories;

import com.joina.joinaonline.Joinaonline.adapter.Logo;
import com.joina.joinaonline.Joinaonline.adapter.LogoAdapter;
import com.joina.joinaonline.Joinaonline.adapter.master.CategoryAdapter;
import com.joina.joinaonline.Joinaonline.adapter.master.HomeSliderAdapter;
import com.joina.joinaonline.Joinaonline.adapter.master.NewProductAdapter;
import com.joina.joinaonline.Joinaonline.adapter.master.PopularProductAdapter;
import com.joina.joinaonline.Joinaonline.adapter.master.ProductAdapter;
import com.joina.joinaonline.Joinaonline.helper.Data;
import com.joina.joinaonline.MainActivity;
import com.joina.joinaonline.Parking.ParkingHomeActivity;
import com.joina.joinaonline.R;
import com.joina.joinaonline.Tenants.GuestUser.TenantsGuestApplicationFormActivity;
import com.joina.joinaonline.model.master.Category;
import com.joina.joinaonline.viewModel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class JoinaOnlineHomeFragment extends Fragment implements View.OnClickListener{
    MaterialButton offices, parking, medical, food_and_drink, banking, fashion, online_auction, groceries, entertainment, back, electronics,events_and_booking;
    View view;
    ImageSlider promotionsImageSlider, discoverImageSlider;
    ImageView image;
    private NavController navController;

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    Timer timer;
    int page_position = 0;
    Data data;
    private int dotscount;
    private ImageView[] dots;
    private List<Category> categoryList = new ArrayList<>();
    private RecyclerView recyclerView, nRecyclerView, pRecyclerView;
    private CategoryAdapter mAdapter;
    private NewProductAdapter nAdapter;
    private PopularProductAdapter pAdapter;
    private Integer[] images = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3, R.drawable.slider4, R.drawable.slider5};
    public JoinaOnlineHomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_jona_home, container, false);

        offices = view.findViewById(R.id.offices);
        parking = view.findViewById(R.id.parking);
//       parking  = view.findViewById(R.id.medical);
//        food_and_drink = view.findViewById(R.id.food_and_drink);
//        banking = view.findViewById(R.id.banking);
//        fashion = view.findViewById(R.id.fashion);
//        online_auction = view.findViewById(R.id.online_auction);
//        groceries = view.findViewById(R.id.groceries);
//        entertainment = view.findViewById(R.id.entertainment);
//        electronics = view.findViewById(R.id.electronics);
//        events_and_booking = view.findViewById(R.id.events_and_booking);
        image = view.findViewById(R.id.image);


//        offices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), TenantsGuestApplicationFormActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        medical.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), MedicalJOActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        food_and_drink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), FoodandDrinkJOActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        banking.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), BankingJOActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        fashion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), FashionJOActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        online_auction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), OnlineAuctionJOActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        groceries.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), GroceriesJOActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        entertainment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), EntertainmentJOActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        electronics.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), ElectronicsJOActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        events_and_booking.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), EventsAndBookingJOActivity.class);
//                startActivity(intent);
//            }
//        });

//        image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
//                Uri data = Uri.parse("mailto:?subject=" + "Joina Online Enquiry"+ "&body=" + "Joina Online Enquiries Team\n" + "&to=" + "winnet.n.chibisa@gmail.com");
//                mailIntent.setData(data);
//                startActivity(Intent.createChooser(mailIntent, "Send mail..."));
//            }
//        });



//        promotionsImageSlider = view.findViewById(R.id.imageSlider);
//
//        List<SlideModel> slideModelList = new ArrayList<>();
//        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/special-offer-final-sale-banner-600w-1387497926.jpg","PSMAS Promotion", ScaleTypes.FIT));
//        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/99-shopping-day-poster-banner-600w-2024061551.jpg", "Valentines Promotion", ScaleTypes.FIT));
//        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Hello Promo", ScaleTypes.FIT));
//        slideModelList.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Terrific Tuesday", ScaleTypes.FIT));
//
//        promotionsImageSlider.setImageList(slideModelList);

        discoverImageSlider = view.findViewById(R.id.imageSlider1);

        List<SlideModel> slideModelList1 = new ArrayList<>();
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/special-offer-final-sale-banner-600w-1387497926.jpg","PSMAS Promotion", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/99-shopping-day-poster-banner-600w-2024061551.jpg", "Valentines Promotion", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/mega-savings-discounts-50-off-600w-1927395932.jpg", "Hello Promo", ScaleTypes.FIT));
        slideModelList1.add(new SlideModel("https://image.shutterstock.com/image-vector/abstract-black-friday-banner-bright-600w-1216620865.jpg", "Terrific Tuesday", ScaleTypes.FIT));

        discoverImageSlider.setImageList(slideModelList1 );

        data = new Data();
        recyclerView = view.findViewById(R.id.category_rv);
        pRecyclerView = view.findViewById(R.id.popular_product_rv);
        nRecyclerView = view.findViewById(R.id.new_product_rv);

        mAdapter = new CategoryAdapter(data.getCategoryList(), getContext(), "Category");
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



//        mAdapter = new CategoryAdapter(data.getCategoryList(), getContext(), "Home");
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);


        nAdapter = new NewProductAdapter(data.getNewList(), getContext(), "Home");
        RecyclerView.LayoutManager nLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        nRecyclerView.setLayoutManager(nLayoutManager);
        nRecyclerView.setItemAnimator(new DefaultItemAnimator());
        nRecyclerView.setAdapter(nAdapter);

        pAdapter = new PopularProductAdapter(data.getPopularList(), getContext(), "Home");
        RecyclerView.LayoutManager pLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        pRecyclerView.setLayoutManager(pLayoutManager);
        pRecyclerView.setItemAnimator(new DefaultItemAnimator());
        pRecyclerView.setAdapter(pAdapter);


        timer = new Timer();
        viewPager = view.findViewById(R.id.viewPager);

        sliderDotspanel = view.findViewById(R.id.SliderDots);

        HomeSliderAdapter viewPagerAdapter = new HomeSliderAdapter(getContext(), images);

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        scheduleSlider();

        return view;
    }


    public void scheduleSlider() {

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == dotscount) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                viewPager.setCurrentItem(page_position, true);
            }
        };

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 500, 4000);
    }

    @Override
    public void onStop() {
        timer.cancel();
        super.onStop();
    }

    @Override
    public void onPause() {
        timer.cancel();
        super.onPause();
    }

    public void onLetsClicked(View view) {
        startActivity(new Intent(getContext(), MainActivity.class));
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button parking = view.findViewById(R.id.parking);
        navController = Navigation.findNavController(view);
        parking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_JoinaOnlineHomeFragment_to_smartParkingFragment);
            }
        });

        Button offices = view.findViewById(R.id.offices);
        navController = Navigation.findNavController(view);
        offices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_JoinaOnlineHomeFragment_to_officesFragment);
            }
        });
    }
    @Override
    public void onClick(View view) {

    }
}
