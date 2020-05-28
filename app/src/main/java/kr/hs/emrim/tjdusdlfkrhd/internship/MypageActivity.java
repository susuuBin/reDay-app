package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MypageActivity extends AppCompatActivity {
    private Context mContext;
    private ArrayList<MypageData> arrayList;
    private MypageAdapter mypageAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

    recyclerView =(RecyclerView)findViewById(R.id.rerere);

    linearLayoutManager =new LinearLayoutManager(this);
    recyclerView.setLayoutManager(linearLayoutManager);

    arrayList =new ArrayList<>();
    mypageAdapter =new MypageAdapter(arrayList);
    recyclerView.setAdapter(mypageAdapter);


}

}
