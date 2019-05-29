package com.example.academytask1.ui.model.server;

import com.example.academytask1.ui.entity.Response;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Api {

    @GET("devfestapi/data.json")
    Single<Response> getResponse();

}

