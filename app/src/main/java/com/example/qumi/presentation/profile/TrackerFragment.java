package com.example.qumi.presentation.profile;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qumi.presentation.utils.adapters.TrackerViewPagerAdapter;
import com.example.qumi.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class TrackerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View view;
    private TrackerViewPagerAdapter trackerViewPagerAdapter;
    private ViewPager2 viewPager2Tracker;
    private TextView sim1;
    private TextView sim2;

    GraphView graphView;
    LineGraphSeries<DataPoint> lineGraphSeries;
    LineGraphSeries<DataPoint> lineGraphSeries2;

    public TrackerFragment() {
    }

    public static TrackerFragment newInstance(String param1, String param2) {
        TrackerFragment fragment = new TrackerFragment();
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
        view = inflater.inflate(R.layout.fragment_tracker, container, false);
        linkWithId();
        initialObjects();
        setUpViewPager();
        sim1_sim2OnClick();

        lineGraphSeries.appendData(new DataPoint(0, 0), true, 500);
        lineGraphSeries.appendData(new DataPoint(1, 1), true, 500);
        lineGraphSeries.appendData(new DataPoint(2, 2), true, 500);
        lineGraphSeries.appendData(new DataPoint(3, 10), true, 500);
        lineGraphSeries.appendData(new DataPoint(4, 20), true, 500);
        lineGraphSeries.appendData(new DataPoint(5, 0), true, 500);
        lineGraphSeries.appendData(new DataPoint(6, 50), true, 500);
        lineGraphSeries.appendData(new DataPoint(7, 22), true, 500);

        lineGraphSeries.setThickness(10);
        lineGraphSeries.setColor(Color.parseColor("#002FBA"));

        lineGraphSeries2.appendData(new DataPoint(0, 0), true, 500);
        lineGraphSeries2.appendData(new DataPoint(1, 42), true, 500);
        lineGraphSeries2.appendData(new DataPoint(2, 25), true, 500);
        lineGraphSeries2.appendData(new DataPoint(3, 100), true, 500);
        lineGraphSeries2.appendData(new DataPoint(4, 20), true, 500);
        lineGraphSeries2.appendData(new DataPoint(5, 102), true, 500);
        lineGraphSeries2.appendData(new DataPoint(6, 350), true, 500);
        lineGraphSeries2.appendData(new DataPoint(7, 22), true, 500);

        lineGraphSeries2.setThickness(10);
        lineGraphSeries2.setColor(Color.parseColor("#1CBC00"));

        graphView.addSeries(lineGraphSeries);
        graphView.addSeries(lineGraphSeries2);


        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(0.0);
        graphView.getViewport().setMaxX(7);

        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setMinY(0.0);
        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setScalable(true);


        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"0","Sun", "Mon", "Tus", "Wen", "Thu", "Fri", "Sat"});
        graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        graphView.getGridLabelRenderer().setGridColor(getResources().getColor(R.color.darkThemePrimaryText));
        graphView.getGridLabelRenderer().setHorizontalLabelsColor(getResources().getColor(R.color.darkThemePrimaryText));
        graphView.getGridLabelRenderer().setVerticalLabelsColor(getResources().getColor(R.color.darkThemePrimaryText));

        return view;
    }

    private void sim1_sim2OnClick() {
        sim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2Tracker.setCurrentItem(0);
            }
        });
        sim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2Tracker.setCurrentItem(1);
            }
        });

    }

    private void setUpViewPager() {
        viewPager2Tracker.setAdapter(trackerViewPagerAdapter);
        viewPager2Tracker.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        sim1.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.sim_tracker_dark_bg, getContext().getTheme()));
                        sim2.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.unselected_sim_tracker_dark_bg, getContext().getTheme()));
                        sim1.setTextColor(Color.parseColor("#EEF4FC"));
                        sim2.setTextColor(Color.parseColor("#3D3D3D"));
                        break;
                    case 1:
                        sim1.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.unselected_sim_tracker_dark_bg, getContext().getTheme()));
                        sim2.setBackground(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.sim_tracker_dark_bg, getContext().getTheme()));
                        sim2.setTextColor(Color.parseColor("#EEF4FC"));
                        sim1.setTextColor(Color.parseColor("#3D3D3D"));
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void initialObjects() {
        trackerViewPagerAdapter = new TrackerViewPagerAdapter(getParentFragmentManager(), getLifecycle());
        lineGraphSeries = new LineGraphSeries<>();
        lineGraphSeries2 = new LineGraphSeries<>();
    }

    private void linkWithId() {
        viewPager2Tracker = view.findViewById(R.id.vp_tracker);
        sim1 = view.findViewById(R.id.tv_sim1);
        sim2 = view.findViewById(R.id.tv_sim2);
        graphView = view.findViewById(R.id.gv_tracker);
    }
}