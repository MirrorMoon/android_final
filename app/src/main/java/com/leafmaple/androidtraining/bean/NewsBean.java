package com.leafmaple.androidtraining.bean;


import com.chad.library.adapter.base.entity.MultiItemEntity;

public class NewsBean  implements MultiItemEntity {




    /**
     * id : 1
     * type : 1
     * newsName : 黑马程序员成功入驻合肥，开启江淮学子高薪时代
     * newsTypeName : 黑马新闻
     * img1 : /img/homenews/home_news1.png
     * img2 :
     * img3 :
     * newsUrl : http://bbs.itheima.com/thread-343752-1-1.html?tj
     */

    private int id;
    private int type;
    private String newsName;
    private String newsTypeName;
    private String img1;
    private String img2;
    private String img3;
    private String newsUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsTypeName() {
        return newsTypeName;
    }

    public void setNewsTypeName(String newsTypeName) {
        this.newsTypeName = newsTypeName;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }
    @Override
    public int getItemType() {
        return getType();
    }
}
