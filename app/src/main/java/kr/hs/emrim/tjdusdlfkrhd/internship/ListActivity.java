package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private TextView textView2;
    private Context mContext;
    private Retrofit retrofit;
    private ImageView postingbtn;
    private ImageView post_backBtn;
    private ImageView mypageBtn;
    public List<Article> articles;
    RecyclerView mRecyclerView;

    SharedPreferences LoginUserInfo;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mContext=this;

        LoginUserInfo = getSharedPreferences("userlogininfo", MODE_PRIVATE);

        retrofit = new Retrofit.Builder().baseUrl(RedayService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        final RedayService apiService = retrofit.create(RedayService.class);

        mRecyclerView = findViewById(R.id.recyclerView1);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        //나라별
        SharedPreferences CountryInfo = mContext.getSharedPreferences("CountryInfo",MODE_PRIVATE);
        String Country = CountryInfo.getString("Country", " ㅎ럴");
        String City = CountryInfo.getString("City", " ㅎ럴");

        Log.d("제발 나라 도시", "진짜야?: "+Country + City);

        textView2 = findViewById(R.id.textView2); //도시 이름 표시
        textView2.setText(City);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        final Call<List<Article>> apiCall = apiService.readCountryArticlesDataAll(Country);

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

        mypageBtn = findViewById(R.id.post_mypage);
        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 저장된 값을 불러오기 위해 같은 네임파일을 찾음.
                String email = LoginUserInfo.getString("email",null);
                Log.d("mytag", "앱 실행 시 유저 정보: " + email);
                Intent intent  = new Intent(getApplicationContext(), MypageActivity.class);;
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        post_backBtn = findViewById(R.id.post_backBtn);
        post_backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        postingbtn = findViewById(R.id.postingbtn);
        postingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WriteActivity.class));
            }
        });

//        ImageView comment_btn = findViewById(R.id.comment_btn);
//        comment_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), CommentActivity.class));
//            }
//        });


    }
}