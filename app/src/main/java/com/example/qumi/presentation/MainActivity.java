package com.example.qumi.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import dagger.hilt.android.AndroidEntryPoint;
import de.hdodenhof.circleimageview.CircleImageView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;
import com.example.qumi.R;
import com.example.qumi.presentation.messages.components.ChattingFragment;
import com.example.qumi.presentation.core.HomeFragment;
import com.example.qumi.presentation.messages.components.NewConversationFragment;
import com.example.qumi.presentation.messages.components.SearchFragment;
import com.example.qumi.presentation.settings.SettingsFragment;
import com.example.qumi.presentation.profile.TrackerFragment;
import com.example.qumi.presentation.utils.listeners.OnAdapterItemClickListener;
import com.example.qumi.presentation.utils.listeners.OnAdapterItemLongClickListener;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements OnAdapterItemLongClickListener, AAH_FabulousFragment.Callbacks, OnAdapterItemClickListener {
    private BottomNavigationView bottomNavigationView;
    private TextView fragmentName;
    private TextView username;
    private TextView userNum;
    private ImageButton search;
    private ImageButton moreOptions;
    private ImageButton backArrow;
    private CircleImageView profile_img;
    private FloatingActionButton fab_new_conservation;
    private FrameLayout frameLayout;
    private ConstraintLayout constraintLayout_bottom_nav_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        linkWithId();
        initializeObjects();
        setUpBottomNavBar();
        searchOnClick();
        moreOptionsOnClick();
        backArrowOnClick();
        fab_new_conservationOnClick();
    }

    private void moreOptionsOnClick() {
        moreOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(moreOptions);
            }
        });
    }

    private void showPopupMenu(ImageButton moreOptions) {
        PopupMenu popupMenu = new PopupMenu(this, moreOptions);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        if (fragmentName.getText().toString().equals(getString(R.string.chat))) {
            menuInflater.inflate(R.menu.overflow_options_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.selectAll:
                            Toast.makeText(MainActivity.this, "Select All", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.share:
                            Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.archive:
                            Toast.makeText(MainActivity.this, "Archive", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.delete:
                            Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.cancel:
                            Toast.makeText(MainActivity.this, "Cacnel", Toast.LENGTH_SHORT).show();
                            break;

                    }
                    return true;
                }
            });
        } else {
            //show this if no items are selected
            menuInflater.inflate(R.menu.overflow_chatting_options_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.archive:
                            Toast.makeText(MainActivity.this, "Select All", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.mute:
                            Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.delete:
                            Toast.makeText(MainActivity.this, "Archive", Toast.LENGTH_SHORT).show();
                            break;

                    }
                    return true;
                }
            });
            //show this if there are selected items
            /*menuInflater.inflate(R.menu.overflow_selected_chatting_options_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.selectAll:
                            Toast.makeText(MainActivity.this, "Select All", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.share:
                            Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.delete:
                            Toast.makeText(MainActivity.this, "Archive", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.cancel:
                            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                            break;


                    }
                    return true;
                }
            });*/
        }
        popupMenu.show();
    }

    private void fab_new_conservationOnClick() {
        fab_new_conservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NewConversationFragment()).commit();
                search.setVisibility(View.VISIBLE);
                fragmentName.setText(R.string.new_message);
                fab_new_conservation.setVisibility(View.GONE);
                backArrow.setVisibility(View.VISIBLE);
            }
        });
    }

    private void backArrowOnClick() {
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                search.setVisibility(View.VISIBLE);
                bottomNavigationView.setVisibility(View.VISIBLE);
                fragmentName.setText(getString(R.string.chat));
                fragmentName.setVisibility(View.VISIBLE);
                fragmentName.setText(getString(R.string.chat));
                backArrow.setVisibility(View.GONE);
                moreOptions.setVisibility(View.GONE);
                profile_img.setVisibility(View.GONE);
                userNum.setVisibility(View.GONE);
                username.setVisibility(View.GONE);
                fab_new_conservation.setVisibility(View.VISIBLE);
                constraintLayout_bottom_nav_bar.setVisibility(View.VISIBLE);
            }
        });
    }

    private void searchOnClick() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SearchFragment()).commit();
                search.setVisibility(View.GONE);
                fragmentName.setText(getString(R.string.search));
                backArrow.setVisibility(View.VISIBLE);
                moreOptions.setVisibility(View.GONE);
                fab_new_conservation.setVisibility(View.GONE);
                constraintLayout_bottom_nav_bar.setVisibility(View.GONE);
            }
        });
    }

    private void setUpBottomNavBar() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                        fragmentName.setText(getString(R.string.chat));
                        search.setVisibility(View.VISIBLE);
                        moreOptions.setVisibility(View.GONE);
                        fab_new_conservation.setVisibility(View.VISIBLE);
                        break;
                    case R.id.tracker:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TrackerFragment()).commit();
                        fragmentName.setText(getString(R.string.tracker));
                        search.setVisibility(View.VISIBLE);
                        moreOptions.setVisibility(View.GONE);
                        fab_new_conservation.setVisibility(View.GONE);
                        break;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                        fragmentName.setText(getString(R.string.setting));
                        search.setVisibility(View.GONE);
                        moreOptions.setVisibility(View.GONE);
                        fab_new_conservation.setVisibility(View.GONE);
                        break;

                }
                return true;
            }
        });
        //if we add an update later or there is a notification so we can set this to make user pay attention
        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.home);
        badgeDrawable.setBackgroundColor(Color.parseColor("#DE802A"));
        badgeDrawable.setVisible(true);
    }

    private void initializeObjects() {
    }

    private void linkWithId() {
        frameLayout = findViewById(R.id.fragment_container);
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        fragmentName = findViewById(R.id.tv_fragment_name);
        username = findViewById(R.id.tv_username);
        userNum = findViewById(R.id.tv_user_num);
        search = findViewById(R.id.img_btn_search);
        moreOptions = findViewById(R.id.img_btn_more_options);
        backArrow = findViewById(R.id.img_btn_back_arrow);
        profile_img = findViewById(R.id.img_profile);
        fab_new_conservation = findViewById(R.id.fab_add_new_conservation);
        constraintLayout_bottom_nav_bar = findViewById(R.id.constraintLayout_bottom_nav_bar);
    }

    @Override
    public void onAdapterItemLongClickListener(int position, boolean b) {
        if (b)
            moreOptions.setVisibility(View.VISIBLE);
        else
            moreOptions.setVisibility(View.GONE);
    }

    @Override
    public void onResult(Object result) {
        if (result.toString().equalsIgnoreCase("swiped_down")) {
            Toast.makeText(MainActivity.this, "Swiped_down", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Not Swiped_down", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAdapterItemClickLister(int position) {
        backArrow.setVisibility(View.VISIBLE);
        profile_img.setVisibility(View.VISIBLE);
        search.setVisibility(View.GONE);
        moreOptions.setVisibility(View.VISIBLE);
        userNum.setVisibility(View.VISIBLE);
        fragmentName.setVisibility(View.GONE);
        fragmentName.setText(getString(R.string.chatting));
        username.setVisibility(View.VISIBLE);
        fab_new_conservation.setVisibility(View.GONE);
        bottomNavigationView.setVisibility(View.GONE);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChattingFragment()).commit();
    }

}