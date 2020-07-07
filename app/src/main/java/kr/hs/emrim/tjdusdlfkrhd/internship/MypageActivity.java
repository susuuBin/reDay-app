package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MypageActivity extends AppCompatActivity {
    SharedPreferences UserInfo;
    private RecyclerView mRecyclerView;
    protected String username;
    private String email;
    public List<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Retrofit retrofit = (new Retrofit.Builder()).baseUrl(RedayService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        final RedayService apiService = retrofit.create(RedayService.class);

        mRecyclerView = findViewById(R.id.mypageView);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        email = Objects.requireNonNull(getIntent().getExtras()).getString("email");
        System.out.println("MyPageActivity email = "+ email);

        final Call<List<Article>> apiCall = apiService.readArticlesData(email);

        apiCall.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                articles = response.body();

                MypageAdapter mAdapter = new MypageAdapter((ArrayList) articles);
                mRecyclerView.setAdapter(mAdapter);

                Log.d("mytag", articles.toString());
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                Log.d("mytag", "fail" + t.getMessage());
            }


        });

        ImageView mypage_backBtn = findViewById(R.id.mypage_backBtn);
        mypage_backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView mypage_homeBtn = findViewById(R.id.mypage_backBtn);
        mypage_homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

        Button setting= findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));;
            }
        });

        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

//        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
//        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
//        ts1.setContent(R.id.좋아요) ;
//        ts1.setIndicator("좋아요",getResources().getDrawable(R.drawable.toggle_mypage_heart));
//        tabHost1.addTab(ts1)  ;

        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.글) ;
        ts1.setIndicator("작성한 글",getResources().getDrawable(R.drawable.toggle_mypage_write));
        tabHost1.addTab(ts1) ;

        TextView name = findViewById(R.id.username);
        TextView email = findViewById(R.id.useremail);

        UserInfo = getSharedPreferences("userlogininfo", MODE_PRIVATE);
        String nameText = UserInfo.getString("username",null);
        name.setText(nameText);

        String emailText = UserInfo.getString("email", null);
        email.setText(emailText);

    }
}