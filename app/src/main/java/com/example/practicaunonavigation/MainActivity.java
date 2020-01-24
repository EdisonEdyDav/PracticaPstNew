package com.example.practicaunonavigation;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.practicaunonavigation.rest.adapter.MarketAdapter;
import com.example.practicaunonavigation.rest.model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Views
    Button ButtonPost;
    EditText EditTextTittle, EditTextDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitViews();
        ButtonPost.setOnClickListener(this);
    }

    //Metodo para iniciar las views

    private void InitViews(){
        ButtonPost=findViewById(R.id.ButtonPost);
        EditTextTittle=findViewById(R.id.EditTextTittle);
        EditTextDescription=findViewById(R.id.EditTextDescription);
    }

    private void PostPosts(){
        MarketAdapter adapter = new MarketAdapter();
        Call<Post> call = adapter.InsertPost(
                new Post(
                        EditTextTittle.getText().toString(),
                        EditTextDescription.getText().toString(),
                        "https://manabinoticias.com/wp-content/uploads/2019/08/mia-kalifa.jpg"
                )
        );
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.e("response", response.body().toString());
                //GetPosts();
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ButtonPost:
                PostPosts();
                break;
        }
    }







}



