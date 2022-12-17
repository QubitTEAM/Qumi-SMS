package com.example.qumi.presentation.messages.components;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.qumi.presentation.utils.adapters.ChattingRecyclerViewAdapter;
import com.example.qumi.R;

import java.util.ArrayList;

public class ChattingFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View view;
    private ArrayList<String> messages;
    private ArrayList<String> sim_nums;
    private ArrayList<String> messagesStates;
    private ArrayList<String> messagesDates;
    private ArrayList<Boolean> isSelected;
    private ChattingRecyclerViewAdapter chattingRecyclerViewAdapter;
    private RecyclerView recyclerViewChatting;

    private EditText message;
    private ImageButton smiles;
    private boolean smilesIsClicked = false;
    private ImageButton attached;
    private boolean attachedIsClicked = false;
    private ImageButton sim_card;
    private TextView sim_card_num;
    private ImageButton send;
    private TextView counter;

    public ChattingFragment() {
    }

    public static ChattingFragment newInstance(String param1, String param2) {
        ChattingFragment fragment = new ChattingFragment();
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
        view = inflater.inflate(R.layout.fragment_chatting, container, false);
        linkWithId();
        init();
        setUpChattingRV();
        fillRVItems();
        fillRVItems();
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

    private void fillRVItems() {
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        messages.add("Hey Man");
        sim_nums.add("1");
        messagesStates.add("Delivered");
        messagesDates.add("12:01");
        chattingRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void setUpChattingRV() {
        recyclerViewChatting.setHasFixedSize(true);
        recyclerViewChatting.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewChatting.setAdapter(chattingRecyclerViewAdapter);
    }

    private void init() {
        messages = new ArrayList<>();
        sim_nums = new ArrayList<>();
        messagesStates = new ArrayList<>();
        messagesDates = new ArrayList<>();
        isSelected = new ArrayList<>();
        chattingRecyclerViewAdapter = new ChattingRecyclerViewAdapter(getContext(), messages, sim_nums, messagesStates, messagesDates);
    }

    private void linkWithId() {
        recyclerViewChatting = view.findViewById(R.id.rv_chatting);
        message = view.findViewById(R.id.ed_write_message);
        smiles = view.findViewById(R.id.img_btn_smiles);
        attached = view.findViewById(R.id.img_btn_attached);
        sim_card = view.findViewById(R.id.img_btn_sim_card);
        sim_card_num = view.findViewById(R.id.tv_sim_num);
        send = view.findViewById(R.id.img_btn_send);
        counter = view.findViewById(R.id.tv_message_counter);
    }
}