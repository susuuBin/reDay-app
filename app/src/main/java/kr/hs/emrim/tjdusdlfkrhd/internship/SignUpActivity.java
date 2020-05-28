package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);  // layout xml 과 자바파일을 연결

        // retrofit
        Retrofit retrofit = (new Retrofit.Builder()).baseUrl(RedayService.URL).addConverterFactory(GsonConverterFactory.create()).build();
        final RedayService apiService = retrofit.create(RedayService.class);

        final EditText usernameEdit = findViewById(R.id.ed_name);
        final EditText usernicknameEdit = findViewById(R.id.ed_nickname);
        final EditText useremailEdit = findViewById(R.id.ed_email);
        final EditText userpasswordEdit = findViewById(R.id.ed_password);
        final EditText userpasswordchkEdit = findViewById(R.id.ed_chk_password);

        ImageButton signupBtn = findViewById(R.id.signUpBtn);
        signupBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString();
                String usernickname = usernicknameEdit.getText().toString();
                String useremail = useremailEdit.getText().toString();
                if(!(userpasswordEdit.getText().toString().equals(userpasswordchkEdit.getText().toString()))) {
                    Toast.makeText(SignUpActivity.this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    String userpassword = userpasswordEdit.getText().toString();

                    Call<User> apiCall =apiService.createUser(username, usernickname, userpassword, useremail);
                    apiCall.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            User user = response.body();
                            Log.d("mytag", user.toString());
                            Toast.makeText(SignUpActivity.this, "회원가입 완료", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Log.d("mytag", "failure: "+t.toString());
                        }
                    });
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
//        Toast.makeText(this, "Back button pressed.", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}
