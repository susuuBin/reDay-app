package kr.hs.emrim.tjdusdlfkrhd.internship;

import okhttp3.MultipartBody;

public class Article {
    private int id;
    private String title;
    private String contents;
    //private int heart;
    private MultipartBody.Part file;
    private int country_id;

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

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

/*    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }
    }
*/
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
                ", country_id=" + country_id +
                ",title=" + title +
                ", contents='" + contents + '\'' +
               // ", heart=" + heart +
                ", file=" + file +
                '}';
    }
}
