package com.example.qumi.presentation.messages.components;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.qumi.presentation.utils.adapters.SearchRecyclerViewAdapter;
import com.example.qumi.R;

import java.util.ArrayList;

public class SearchFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View view;
    private ArrayList<Integer>images;
    private ArrayList<String>usernames;
    private ArrayList<String>lastMessages;
    private ArrayList<String>lastMessagesDates;
    private ArrayList<String>lastMessagesStates;
    private SearchRecyclerViewAdapter searchRecyclerViewAdapter;
    private RecyclerView searchChatsRecyclerView;

    private EditText search_ed;
    private ImageButton search;
    private ImageButton moreSearchOptions;
    private ImageButton clear;

    public SearchFragment() {
    }

    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        view=inflater.inflate(R.layout.fragment_search, container, false);
        linkWithId();
        initializeObjects();
        fillRecyclerView();
        addItemsToArrayLists();
        search_edOnTouch();
        search_edOnChange();
        clearOnClick();
        searchOnClick();
        moreSearchOptionsOnClick();
        return view;
    }

    private void moreSearchOptionsOnClick() {
        moreSearchOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(moreSearchOptions);
            }
        });
    }

    private void showPopupMenu(ImageButton moreOptions) {
        PopupMenu popupMenu=new PopupMenu(getContext(),moreOptions);
        MenuInflater menuInflater=popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.overflow_search_options_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.via_message:
                        Toast.makeText(getContext(), "Search via message", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.via_username:
                        Toast.makeText(getContext(), "Search via Username", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.both:
                        Toast.makeText(getContext(), "Search via Both", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });
        popupMenu.show();
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    private void searchOnClick() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard((Activity) getContext());
            }
        });
    }

    private void clearOnClick() {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search_ed.setText("");
                clear.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
            }
        });
    }

    private void search_edOnChange() {
        search_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()==0){
                    clear.setVisibility(View.GONE);
                    search.setVisibility(View.GONE);
                }else{
                    clear.setVisibility(View.VISIBLE);
                    search.setVisibility(View.VISIBLE);
                    //search algorithm here
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void search_edOnTouch() {
        search_ed.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                search_ed.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.rounded__dark_ed_orange_stroke, getContext().getTheme()));
                moreSearchOptions.setImageResource(R.drawable.ic_more_options_dark);
                return false;
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    private void addItemsToArrayLists() {
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        images.add(R.drawable.deleteone);usernames.add("Ali Shafeek Ahmad");lastMessages.add("You:You are a slow designer man harry up");lastMessagesDates.add("12:01");lastMessagesStates.add("12");
        searchRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void fillRecyclerView() {
        searchChatsRecyclerView.setHasFixedSize(true);
        searchChatsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        searchChatsRecyclerView.setAdapter(searchRecyclerViewAdapter);
    }

    private void initializeObjects() {
        images=new ArrayList<>();
        usernames=new ArrayList<>();
        lastMessages=new ArrayList<>();
        lastMessagesDates=new ArrayList<>();
        lastMessagesStates=new ArrayList<>();
        searchRecyclerViewAdapter=new SearchRecyclerViewAdapter(getContext(),images,usernames,lastMessages,lastMessagesDates,lastMessagesStates);
    }

    private void linkWithId() {
        searchChatsRecyclerView=view.findViewById(R.id.rv_search_my_chats);
        search_ed=view.findViewById(R.id.ed_search);
        search=view.findViewById(R.id.img_btn_search);
        moreSearchOptions=view.findViewById(R.id.img_btn_advance_search);
        clear=view.findViewById(R.id.img_btn_clear);
    }
}