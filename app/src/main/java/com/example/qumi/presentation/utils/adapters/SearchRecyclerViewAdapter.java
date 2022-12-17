package com.example.qumi.presentation.utils.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qumi.presentation.utils.listeners.OnAdapterItemClickListener;
import com.example.qumi.presentation.utils.listeners.OnAdapterItemLongClickListener;
import com.example.qumi.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Integer>usersImages;
    private ArrayList<String>usernames;
    private ArrayList<String>lastMessages;
    private ArrayList<String>lastMessagesDates;
    private ArrayList<String>lastMessagesStates;
    private ArrayList<Boolean> isSelected;
    private OnAdapterItemLongClickListener onAdapterItemLongClickListener;
    private OnAdapterItemClickListener onAdapterItemClickListener;

    public SearchRecyclerViewAdapter(Context mContext, ArrayList<Integer> usersImages, ArrayList<String> usernames, ArrayList<String> lastMessages, ArrayList<String> lastMessagesDates, ArrayList<String> lastMessagesStates) {
        this.mContext = mContext;
        this.usersImages = usersImages;
        this.usernames = usernames;
        this.lastMessages = lastMessages;
        this.lastMessagesDates = lastMessagesDates;
        this.lastMessagesStates = lastMessagesStates;
        this.isSelected = new ArrayList<>(usernames.size());
        this.onAdapterItemLongClickListener = (OnAdapterItemLongClickListener) mContext;
        this.onAdapterItemClickListener = (OnAdapterItemClickListener) mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_chat_child_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        for (int i=0;i<usernames.size();i++)
            isSelected.add(false);
        holder.userImage.setImageResource(usersImages.get(position));
        holder.username.setText(usernames.get(position));
        holder.lastMessageDate.setText(lastMessagesDates.get(position));
        //lastMessageState can be set to "Delivered"(black) or "Failed"(red) or "Sending..."(gray2) or unread messages counter(Note: if there single number of unread message set text to " 2 " or " 1 " else set it to "12" or "4514")
        holder.lastMessageState.setText(lastMessagesStates.get(position));
        holder.b=isSelected.get(position);

        String myS="You are a slow <(>designer<)> man";
        String c1="<font color='#ED8A2F'>";
        String c2="</font>";
        String newS=myS.replace("<(>",c1);
        newS=newS.replace("<)>",c2);
        holder.lastMessage.setText(Html.fromHtml(newS));

    }

    @Override
    public int getItemCount() {
        return usernames.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ConstraintLayout constraintLayout;
        private CircleImageView userImage;
        private TextView username;
        private TextView lastMessage;
        private TextView lastMessageDate;
        private TextView lastMessageState;
        private boolean b;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout=itemView.findViewById(R.id.constraintLayout);
            userImage=itemView.findViewById(R.id.img_profile);
            username=itemView.findViewById(R.id.tv_username);
            lastMessage=itemView.findViewById(R.id.tv_last_message);
            lastMessageDate=itemView.findViewById(R.id.tv_last_message_date);
            lastMessageState=itemView.findViewById(R.id.tv_last_message_state);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            onAdapterItemClickListener.onAdapterItemClickLister(getAdapterPosition());
        }
    }
}
