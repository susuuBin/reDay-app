package kr.hs.emrim.tjdusdlfkrhd.internship;

public class MypageData {

    private int re_image1;
    private String re_username;
    private String re_text1;
    private String re_text2;
    private int re_image2;

    public MypageData(int re_image1, String re_username, String re_text1, String re_text2, int re_image2) {
        this.re_image1 = re_image1;
        this.re_username = re_username;
        this.re_text1 = re_text1;
        this.re_text2 = re_text2;
        this.re_image2 = re_image2;
    }


    public int getRe_image1() {
        return re_image1;
    }

    public void setRe_image1(int re_image1) {
        this.re_image1 = re_image1;
    }

    public String getRe_username() {
        return re_username;
    }

    public void setRe_username(String re_username) {
        this.re_username = re_username;
    }

    public String getRe_text1() {
        return re_text1;
    }

    public void setRe_text1(String re_text1) {
        this.re_text1 = re_text1;
    }

    public String getRe_text2() {
        return re_text2;
    }

    public void setRe_text2(String re_text2) {
        this.re_text2 = re_text2;
    }

    public int getRe_image2() {
        return re_image2;
    }

    public void setRe_image2(int re_image2) {
        this.re_image2 = re_image2;
    }
}
