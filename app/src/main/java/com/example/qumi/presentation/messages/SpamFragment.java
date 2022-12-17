package com.example.qumi.presentation.messages;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qumi.presentation.utils.adapters.ChatRecyclerViewAdapter;
import com.example.qumi.presentation.utils.listeners.CustomScrollListener;
import com.example.qumi.R;

import java.util.ArrayList;

public class SpamFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private View view;
    private ArrayList<Integer> images;
    private ArrayList<String>usernames;
    private ArrayList<String>lastMessages;
    private ArrayList<String>lastMessagesDates;
    private ArrayList<String>lastMessagesStates;
    private ChatRecyclerViewAdapter chatRecyclerViewAdapter;
    private RecyclerView spamRecyclerView;

    public SpamFragment() {
    }


    public static SpamFragment newInstance(String param1, String param2) {
        SpamFragment fragment = new SpamFragment();
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
        view=inflater.inflate(R.layout.fragment_spam, container, false);
        linkWithId();
        initializeObjects();
        fillRecyclerView();
        addItemsToArrayLists();
        return view;
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
        chatRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void fillRecyclerView() {
        spamRecyclerView.setHasFixedSize(true);
        spamRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        spamRecyclerView.setAdapter(chatRecyclerViewAdapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            spamRecyclerView.setOnScrollListener(new CustomScrollListener(getActivity()));
    }

    private void initializeObjects() {
        images=new ArrayList<>();
        usernames=new ArrayList<>();
        lastMessages=new ArrayList<>();
        lastMessagesDates=new ArrayList<>();
        lastMessagesStates=new ArrayList<>();
        chatRecyclerViewAdapter=new ChatRecyclerViewAdapter(getContext(),images,usernames,lastMessages,lastMessagesDates,lastMessagesStates);
    }

    private void linkWithId() {
        spamRecyclerView=view.findViewById(R.id.rv_spam);
    }
}