package com.example.qumi.presentation.utils.listeners;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qumi.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CustomScrollListener extends RecyclerView.OnScrollListener {
    private final Activity activity;
    private final FloatingActionButton floatingActionButton;
    public CustomScrollListener(Activity activity) {
        this.activity=activity;
        floatingActionButton=activity.findViewById(R.id.fab_add_new_conservation);
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        switch (newState) {
            case RecyclerView.SCROLL_STATE_IDLE:
                System.out.println("The RecyclerView is not scrolling");
                break;
            case RecyclerView.SCROLL_STATE_DRAGGING:
                System.out.println("Scrolling now");
                break;
            case RecyclerView.SCROLL_STATE_SETTLING:
                System.out.println("Scroll Settling");
                break;

        }

    }

    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        if (dx > 0) {
            System.out.println("Scrolled Right");
        } else if (dx < 0) {
            System.out.println("Scrolled Left");
        } else {
            System.out.println("No Horizontal Scrolled");
        }

        Animation animationClose= AnimationUtils.loadAnimation(activity,R.anim.fab_close_anim);
        Animation animationOpen= AnimationUtils.loadAnimation(activity,R.anim.fab_open_anim);
        if (dy > 0) {
            floatingActionButton.setVisibility(View.GONE);
            floatingActionButton.startAnimation(animationClose);
            System.out.println("Scrolled Downwards");
        } else if (dy < 0) {
            floatingActionButton.setVisibility(View.VISIBLE);
            floatingActionButton.startAnimation(animationOpen);
            System.out.println("Scrolled Upwards");
        } else {
            floatingActionButton.setVisibility(View.VISIBLE);
            floatingActionButton.startAnimation(animationOpen);
            System.out.println("No Vertical Scrolled");
        }
    }
}