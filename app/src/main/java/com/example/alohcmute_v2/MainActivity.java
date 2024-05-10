package com.example.alohcmute_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcPost;
    PostAdapter postAdapter;
    APIService apiService;
    List<Post> listPost;
    ResponseDTO responseDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        loadNewPost();

    }

    private void AnhXa() {
        rcPost = findViewById(R.id.recyclerview_posts);
    }

    private void loadNewPost() {
        apiService = RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getNewPosts(1, 7).enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                responseDTO = response.body();
                listPost = responseDTO.getListPost();
            Log.d("PIMG", listPost.get(0).getPostImage());
                postAdapter = new PostAdapter(listPost, MainActivity.this);
                rcPost.setAdapter(postAdapter);
                rcPost.setHasFixedSize(true);
                rcPost.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {
                Log.d("LogFail", t.getMessage());

            }


        });
    }


}