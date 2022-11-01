package com.example.tugascallapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
//    @GET("films")
//    Call<Anime> getDataAnime();
    @GET("films")
    Call<List<Anime>> getAnime(@Query("size") int number);
    @GET("films/{id}")
    Call<Anime> getAnimeData(@Path("id")  String animeID);

}
