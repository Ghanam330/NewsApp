package com.example.newsultrs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.newsultrs.model.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {


    private List<Article> list;

    private OnPlayerItemClickListener listener;
    public PlayerAdapter(List<Article> list, OnPlayerItemClickListener listener) {
        this.list = list;
        this.listener=listener;
    }


    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, final int position) {
        Article current = list.get(position);
        holder.tvName.setText(current.getTitle());
        holder.tvDesc.setText(current.getDescription());
      //  holder.ivPhoto.setBackgroundResource(current.getImage());

        //Loading photo from Server
        //picasso
        Picasso.with(holder.itemView.getContext()).load(current.getUrlToImage()).into(holder.ivPhoto);


        holder.ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnItemClick(position);
            }
        });
    }

    public interface OnPlayerItemClickListener{
        void OnItemClick(int position);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvDesc;
        private ImageView ivPhoto;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvName = itemView.findViewById(R.id.tv_player_name);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
        }
    }
}