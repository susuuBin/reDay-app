package kr.hs.emrim.tjdusdlfkrhd.internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    SharedPreferences LoginUserInfo;
    SharedPreferences.Editor editor;

    // retrofit
    Retrofit retrofit = (new Retrofit.Builder()).baseUrl(RedayService.URL).addConverterFactory(GsonConverterFactory.create()).build();
    final RedayService apiService = retrofit.create(RedayService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LoginUserInfo = getSharedPreferences("userlogininfo", MODE_PRIVATE);
        editor = LoginUserInfo.edit();

        CardView toList = findViewById(R.id.seoul);

        toList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        ImageView mypageBtn = findViewById(R.id.home_icon);
        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveuserinfo();
                // 저장된 값을 불러오기 위해 같은 네임파일을 찾음.
               // Log.d("mytag", "앱 실행 시 유저 정보 : " + LoginUserInfo.getString("username",null));
                String email = LoginUserInfo.getString("email",null);
                Log.d("mytag", "앱 실행 시 유저 정보: " + email);
                Intent intent  = new Intent(getApplicationContext(), MypageActivity.class);;
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }

    public void saveuserinfo() {
        Call<User> apiCall = apiService.getUser(LoginUserInfo.getString("email",null));
        apiCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                String name = user.getUserName();
                editor.putString("username", name);
                editor.putString("email", user.getEmail());
                editor.commit();
                Log.d("mytag", "username: "+ name);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
