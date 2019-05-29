package com.example.academytask1.ui.model.server;

import com.example.academytask1.BuildConfig;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {

    private static OkHttpClient sClient;
    private static Retrofit sRetrofit;
    private static Gson sGson;
    private static Api sApi;

    private static OkHttpClient getClient() {
        if (sClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
            sClient = builder.build();
        }
        return sClient;
    }


    private static Retrofit getRetrofit() {
        if (sGson == null) {
            sGson = new Gson();
        }
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_URL)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(sGson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public static Api getApiService() {
        if (sApi == null) {
            sApi = getRetrofit().create(Api.class);
        }
        return sApi;
    }
}
