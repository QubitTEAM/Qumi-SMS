package com.example.qumi.presentation.utils.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qumi.presentation.utils.listeners.OnAdapterItemClickListener;
import com.example.qumi.presentation.utils.listeners.OnAdapterItemLongClickListener;
import com.example.qumi.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ChattingRecyclerViewAdapter extends RecyclerView.Adapter<ChattingRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> messages;
    private ArrayList<String> sim_nums;
    private ArrayList<String> messagesStates;
    private ArrayList<String> messagesDates;
    private ArrayList<Boolean> isSelected;
    private ArrayList<Boolean> isHidden;
    private OnAdapterItemLongClickListener onAdapterItemLongClickListener;

    public ChattingRecyclerViewAdapter(Context context, ArrayList<String> messages, ArrayList<String> sim_nums, ArrayList<String> messagesStates, ArrayList<String> messagesDates) {
        this.context = context;
        this.messages = messages;
        this.sim_nums = sim_nums;
        this.messagesStates = messagesStates;
        this.messagesDates = messagesDates;
        this.isSelected = new ArrayList<>(messages.size());
        this.isHidden = new ArrayList<>(messages.size());
        this.onAdapterItemLongClickListener = (OnAdapterItemLongClickListener) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_chatting_child_item, parent, false);
        else if (viewType == 1)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_chatting_sent_item, parent, false);
        else
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_date_new_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        for (int i = 0; i < messages.size(); i++)
            isSelected.add(false);
        for (int i = 0; i < messages.size(); i++)
            isHidden.add(true);
        if (holder.getItemViewType() == 0 || holder.getItemViewType() == 1) {
            holder.simCardNum.setText(sim_nums.get(position));
            holder.messageState.setText(messagesStates.get(position));
            holder.messageDate.setText(messagesDates.get(position));



            //color messages when we search for them
            //this is required when we click item in search chat fragment
            if (holder.getItemViewType() ==1) {
                String myS = "You are a slow <(>designer<)> man";
                String c1 = "<font color='#000000'>";
                String c2 = "</font>";
                String newS = myS.replace("<(>", c1);
                newS = newS.replace("<)>", c2);
                holder.message.setText(Html.fromHtml(newS));
            }else{
                String myS = "You are a slow <(>designer<)> man";
                String c1 = "<font color='#ED8A2F'>";
                String c2 = "</font>";
                String newS = myS.replace("<(>", c1);
                newS = newS.replace("<)>", c2);
                holder.message.setText(Html.fromHtml(newS));
            }




            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!isHidden.get(position)) {
                        isHidden.set(position, true);
                        holder.simCardNum.setVisibility(View.GONE);
                        holder.simCard.setVisibility(View.GONE);
                        holder.messageState.setVisibility(View.GONE);
                        holder.messageDate.setVisibility(View.GONE);
                    } else {
                        isHidden.set(position, false);
                        holder.simCardNum.setVisibility(View.VISIBLE);
                        holder.simCard.setVisibility(View.VISIBLE);
                        if (holder.getItemViewType() == 1)
                            holder.messageState.setVisibility(View.VISIBLE);
                        holder.messageDate.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private ConstraintLayout constraintLayout;
        private TextView message;
        private TextView simCardNum;
        private TextView messageState;
        private TextView messageDate;
        private ImageView simCard;
        private boolean b;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            message = itemView.findViewById(R.id.tv_message);
            simCardNum = itemView.findViewById(R.id.tv_sim_num);
            simCard = itemView.findViewById(R.id.img_btn_sim_card);
            messageState = itemView.findViewById(R.id.tv_message_state);
            messageDate = itemView.findViewById(R.id.tv_message_date);
        }

        @Override
        public boolean onLongClick(View view) {
            if (!b) {
                isSelected.set(getAdapterPosition(), true);
                constraintLayout.setBackgroundResource(R.drawable.rv_selected_item_dark_bg);
            } else {
                isSelected.set(getAdapterPosition(), false);
                constraintLayout.setBackgroundResource(R.drawable.rv_unselected_child_jtem);
            }
            int selectedCount = 0;
            for (boolean bool : isSelected) {
                if (bool) selectedCount++;
            }
            if (selectedCount > 0)
                b = true;
            else
                b = false;
            onAdapterItemLongClickListener.onAdapterItemLongClickListener(getAdapterPosition(), b);
            return false;
        }
    }
}
