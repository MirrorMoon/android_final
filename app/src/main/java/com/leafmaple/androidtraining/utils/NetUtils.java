package com.leafmaple.androidtraining.utils;

import com.github.leonardoxh.livedatacalladapter.LiveDataCallAdapterFactory;
import com.github.leonardoxh.livedatacalladapter.LiveDataResponseBodyConverterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtils {
    public static final String BASE_URL = "http://10.0.2.2:8080/topline/";
    public static GetRequest get(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //转换LiveData数据
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(LiveDataResponseBodyConverterFactory.create())
                //JSON转换
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       return retrofit.create(GetRequest.class);
    }
}
