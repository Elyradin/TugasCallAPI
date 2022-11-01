package com.example.tugascallapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView judul;
    TextView judulrom;
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        judul = findViewById(R.id.judulAnime);
        judulrom = findViewById(R.id.jdlromaniz);
        desc = findViewById(R.id.description);

        getSpecifiedAnime();
//        getDataAnime();
    }

    private void getSpecifiedAnime() {
        Call<Anime> call = RetrofitClient.getInstance().getMyApi().getAnimeData("12cfb892-aac0-4c5b-94af-521852e46d6a");
        call.enqueue(new Callback<Anime>() {
            @Override
            public void onResponse(Call<Anime> call, Response<Anime> response) {
                Anime anime = response.body();
                judul.setText(anime.getAnimeTitle());
                judulrom.setText(anime.getAnimeRomanized());
                desc.setText(anime.getDescription());
            }

            @Override
            public void onFailure(Call<Anime> call, Throwable t) {

            }
        });
    }

    private void getDataAnime() {
        Call<List<Anime>> caller = RetrofitClient.getInstance().getMyApi().getAnime(0);
        caller.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                List<Anime> animeList = response.body();
                String films = "";
                for (int i=0; i<animeList.size(); i++){
                    Anime currentAnime = animeList.get(i);
                    films = films + currentAnime.getAnimeTitle()+ "," + " ";
                }
                judul.setText(films);
            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {

            }
        });
    }

}