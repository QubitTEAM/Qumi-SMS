package com.example.qumi.presentation.core;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qumi.presentation.utils.adapters.ViewPagerAdapter;
import com.example.qumi.R;
import com.google.android.material.tabs.TabLayout;
import com.rahimlis.badgedtablayout.BadgedTabLayout;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View view;
    private BadgedTabLayout badgedTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter viewPagerAdapter;

    public HomeFragment() {
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home, container, false);
        linkWithId();
        initializeObjects();
        setUpBagedTabLayout();
        setUpViewPager();
        return view;
    }

    private void setUpViewPager() {
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                badgedTabLayout.getTabAt(position).select();
                getActivity().findViewById(R.id.img_btn_more_options).setVisibility(View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpBagedTabLayout() {

        badgedTabLayout.setBadgeText(0, "10");
        badgedTabLayout.setBadgeText(1, "+99");
        badgedTabLayout.setBadgeText(2, null);
        badgedTabLayout.setBadgeText(3, "+99");

        badgedTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mViewPager.setCurrentItem(tab.getPosition());
                    }
                }, 100);
                getActivity().findViewById(R.id.img_btn_more_options).setVisibility(View.GONE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mViewPager.setCurrentItem(tab.getPosition());
                    }
                }, 200);
            }
        });

    }

    private void initializeObjects() {
        viewPagerAdapter = new ViewPagerAdapter(getParentFragmentManager());
    }

    private void linkWithId() {
        badgedTabLayout = (BadgedTabLayout) view.findViewById(R.id.badged_tab_layout);
        mViewPager = view.findViewById(R.id.vp_fragment_container);
    }
}