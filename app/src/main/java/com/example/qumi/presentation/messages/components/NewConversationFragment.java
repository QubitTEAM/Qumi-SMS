package com.example.qumi.presentation.messages.components;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;
import com.example.qumi.presentation.utils.adapters.ChatRecyclerViewAdapter;
import com.example.qumi.presentation.utils.adapters.NewMessageNamesAdapter;
import com.example.qumi.presentation.utils.adapters.ViewPagerAdapterForNewConservation;
import com.example.qumi.R;

import java.util.ArrayList;

public class NewConversationFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View view;
    private RecyclerView rv_people_to_send_message;
    private ArrayList<String>names;
    private NewMessageNamesAdapter newMessageNamesAdapter;

    private ArrayList<Integer>images;
    private ArrayList<String>usernames;
    private ArrayList<String>lastMessages;
    private ArrayList<String>lastMessagesDates;
    private ArrayList<String>lastMessagesStates;
    private ChatRecyclerViewAdapter chatRecyclerViewAdapter;
    private RecyclerView rv_users_of_app;
    private ConstraintLayout constraintLayout2;
    private ImageButton writeMessage;
    private TextView select_contact;


    private EditText message;
    private ImageButton smiles;
    private boolean smilesIsClicked = false;
    private ImageButton attached;
    private boolean attachedIsClicked = false;
    private ImageButton sim_card;
    private TextView sim_card_num;
    private ImageButton send;
    private TextView counter;

    public NewConversationFragment() {
    }

    public static NewConversationFragment newInstance() {
        NewConversationFragment fragment = new NewConversationFragment();
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
        view=inflater.inflate(R.layout.fragment_new_conversation, container, false);
        linkWithId();
        init();
        fillUsersRecyclerView();
        addItemsToArrayLists();
        setUPNamesRecyclerView();
        writeMessageOnCLick();
        messageOnChange();
        simOnclick();
        attachedOnClick();
        smilesOnClick();
        return view;
    }

    private void smilesOnClick() {
        smiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smilesIsClicked = !smilesIsClicked;
                if (smilesIsClicked)
                    smiles.setImageResource(R.drawable.ic_smile_orange);
                else
                    smiles.setImageResource(R.drawable.ic_smile);
                if (attachedIsClicked){
                    attachedIsClicked=!attachedIsClicked;
                    attached.setImageResource(R.drawable.ic_attach);
                }
            }
        });
    }

    private void attachedOnClick() {
        attached.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attachedIsClicked = !attachedIsClicked;
                if (attachedIsClicked)
                    attached.setImageResource(R.drawable.ic_attach_orange);
                else
                    attached.setImageResource(R.drawable.ic_attach);
                if (smilesIsClicked) {
                    smilesIsClicked=!smilesIsClicked;
                    smiles.setImageResource(R.drawable.ic_smile);
                }
            }
        });
    }

    private void simOnclick() {
        sim_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sim_card_num.getText().toString().equals("1"))
                    sim_card_num.setText("2");
                else
                    sim_card_num.setText("1");
            }
        });
        sim_card_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sim_card_num.getText().toString().equals("1"))
                    sim_card_num.setText("2");
                else
                    sim_card_num.setText("1");
            }
        });

    }

    private void messageOnChange() {
        message.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int numOfMessages = Math.floorMod(charSequence.length(), 63);
                if (charSequence.length() < 40)
                    counter.setVisibility(View.GONE);
                if (charSequence.length() > 40) {
                    counter.setVisibility(View.VISIBLE);
                    if (charSequence.length() < 63)
                        counter.setText(charSequence.length() + "/63");
                    else {
                        counter.setText(numOfMessages + "/" + (int) (Math.ceil(charSequence.length() / 63.0)));
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void writeMessageOnCLick() {
        writeMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeMessage.setVisibility(View.GONE);
                constraintLayout2.setVisibility(View.VISIBLE);
                rv_users_of_app.setVisibility(View.GONE);
                select_contact.setVisibility(View.GONE);
                getActivity().findViewById(R.id.bottom_nav_bar).setVisibility(View.GONE);
            }
        });
    }

    private void fillUsersRecyclerView() {
        rv_users_of_app.setHasFixedSize(true);
        rv_users_of_app.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_users_of_app.setAdapter(chatRecyclerViewAdapter);
    }
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

    private void setUPNamesRecyclerView() {
        rv_people_to_send_message.setHasFixedSize(true);
        rv_people_to_send_message.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        rv_people_to_send_message.setAdapter(newMessageNamesAdapter);
        names.add("Ali");
        names.add("Emad");
        names.add("Bayan");
        names.add("Beshr");
        names.add("Ali");
        names.add("Emad");
        names.add("Bayan");
        names.add("Beshr");
        newMessageNamesAdapter.notifyDataSetChanged();
    }

    private void init() {
        names=new ArrayList<>();
        newMessageNamesAdapter=new NewMessageNamesAdapter(getContext(),names);
        images=new ArrayList<>();
        usernames=new ArrayList<>();
        lastMessages=new ArrayList<>();
        lastMessagesDates=new ArrayList<>();
        lastMessagesStates=new ArrayList<>();
        chatRecyclerViewAdapter=new ChatRecyclerViewAdapter(getContext(),images,usernames,lastMessages,lastMessagesDates,lastMessagesStates);
    }
    private void linkWithId() {
        rv_people_to_send_message=view.findViewById(R.id.rv_people_to_send_messages);
        rv_users_of_app=view.findViewById(R.id.rv_users_of_app);
        constraintLayout2=view.findViewById(R.id.constraintLayout2);
        writeMessage=view.findViewById(R.id.img_btn_write_message);
        select_contact=view.findViewById(R.id.tv_select_contact);
        message = view.findViewById(R.id.ed_write_message);
        smiles = view.findViewById(R.id.img_btn_smiles);
        attached = view.findViewById(R.id.img_btn_attached);
        sim_card = view.findViewById(R.id.img_btn_sim_card);
        sim_card_num = view.findViewById(R.id.tv_sim_num);
        send = view.findViewById(R.id.img_btn_send);
        counter = view.findViewById(R.id.tv_message_counter);
    }
}