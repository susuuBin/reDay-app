package kr.hs.emrim.tjdusdlfkrhd.internship;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedayService {

    String URL = "http://10.0.2.2:1234";


    @POST("users") // requestparam == Query
    Call<User> createUser(@Query("username") String username, @Query("usernickname") String usernickname, @Query("password") String password, @Query("email") String email);

    @POST("users/login")
    Call<LoginResponse> loginUser(@Query("email") String email, @Query("password") String password);

    @Multipart
    @POST("{username}/articles")
    Call<String> createArticle(@Path("username") String username, @Query("title") String title, @Query("contents") String contents, @Part MultipartBody.Part file);

    // 유저 이름 가져오기.
   /*
    @GET("{email}/getusername")
    Call<String> getUsername(@Path("email") String email);
    */
    @GET("/users/{email}")
    Call<User> getUser(@Path("email") String email);

    @GET("/articles")
    Call<List<Article>> readArticlesDataAll();

    @GET("all_countries")
    Call<List<Countries>> readCountriesDataAll();

    @GET("{country}/articles")
    Call<List<Article>> readCountryArticlesDataAll(@Path("country") String country);

    @GET("{username}/articles")
    Call<List<Article>> readArticlesData(@Path("username") String username);

}
