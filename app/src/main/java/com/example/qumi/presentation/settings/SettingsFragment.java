package com.example.qumi.presentation.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.qumi.R;
import com.vimalcvs.switchdn.DayNightSwitch;
import com.vimalcvs.switchdn.DayNightSwitchListener;

public class SettingsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View view;

    private View darkView;
    private DayNightSwitch modeSwitch;
    private ImageButton setting_mode_Img;

    private View view1_notification;
    private ImageButton setting_notification_Img;
    private TextView setting_notification_TV;


    private View view2_chat_setting;
    private ImageButton setting_chat_Img;
    private TextView setting_chat_TV;

    private View view3_privacy;
    private ImageButton setting_privacy_Img;
    private TextView setting_privacy_TV;

    private View view4_data_tracker;
    private ImageButton setting_tracker_Img;
    private TextView setting_tracker_TV;

    private View view5_about;
    private ImageButton setting_about_Img;
    private ImageButton goForwardArrow;
    private TextView setting_about_TV;



    public SettingsFragment() {
    }

    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        view=inflater.inflate(R.layout.fragment_settings, container, false);
        linkWithId();
        addSettingView(setting_notification_Img,R.drawable.ic_notification,setting_notification_TV,getString(R.string.notification));
        addSettingView(setting_chat_Img,R.drawable.ic_chat,setting_chat_TV,getString(R.string.chat_setting));
        addSettingView(setting_privacy_Img,R.drawable.ic_privacy,setting_privacy_TV,getString(R.string.privacy_security));
        addSettingView(setting_tracker_Img,R.drawable.ic_pie_chart,setting_tracker_TV,getString(R.string.data_tracker));
        addSettingView(setting_about_Img,R.drawable.ic_about_button,setting_about_TV,getString(R.string.about));
        goForwardArrow.setVisibility(View.GONE);
        modeSwitch();
        return view;
    }

    private void addSettingView(ImageButton settingImg,Integer settingIcon,TextView settingTV,String settingName) {
        settingImg.setImageResource(settingIcon);
        settingTV.setText(settingName);
    }
    private void modeSwitch(){
        modeSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night)
                    setting_mode_Img.setImageResource(R.drawable.ic_moon_);
                else
                    setting_mode_Img.setImageResource(R.drawable.ic_sun);
            }
        });
    }

    private void linkWithId() {

        darkView=view.findViewById(R.id.include_app_mode);
        modeSwitch=darkView.findViewById(R.id.switch_app_mode);
        setting_mode_Img=darkView.findViewById(R.id.img_btn_setting_icon);

        view1_notification=view.findViewById(R.id.include_notification);
        setting_notification_Img=view1_notification.findViewById(R.id.img_btn_setting_icon);
        setting_notification_TV=view1_notification.findViewById(R.id.tv_setting_name);

        view2_chat_setting=view.findViewById(R.id.include_chat_setting);
        setting_chat_Img=view2_chat_setting.findViewById(R.id.img_btn_setting_icon);
        setting_chat_TV=view2_chat_setting.findViewById(R.id.tv_setting_name);

        view3_privacy = view.findViewById(R.id.include_privacy);
        setting_privacy_Img = view3_privacy.findViewById(R.id.img_btn_setting_icon);
        setting_privacy_TV = view3_privacy.findViewById(R.id.tv_setting_name);

        view4_data_tracker = view.findViewById(R.id.include_data_tracker);
        setting_tracker_Img = view4_data_tracker.findViewById(R.id.img_btn_setting_icon);
        setting_tracker_TV = view4_data_tracker.findViewById(R.id.tv_setting_name);

        view5_about = view.findViewById(R.id.include_about);
        setting_about_Img = view5_about.findViewById(R.id.img_btn_setting_icon);
        goForwardArrow = view5_about.findViewById(R.id.img_btn_go_forward);
        setting_about_TV = view5_about.findViewById(R.id.tv_setting_name);



    }
}