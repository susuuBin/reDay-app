package kr.hs.emrim.tjdusdlfkrhd.internship;

import okhttp3.MultipartBody;

public class Article {
    private int id;
    private String title;
    private String contents;
    private int heart;
    private MultipartBody.Part file;
    private int user_id;
    private int country_id;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public MultipartBody.Part getFile() {
        return file;
    }

    public void setFile(MultipartBody.Part file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ",title="+title+
                ", contents='" + contents + '\'' +
                ", heart=" + heart +
                ", file=" + file +
                ", user_id=" + user_id +
                ", country_id=" + country_id +
                '}';
    }
}
