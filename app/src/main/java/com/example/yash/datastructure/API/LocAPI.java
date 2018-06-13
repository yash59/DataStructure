package com.example.yash.datastructure.API;

import com.example.yash.datastructure.Model.Items;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class LocAPI {
    private static final String URL = "https://learncodeonline.in/";
    public static QuestionService questionService = null;

    public static QuestionService getService() {
        if (questionService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            questionService = retrofit.create(QuestionService.class);
        }
        return questionService;
    }

    public interface QuestionService {

        @POST("/api/android/datastructure")
        Call<Items> getQuestion();
    }

}
