package com.example.myapplication.CustomAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.Fragments.DisplayCategoryFragment;
import com.example.myapplication.Fragments.DisplayHomeFragment;
import com.example.myapplication.Fragments.DisplayStaffFragment;
import com.example.myapplication.Fragments.DisplayStatisticFragment;
import com.example.myapplication.Fragments.DisplayTableFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
            {
                return new DisplayHomeFragment();
            }
            case 1:
            {
                return new DisplayCategoryFragment();
            }
            case 2:
            {
                return new DisplayTableFragment();
            }
            case 3:
            {
                return new DisplayStaffFragment();
            }
            case 4:
            {
                return new DisplayStatisticFragment();
            }
            default:
                return new DisplayHomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

}
