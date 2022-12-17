package com.example.qumi.presentation.utils.adapters;

import com.example.qumi.presentation.messages.AllChatsFragment;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapterForNewConservation extends FragmentPagerAdapter {

    public ViewPagerAdapterForNewConservation(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new AllChatsFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
