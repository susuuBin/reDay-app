package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private ArrayList<Article> mArrayList;
    private CustomAdapter mAdapter;

    public List<Article> articles;
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView mypageBtn = findViewById(R.id.post_mypage);
        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 저장된 값을 불러오기 위해 같은 네임파일을 찾음.
//                Log.d("mytag", "앱 실행 시 유저 정보: "+LoginUserInfo.getString("username",null));
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        ImageView post_backBtn = findViewById(R.id.post_backBtn);
        post_backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView postingbtn = findViewById(R.id.postingbtn);
        postingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WriteActivity.class));
            }
        });

        retrofit = new Retrofit.Builder().baseUrl(RedayService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        final RedayService apiService = retrofit.create(RedayService.class);

        mRecyclerView = findViewById(R.id.recyclerView1);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        final Call<List<Article>> apiCall = apiService.readArticlesDataAll();



        apiCall.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                articles = response.body();

                CustomAdapter mAdapter = new CustomAdapter((ArrayList) articles);
                mRecyclerView.setAdapter(mAdapter);

                Log.d("mytag", articles.toString());
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                Log.d("mytag", "fail" + t.getMessage());
            }
        });


    }
}
