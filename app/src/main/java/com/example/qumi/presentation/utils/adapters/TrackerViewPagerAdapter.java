package com.example.qumi.presentation.utils.adapters;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.qumi.presentation.profile.components.SimOneFragment;
import com.example.qumi.presentation.profile.components.SimTwoFragment;

public class TrackerViewPagerAdapter extends FragmentStateAdapter {
    public TrackerViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:return new SimTwoFragment();
            default:return new SimOneFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
