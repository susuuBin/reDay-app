package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignInActivity extends AppCompatActivity {
    public String email;

    SharedPreferences LoginUserInfo;
    SharedPreferences.Editor editor;

    RedayService apiService;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // 저장된 값을 불러오기 위해 같은 네임파일을 찾음.
        LoginUserInfo = getSharedPreferences("userlogininfo", MODE_PRIVATE);
        editor = LoginUserInfo.edit();
        // text에 key값이 저장되어있는지 확인. 아무 값도 없으면 ""반환.
        String emailcheck = LoginUserInfo.getString("email",null);
        String passwordcheck = LoginUserInfo.getString("password", null);
//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        // retrofit
        Retrofit retrofit = (new Retrofit.Builder()).baseUrl(RedayService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        apiService = retrofit.create(RedayService.class);

        final EditText useremailEdit = findViewById(R.id.email);
        final EditText userpasswordEdit = findViewById(R.id.password);

        Button signinBtn = findViewById(R.id.signinBtn);
        signinBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // 로그인 정보 확인.
                final String useremail = useremailEdit.getText().toString().trim();
                final String userpassword = userpasswordEdit.getText().toString().trim();
                Log.d("mytag", "email: "+useremail+", password: "+userpassword);
                // 로그인 창 공백인지 아닌지.
                if(useremail.equals("")) {
                    Toast.makeText(SignInActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else if (userpassword.equals("")) {
                    Toast.makeText(SignInActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    final Call<LoginResponse> apiCall = apiService.loginUser(useremail, userpassword);
                    apiCall.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            LoginResponse result = response.body();
                            Log.d("mytag", result.toString());
                            System.out.println(result.toString());
                            if(result.isSuccess()) {
                                Toast.makeText(SignInActivity.this, "로그인 성공",Toast.LENGTH_SHORT).show();
                                editor.putString("email",useremail);
                                editor.putString("password",userpassword);
                                // 유저 이름 저장하는 함수.
                                saveuserinfo();
                                editor.commit();
                                Log.d("mytag", LoginUserInfo.getString("email",null)+", "+LoginUserInfo.getString("password",null));
                                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                                finish();
                            }
                            else {
                                if(result.getReason().equals("user not found.")) {
                                    Toast.makeText(SignInActivity.this, "없는 아이디입니다.", Toast.LENGTH_SHORT).show();
                                    Log.d("mytag", result.getReason());
                                }
                                else {
                                    Toast.makeText(SignInActivity.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.d("mytag", "failure:"+t.toString());
                            Toast.makeText(SignInActivity.this, "에러!", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });

        Button tosignupBtn = findViewById(R.id.signUp);
        tosignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });
    }
    public void saveuserinfo() {
        Call<User> apiCall = apiService.getUser(LoginUserInfo.getString("email",null));
        apiCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                String nickname = user.getUserNickname();
                String email = user.getEmail();
                editor.putString("nickname", nickname);
                editor.putString("email", email);
                editor.commit();
                //Log.d("mytag", "username: "+nickname +"email"+email);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
