package com.flowz.learnkotlin;

import java.io.Serializable;

public class ArticleModel implements Serializable {

    public String id;
    public String name;
    public String title;
    public String image;
    public String weblink;

    public  ArticleModel (){}

    public  ArticleModel (String name, String title, String image, String weblink){
        this.setId(id);
        this.setImage(image);
        this.setName(name);
        this.setTitle(title);
        this.setWeblink(weblink);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(String id) { this.id = id; }


    public String getImage() { return image; }

    public String getTitle() {
        return title;
    }

    public String getWeblink() {
        return weblink;
    }

    public String getName() {
        return name;
    }

    public String getId() { return id; }
}
