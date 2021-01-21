package com.example.newsultrs;

import com.example.newsultrs.model.NewsResponse;


import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    @GET("v2/top-headlines?country=eg&apiKey=c4652d58322344a783a6cea9e37e0707")
    Call<NewsResponse> getNews();
@GET("v2/top-headlines?country=us&apiKey=c4652d58322344a783a6cea9e37e0707")
    Call<NewsResponse>grtNewsus();
    @GET("v2/top-headlines?country=fr&apiKey=c4652d58322344a783a6cea9e37e0707")
    Call<NewsResponse> getNewsfr();
}
