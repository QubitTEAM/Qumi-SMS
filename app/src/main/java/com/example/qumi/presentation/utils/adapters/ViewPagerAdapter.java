package com.example.qumi.presentation.utils.adapters;


import com.example.qumi.presentation.messages.AllChatsFragment;
import com.example.qumi.presentation.messages.ServiceFragment;
import com.example.qumi.presentation.messages.SocialFragment;
import com.example.qumi.presentation.messages.SpamFragment;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new SocialFragment();
            case 2:
                return new ServiceFragment();
            case 3:
                return new SpamFragment();
            default:return new AllChatsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
