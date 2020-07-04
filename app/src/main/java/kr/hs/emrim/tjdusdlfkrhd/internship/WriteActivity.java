package kr.hs.emrim.tjdusdlfkrhd.internship;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class WriteActivity extends AppCompatActivity {

    private Bitmap selPhoto;
    ImageView showPicture;

    SharedPreferences LoginUserInfo;
    String username;
    String title;
    String contentbox;
    MultipartBody.Part part = null;

    TextView titleboxEdit;
    TextView contentboxEdit;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        // Retrofit.Builder();
        Retrofit retrofit = (new Retrofit.Builder()).baseUrl(RedayService.URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        final RedayService apiService = retrofit.create(RedayService.class);

        titleboxEdit = findViewById(R.id.titleBox);
        contentboxEdit = findViewById(R.id.contentBox);
        ImageButton inputimgBtn = findViewById(R.id.inputimage);
        backBtn=findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button postBtn = findViewById(R.id.post);
        showPicture = findViewById(R.id.showpicture);

        LoginUserInfo = getSharedPreferences("userlogininfo", MODE_PRIVATE);
        final SharedPreferences.Editor editor = LoginUserInfo.edit();

        // 유저 이름 가져옴.
        username = LoginUserInfo.getString("username",null);
        Log.d("mytag", "username: "+username);
        if(username == null) {
            Toast.makeText(WriteActivity.this, "로그인을 해 주세요.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), SignInActivity.class));
            finish();
        }

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contentbox = contentboxEdit.getText().toString();
                title = titleboxEdit.getText().toString();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                selPhoto.compress(Bitmap.CompressFormat.PNG, 100, stream);

                RequestBody requestFile = RequestBody.create(MediaType.parse("image/png"), stream.toByteArray());
                part = MultipartBody.Part.createFormData("file", "filename.png", requestFile);
                // 파일 이름 정해야 함.

                Call <String> apiCall = apiService.createArticle(username, title, contentbox, part);
                Log.d("mytag", "이름: "+username);
                apiCall.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("mytag", "업로드 결과: "+response.body());
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        finish();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d("mytag", "업로드 Failure: "+t.toString());
                    }
                });
            }
        });

        inputimgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callGallery();
            }
        });

    }

    final int REQ_SELECT = 1;

    // 갤러리 이미지 얻어오기.
    public void callGallery() {
        Uri uri = Uri.parse("content://media/external/images/media");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,REQ_SELECT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        try {
            if(requestCode == REQ_SELECT) {
                Log.d("mytag", intent.getData().toString());
                // 인텐트에 데이터가 담겨있다면
                if(!intent.getData().equals(null)) {
                    // intent에 담긴 이미지를 uri를 이용해서 bitmap 형태로 읽어 온다.
                    selPhoto = MediaStore.Images.Media.getBitmap(getContentResolver(), intent.getData());
                    selPhoto = Bitmap.createScaledBitmap(selPhoto, 500, 500, true);
                    showPicture.setImageBitmap(selPhoto);
                    Log.d("mytag", "selPhoto : " + selPhoto);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
