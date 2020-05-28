package kr.hs.emrim.tjdusdlfkrhd.internship;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;


public class GuideActivity extends AppCompatActivity {

    int cnt = 0;
    ImageView guideimg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        Button prevBtn = (Button) findViewById(R.id.prevBtn) ;

        guideimg1 = (ImageView)findViewById(R.id.guideimg);

        // 다음 버튼.
        nextBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt++;
                if(cnt> 2) {

                    cnt = 3;


                }
                show();
            }
        });

        // 이전 버튼.
        prevBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt--;
                if(cnt < 0) {
                    cnt = 0;
                }
                show();
            }
        });
    }

    public void show() {
        if(cnt == 0) {
            guideimg1.setImageResource(R.drawable.guide1);
        }
        else if(cnt==1){
            guideimg1.setImageResource(R.drawable.guide2);
        }
        else if(cnt==2) {
            guideimg1.setImageResource(R.drawable.guide3);
        }

        if (cnt == 3) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);//액티비티 띄우기
        }
    }
}

