package com.eserve.android.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.eserve.android.R;
import com.eserve.android.databinding.LayoutMessageRequestsBinding;
import com.eserve.android.model.MessageRequest;
import com.eserve.android.viewolder.MessageRequestViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MessageRequestAdapter extends RecyclerView.Adapter<MessageRequestViewHolder> {

    private Context mContext;
    private List<MessageRequest> list;

    public MessageRequestAdapter(Context mContext, List<MessageRequest> list) {
        this.mContext = mContext;
        this.list = list;
    }


    @NonNull
    @NotNull
    @Override
    public MessageRequestViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutMessageRequestsBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.layout_message_requests, parent, false);

        return new MessageRequestViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MessageRequestViewHolder holder, int position) {
        MessageRequest model = list.get(position);

        holder.bind(mContext, model);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
