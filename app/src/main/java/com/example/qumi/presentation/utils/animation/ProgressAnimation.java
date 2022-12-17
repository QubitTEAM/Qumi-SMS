package com.example.qumi.presentation.utils.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.qumi.R;

public class ProgressAnimation extends Animation{
    private Context context;
    private TextView progressText;
    private ProgressBar progressBar;
    private float from;
    private float to;
    private String name;

    public ProgressAnimation(Context context,TextView progressText, ProgressBar progressBar, float from, float to,String name) {
        this.context=context;
        this.progressText = progressText;
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
        this.name = name;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value=from+(to-from)*interpolatedTime;
        progressBar.setProgress((int) value);
        progressText.setText(name+": "+ context.getString(R.string.sent)+" "+(int) value+"% "+context.getString(R.string.received)+" "+(int)(100-value)+"%");
    }
}
