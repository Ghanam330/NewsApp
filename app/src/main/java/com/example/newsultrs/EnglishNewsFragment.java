package com.example.newsultrs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsultrs.model.NewsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnglishNewsFragment extends Fragment {


    public EnglishNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView rvPlayers= view.findViewById(R.id.rv_players);
        rvPlayers.setLayoutManager(new LinearLayoutManager(this.getContext()));

        NewsClient.getService().grtNewsus().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.isSuccessful()){
                    PlayerAdapter adapter = new PlayerAdapter(response.body().getArticles(), new PlayerAdapter.OnPlayerItemClickListener() {
                        @Override
                        public void OnItemClick(int position) {

                        }
                    });
                    rvPlayers.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("throwable",t.getMessage());

            }
        });
    }
}