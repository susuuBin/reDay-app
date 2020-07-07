package kr.hs.emrim.tjdusdlfkrhd.internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private Context mContext;
    SharedPreferences LoginUserInfo;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor countryeditor;
    SharedPreferences CountryNameInfo;

    // retrofit
    Retrofit retrofit = (new Retrofit.Builder()).baseUrl(RedayService.URL).addConverterFactory(GsonConverterFactory.create()).build();
    final RedayService apiService = retrofit.create(RedayService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext = this;

        LoginUserInfo = getSharedPreferences("userlogininfo", MODE_PRIVATE);
        editor = LoginUserInfo.edit();
        CountryNameInfo = getSharedPreferences("CountryNameInfo", MODE_PRIVATE);
        countryeditor = CountryNameInfo.edit();

        CardView seoul = findViewById(R.id.seoul);
        final TextView card1_city = findViewById(R.id.card1_city);
        final TextView card1_country = findViewById(R.id.card1_country);

        seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card1_country.getText() + " 도시 : " + card1_city.getText());
                saveCountryInfo(card1_country.getText().toString(), card1_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView osaka = findViewById(R.id.osaka);
        final TextView card2_city = findViewById(R.id.card2_city);
        final TextView card2_country = findViewById(R.id.card2_country);
        osaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card2_city.getText());
                saveCountryInfo(card2_country.getText().toString(), card2_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView newyork = findViewById(R.id.newyork);
        final TextView card3_city = findViewById(R.id.card3_city);
        final TextView card3_country = findViewById(R.id.card3_country);
        newyork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card3_city.getText());
                saveCountryInfo(card3_country.getText().toString(), card3_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView lasvegas = findViewById(R.id.lasvegas);
        final TextView card4_city = findViewById(R.id.card4_city);
        final TextView card4_country = findViewById(R.id.card4_country);
        lasvegas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card4_city.getText());
                saveCountryInfo(card4_country.getText().toString(), card4_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView bangkok = findViewById(R.id.bangkok);
        final TextView card5_city = findViewById(R.id.card5_city);
        final TextView card5_country = findViewById(R.id.card5_country);
        bangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card5_city.getText());
                saveCountryInfo(card5_country.getText().toString(), card5_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView london = findViewById(R.id.london);
        final TextView card6_city = findViewById(R.id.card6_city);
        final TextView card6_country = findViewById(R.id.card6_country);
        london.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card6_city.getText());
                saveCountryInfo(card6_country.getText().toString(), card6_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView machupicchu = findViewById(R.id.machupicchu);
        final TextView card7_city = findViewById(R.id.card7_city);
        final TextView card7_country = findViewById(R.id.card7_country);
        machupicchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card7_city.getText());
                saveCountryInfo(card7_country.getText().toString(), card7_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView salarde = findViewById(R.id.salarde);
        final TextView card8_city = findViewById(R.id.card8_city);
        final TextView card8_country = findViewById(R.id.card8_country);
        salarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card8_city.getText());
                saveCountryInfo(card8_country.getText().toString(), card8_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView paris = findViewById(R.id.paris);
        final TextView card9_city = findViewById(R.id.card9_city);
        final TextView card9_country = findViewById(R.id.card9_country);
        paris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card9_city.getText());
                saveCountryInfo(card9_country.getText().toString(), card9_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView rome = findViewById(R.id.rome);
        final TextView card10_city = findViewById(R.id.card10_city);
        final TextView card10_country = findViewById(R.id.card10_country);
        rome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card10_city.getText());
                saveCountryInfo(card10_country.getText().toString(), card10_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView sydney = findViewById(R.id.sydney);
        final TextView card11_city = findViewById(R.id.card11_city);
        final TextView card11_country = findViewById(R.id.card11_country);
        sydney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card11_city.getText());
                saveCountryInfo(card11_country.getText().toString(), card11_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });


        CardView montreal = findViewById(R.id.montreal);
        final TextView card12_city = findViewById(R.id.card12_city);
        final TextView card12_country = findViewById(R.id.card12_country);
        montreal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card12_city.getText());
                saveCountryInfo(card12_country.getText().toString(), card12_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView kiribati = findViewById(R.id.kiribati);
        final TextView card13_city = findViewById(R.id.card13_city);
        final TextView card13_country = findViewById(R.id.card13_country);
        kiribati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card13_city.getText());
                saveCountryInfo(card13_country.getText().toString(), card13_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView vancouver = findViewById(R.id.vancouver);
        final TextView card14_city = findViewById(R.id.card14_city);
        final TextView card14_country = findViewById(R.id.card14_country);
        vancouver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("cityname", "나라: " + card14_city.getText());
                saveCountryInfo(card14_country.getText().toString(), card14_city.getText().toString());
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
            }
        });

        CardView tanzania = findViewById(R.id.tanzania);
        final TextView card15_city = findViewById(R.id.card15_city);
        final TextView card15_country = findViewById(R.id.card15_country);
        tanzania.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Log.d("cityname", "나라: " + card15_city.getText());
                                            saveCountryInfo(card15_country.getText().toString(), card15_city.getText().toString());
                                            startActivity(new Intent(getApplicationContext(), ListActivity.class));
                                        }
                                    }
        );

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

    public void saveCountryInfo(String country, String city) {
        countryeditor.clear();
        SharedPreferences CountryInfo = getSharedPreferences("CountryInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = CountryInfo.edit();
        editor.putString("Country", country); //First라는 key값으로 infoFirst 데이터를 저장한다.
        editor.putString("City", city); //Second라는 key값으로 infoSecond 데이터를 저장한다.
        editor.commit(); //완료한다.
    }
}
