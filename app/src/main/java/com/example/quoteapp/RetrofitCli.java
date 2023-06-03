package com.example.quoteapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCli {
    private  static  final String BASE_URL= "https://type.fit/";
    private  static Retrofit retrofit = null;
    public static QuoteInterface quoteInterface(){
        if(retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl("https://type.fit/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(QuoteInterface.class);
    }


}
