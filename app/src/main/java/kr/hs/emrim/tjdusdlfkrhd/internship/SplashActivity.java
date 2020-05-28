package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashAnimation();
        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                finish();
            }
        };

        handler.sendEmptyMessageDelayed(0, 3000); //3초후 화면전환
    }
    @UiThread
    private void splashAnimation() {
        Animation imageAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_splash);
        ImageView iv = (ImageView)findViewById(R.id.logoimg);

        iv.startAnimation(imageAnim);
    }
}