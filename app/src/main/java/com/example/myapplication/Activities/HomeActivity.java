package com.example.myapplication.Activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.CustomAdapter.ViewPagerAdapter;
import com.example.myapplication.Fragments.DisplayCategoryFragment;
import com.example.myapplication.Fragments.DisplayHomeFragment;
import com.example.myapplication.Fragments.DisplayStaffFragment;
import com.example.myapplication.Fragments.DisplayStatisticFragment;
import com.example.myapplication.Fragments.DisplayTableFragment;
import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity     implements NavigationView.OnNavigationItemSelectedListener{

    MenuItem selectedFeature, selectedManager;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    TextView TXT_menu_tennv;
    int maquyen = 0;
    SharedPreferences sharedPreferences;
//    TabLayout tabLayout;
//    ViewPager viewPager2;
//    ViewPagerAdapter viewPagerAdapter;
    private int[] tabIcons = {
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_home_24,
    };
    public int getMaquyen() {
        return maquyen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        //region thuộc tính bên view

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view_trangchu);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        View view = navigationView.getHeaderView(0);
        TXT_menu_tennv = (TextView) view.findViewById(R.id.txt_menu_tennv);
//        tabLayout = findViewById(R.id.tabLayout);
//        viewPager2 = findViewById(R.id.viewPager);
        //endregion

        //xử lý toolbar và navigation

        setSupportActionBar(toolbar); //tạo toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //tạo nút mở navigation

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar
                ,R.string.opentoggle,R.string.closetoggle){
            @Override
            public void onDrawerOpened(View drawerView) {    super.onDrawerOpened(drawerView); }

            @Override
            public void onDrawerClosed(View drawerView) {    super.onDrawerClosed(drawerView); }
        };
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Tụ động gán tên nv đăng nhập qua Extras

        Intent intent = getIntent();
        String tendn = intent.getStringExtra("tendn");
        TXT_menu_tennv.setText( "Xin chào " + tendn +" !!");

        //lấy file share prefer

        sharedPreferences = getSharedPreferences("luuquyen", Context.MODE_PRIVATE);
        maquyen = sharedPreferences.getInt("maquyen",0);

        //hiện thị fragment home mặc định

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction tranDisplayHome = fragmentManager.beginTransaction();
        DisplayHomeFragment displayHomeFragment = new DisplayHomeFragment();
        tranDisplayHome.replace(R.id.contentView, displayHomeFragment);
        tranDisplayHome.commit();
        navigationView.setCheckedItem(R.id.nav_home);
//        tabLayout.selectTab(tabLayout.getTabAt(0));
//        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        viewPager2.setAdapter(viewPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager2);
//        setTabIcons();
    }
//    private void setTabIcons()
//    {
//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
//        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
//        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
//    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_home:
                //hiển thị tương ứng trên navigation
                FragmentTransaction tranDisplayHome = fragmentManager.beginTransaction();
                DisplayHomeFragment displayHomeFragment = new DisplayHomeFragment();
                tranDisplayHome.replace(R.id.contentView,displayHomeFragment);
                tranDisplayHome.commit();
                navigationView.setCheckedItem(item.getItemId());
                drawerLayout.closeDrawers();
                break;

            case R.id.nav_statistic:
                //hiển thị tương ứng trên navigation
                FragmentTransaction tranDisplayStatistic = fragmentManager.beginTransaction();
                DisplayStatisticFragment displayStatisticFragment = new DisplayStatisticFragment();
                tranDisplayStatistic.replace(R.id.contentView,displayStatisticFragment);
                tranDisplayStatistic.commit();
                navigationView.setCheckedItem(item.getItemId());
                drawerLayout.closeDrawers();
                break;

            case R.id.nav_table:
                //hiển thị tương ứng trên navigation
                FragmentTransaction tranDisplayTable = fragmentManager.beginTransaction();
                DisplayTableFragment displayTableFragment = new DisplayTableFragment();
                tranDisplayTable.replace(R.id.contentView,displayTableFragment);
                tranDisplayTable.commit();
                navigationView.setCheckedItem(item.getItemId());
                drawerLayout.closeDrawers();
                break;

            case R.id.nav_category:
                //hiển thị tương ứng trên navigation
                FragmentTransaction tranDisplayMenu = fragmentManager.beginTransaction();
                DisplayCategoryFragment displayCategoryFragment = new DisplayCategoryFragment();
                tranDisplayMenu.replace(R.id.contentView, displayCategoryFragment);
                tranDisplayMenu.commit();
                navigationView.setCheckedItem(item.getItemId());
                drawerLayout.closeDrawers();

                break;

            case R.id.nav_staff:
                if(maquyen == 1){
                    //hiển thị tương ứng trên navigation
                    FragmentTransaction tranDisplayStaff = fragmentManager.beginTransaction();
                    DisplayStaffFragment displayStaffFragment = new DisplayStaffFragment();
                    tranDisplayStaff.replace(R.id.contentView,displayStaffFragment);
                    tranDisplayStaff.commit();
                    navigationView.setCheckedItem(item.getItemId());
                    drawerLayout.closeDrawers();
                }else {
                    Toast.makeText(getApplicationContext(),"Bạn không có quyền truy cập",Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.nav_logout:
                //gọi activity ra trang welcome
                Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }

}