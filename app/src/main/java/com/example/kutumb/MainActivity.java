package com.example.kutumb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
     RecyclerView r;
     List<Post> p;
     SwipeRefreshLayout refreshLayout;
     ShimmerFrameLayout s;
     parentAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=findViewById(R.id.parent);
        refreshLayout=findViewById(R.id.swipe);
        s=findViewById(R.id.shimmer);
        refresh();
       s.startShimmerAnimation();
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               refresh();
                refreshLayout.setRefreshing(false);
            }
        });
    }
    public void refresh()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://gh-trending-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholder jsonPlaceholder=retrofit.create(JSONPlaceholder.class);
        Call<List<Post>> call=jsonPlaceholder.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                p=response.body();
                s.stopShimmerAnimation();
                s.setVisibility(View.GONE);
                LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
                adaptor=new parentAdaptor(MainActivity.this,p,MainActivity.this);
                r.setLayoutManager(layoutManager);
                r.setAdapter(adaptor);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                s.stopShimmerAnimation();
                Intent i=new Intent(MainActivity.this,nonetwork.class);
                startActivity(i);
            }
        });
    }
}