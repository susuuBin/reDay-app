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
import android.widget.TabHost;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MypageActivity extends AppCompatActivity {
    SharedPreferences LoginUserInfo;
    SharedPreferences.Editor editor;
    RedayService apiService;
    private Retrofit retrofit;
    private Context mContext;
    private MypageAdapter mypageAdapter;
    private ArrayList<Article> mList;
    private ArrayList<User> mUser;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    protected TextView username;
    protected TextView useremail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);


        ImageView mypage_backBtn = findViewById(R.id.mypage_backBtn);
        mypage_backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.좋아요) ;
        ts1.setIndicator("TAB 1") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.글) ;
        ts2.setIndicator("TAB 2") ;
        tabHost1.addTab(ts2) ;

        ts1.setIndicator("",getResources().getDrawable(R.drawable.toggle_mypage_heart));
        ts2.setIndicator("",getResources().getDrawable(R.drawable.toggle_mypage_write));
    }

}
