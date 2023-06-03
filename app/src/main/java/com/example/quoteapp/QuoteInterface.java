package com.example.quoteapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteInterface {
    @GET("api/quotes")
    Call<List<ModalClassQuote>>getModal();
}
