package com.example.tugascallapi;

import com.google.gson.annotations.SerializedName;

public class Anime {
    @SerializedName("id")
    private String animeID;

    @SerializedName("title")
    private String animeTitle;

    @SerializedName("original_title_romanised")
    private String animeRomanized;

    @SerializedName("description")
    private String description;

    @SerializedName("rt_score")
    private int Score;

    public String getAnimeID() {
        return animeID;
    }

    public String getAnimeTitle() {
        return animeTitle;
    }

    public String getAnimeRomanized() {
        return animeRomanized;
    }

    public String getDescription() {
        return description;
    }

    public int getScore() {
        return Score;
    }
}
