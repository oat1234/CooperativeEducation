package com.finalproject.cooperativeeducation.manager;

import android.util.Log;

import com.finalproject.cooperativeeducation.Util.BaseConfig;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Picked on 2/5/16.
 */
public class RestServiceManager {
    public static String BASE_URL = BaseConfig.prefixUrl();

    public static <T> T create(final Class<T> service) {
        return create(service, new Gson());
    }

    public static <T> T create(final Class<T> service, Gson gson) {
        Log.i("GSON", "test : "+gson);
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(service);
    }

    public static <T> T create(final Class<T> service, Gson gson, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(service);
    }

    private static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).addInterceptor(new HeaderInterceptor()).build();
        return client;
    }

    public static class HeaderInterceptor
            implements Interceptor {
        @Override
        public Response intercept(Chain chain)
                throws IOException {
            Request request = chain.request();
            request = request.newBuilder().build();
            Response response = chain.proceed(request);
            return response;
        }
    }

}
