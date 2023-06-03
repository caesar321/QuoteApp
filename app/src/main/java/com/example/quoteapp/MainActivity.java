package com.example.quoteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterClass adapter;
    ProgressBar progressBar;
    List<ModalClassQuote> modalClassQuotes= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recyclerView);
        adapter= new AdapterClass(modalClassQuotes,getApplicationContext());
        progressBar= findViewById(R.id.progressBar);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
            fetchData();
    }

    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        RetrofitCli.quoteInterface().getModal().enqueue(new Callback<List<ModalClassQuote>>() {
            @Override
            public void onResponse(Call<List<ModalClassQuote>> call, Response<List<ModalClassQuote>> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    modalClassQuotes.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<ModalClassQuote>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}