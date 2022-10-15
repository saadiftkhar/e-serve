package com.codesses.e_serve.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.codesses.e_serve.R;
import com.codesses.e_serve.databinding.LayoutMessageRequestsBinding;
import com.codesses.e_serve.databinding.LayoutServicerFeedbackBinding;
import com.codesses.e_serve.model.MessageRequest;
import com.codesses.e_serve.model.Ratings;
import com.codesses.e_serve.viewolder.MessageRequestViewHolder;
import com.codesses.e_serve.viewolder.ServicerFeedbackViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ServicerFeedbackAdapter extends RecyclerView.Adapter<ServicerFeedbackViewHolder> {

    private Context mContext;
    private List<Ratings> list;

    public ServicerFeedbackAdapter(Context mContext, List<Ratings> list) {
        this.mContext = mContext;
        this.list = list;
    }


    @NonNull
    @NotNull
    @Override
    public ServicerFeedbackViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutServicerFeedbackBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.layout_servicer_feedback, parent, false);

        return new ServicerFeedbackViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ServicerFeedbackViewHolder holder, int position) {
        Ratings model = list.get(position);

        holder.bind(mContext, model);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
