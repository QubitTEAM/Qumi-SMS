package com.example.qumi.presentation.profile.components;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.qumi.presentation.utils.animation.ProgressAnimation;
import com.example.qumi.R;

public class SimTwoFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private int statue = 0;
    private View view;
    private ProgressBar circularProgressBar;
    private TextView consumed;
    private TextView left;
    private Handler handler = new Handler();

    private ProgressBar theMostConsumedChat;
    private ProgressBar theMiddleConsumedChat;
    private ProgressBar theLeastConsumedChat;

    private TextView theMostConsumedChatTV;
    private TextView theMiddleConsumedChatTV;
    private TextView theLeastConsumedChatTV;

    private ProgressAnimation progressAnimation1;
    private ProgressAnimation progressAnimation2;
    private ProgressAnimation progressAnimation3;

    public SimTwoFragment() {
    }

    public static SimTwoFragment newInstance(String param1, String param2) {
        SimTwoFragment fragment = new SimTwoFragment();
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
        view = inflater.inflate(R.layout.fragment_sim_two, container, false);
        linkWithId();
        init();
        balanceTracker();
        theMostConsumedChatTrackers(theMostConsumedChat,progressAnimation1);
        theMostConsumedChatTrackers(theMiddleConsumedChat,progressAnimation2);
        theMostConsumedChatTrackers(theLeastConsumedChat,progressAnimation3);
        theMostConsumedChat.setProgress(50);
        return view;
    }

    private void theMostConsumedChatTrackers(ProgressBar progressBar, ProgressAnimation progressAnimation) {
        progressBar.setMax(100);
        progressAnimation.setDuration(1800);
        progressBar.startAnimation(progressAnimation);
    }
    private void balanceTracker() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (statue < 80) {
                    statue++;
                    handler.postDelayed(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {
                            circularProgressBar.setProgress(statue);
                            consumed.setText(getString(R.string.consumed) + statue+"%");
                            left.setText(getString(R.string.left) + (100 - statue)+"%");
                        }
                    }, 10);
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void init(){
        progressAnimation1=new ProgressAnimation(getContext(),theMostConsumedChatTV,theMostConsumedChat,0f,80f,"Crush");
        progressAnimation2=new ProgressAnimation(getContext(),theMiddleConsumedChatTV,theMiddleConsumedChat,0f,73f,"Moh");
        progressAnimation3=new ProgressAnimation(getContext(),theLeastConsumedChatTV,theLeastConsumedChat,0f,59f,"Li");
    }

    private void linkWithId() {
        circularProgressBar = view.findViewById(R.id.pb_tracker2);
        consumed = view.findViewById(R.id.tv_consumed);
        left = view.findViewById(R.id.tv_left);
        theMostConsumedChat = view.findViewById(R.id.pb_most_consuming_chat);
        theMiddleConsumedChat = view.findViewById(R.id.pb_middle_consuming_chat);
        theLeastConsumedChat = view.findViewById(R.id.pb_least_consuming_chat);
        theMostConsumedChatTV = view.findViewById(R.id.tv_most_consuming_chat);
        theMiddleConsumedChatTV = view.findViewById(R.id.tv_middle_consuming_chat);
        theLeastConsumedChatTV = view.findViewById(R.id.tv_least_consuming_chat);
    }
}