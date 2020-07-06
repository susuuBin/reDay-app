package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences LoginUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginUserInfo = getSharedPreferences("userlogininfo", MODE_PRIVATE);
        final SharedPreferences.Editor editor = LoginUserInfo.edit();

        String check = LoginUserInfo.getString("email",null)+","+LoginUserInfo.getString("password",null);

        Toast.makeText(this, check, Toast.LENGTH_SHORT).show();

        Button LoginBtn = (Button)findViewById(R.id.LoginBtn);

        LoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            }
        });

        Button WriteBtn = (Button)findViewById(R.id.writeBtn);
        WriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WriteActivity.class));
            }
        });

        Button LogoutBtn = findViewById(R.id.LogoutBtn);
        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("email", null);
                editor.putString("password", null);
                editor.putString("username", null);
                editor.commit();
                Toast.makeText(MainActivity.this, "로그아웃 완료", Toast.LENGTH_SHORT).show();
                Log.d("mytag", LoginUserInfo.getString("email",null)+","+LoginUserInfo.getString("password",null)+","+
                        LoginUserInfo.getString("username",null));
            }
        });

        Button mypageBtn = findViewById(R.id.go_mypage);
        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = LoginUserInfo.getString("email",null);
                Log.d("mytag", "앱 실행 시 유저 정보: " + email);
                Intent intent  = new Intent(getApplicationContext(), MypageActivity.class);;
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}
