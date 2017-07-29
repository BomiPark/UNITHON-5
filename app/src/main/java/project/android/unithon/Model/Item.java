package project.android.unithon.Model;

/**
 * Created by qkrqh on 2017-07-29.
 */

public class Item {

    private String contentImg;
    private String content;
    private String second;
    private String like;
    private String img;

    public Item(){

    }

    public Item(String ContentImg, String content, String second, String like, String img){
        this.contentImg = ContentImg;
        this.content = content;
        this.second = second;
        this.like = like;
        this.img = img;
    }

    public String getContentImg(){
        return contentImg;
    }

    public void setContentImg(String contentImg) {
        this.contentImg = contentImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
