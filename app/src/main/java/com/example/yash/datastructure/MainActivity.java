package com.example.yash.datastructure;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.yash.datastructure.API.LocAPI;
import com.example.yash.datastructure.Adapter.QuestionAdapter;
import com.example.yash.datastructure.Model.Items;
import com.example.yash.datastructure.Model.Question;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Question> questions;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        getData();
    }

    private void getData() {
        Call<Items> QuestionList = LocAPI.getService().getQuestion();
        QuestionList.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                Items items = response.body();
                questions = new ArrayList<>(items.getQuestions());
                recyclerView.setAdapter(new QuestionAdapter(MainActivity.this, questions));
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error occurred !!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void cardClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://learncodeonline.in/"));
        startActivity(intent);
    }
}
