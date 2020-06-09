package kr.hs.emrim.tjdusdlfkrhd.internship;

import android.graphics.Bitmap;

import okhttp3.MultipartBody;

public class Article {
    private long id;
    private String title;
    private String contents;
    private Integer heart;
    private String fileLocation;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getHeart() {
        return heart;
    }

    public void setHeart(Integer heart) {
        this.heart = heart;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ",title="+title+
                ", contents='" + contents  +
                ", heart=" + heart +
                ", fileLocation=" + fileLocation +
                '}';
    }
}


