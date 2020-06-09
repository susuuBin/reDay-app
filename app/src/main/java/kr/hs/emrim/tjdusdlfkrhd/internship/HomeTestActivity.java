package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeTestActivity extends AppCompatActivity {
    LinearLayout home;
    private ImageView home_icon;
    private ImageView postingbtn;
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    public List<Countries> countries;

    SharedPreferences LoginUserInfo;
    SharedPreferences.Editor editor;

    Retrofit retrofit = (new Retrofit.Builder()).baseUrl(RedayService.URL).addConverterFactory(GsonConverterFactory.create()).build();
    final RedayService apiService = retrofit.create(RedayService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_test);

        mRecyclerView = findViewById(R.id.home_recyclerView);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        final Call<List<Countries>> apiCall = apiService.readCountriesDataAll();

        apiCall.enqueue(new Callback<List<Countries>>() {
            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
                countries = response.body();

                CustomAdapter mAdapter = new CustomAdapter((ArrayList) countries);
                mRecyclerView.setAdapter(mAdapter);

                Log.d("mytag", countries.toString());
            }

            @Override
            public void onFailure(Call<List<Countries>> call, Throwable t) {
                Log.d("mytag", "fail" + t.getMessage());
            }
        });

        home_icon = findViewById(R.id.post_mypage);
        home_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveuserinfo();
                // 저장된 값을 불러오기 위해 같은 네임파일을 찾음.
                Log.d("mytag", "앱 실행 시 유저 정보: "+LoginUserInfo.getString("username",null));
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        postingbtn = findViewById(R.id.postingbtn);
        postingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WriteActivity.class));
            }
        });

        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

//        mAdapter = new HomeAdapter(countries, getApplicationContext());
//        mRecyclerView.setAdapter(mAdapter);

    }

    public void saveuserinfo() {
        Call<User> apiCall = apiService.getUser(LoginUserInfo.getString("email",null));
        apiCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                String name = user.getUserName();
                editor.putString("username", name);
                editor.commit();
                Log.d("mytag", "username: "+name);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
