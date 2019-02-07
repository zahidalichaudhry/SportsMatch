package com.thinkgeniux.sportsmatch.PojoClasses;

/**
 * Created by Fakhar Ali on 1/25/2019.
 */

public class MyVideoPojo {
    int image;
    String title;
    String detials;

    public MyVideoPojo(int image, String title, String detials) {
        this.image = image;
        this.title = title;
        this.detials = detials;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetials() {
        return detials;
    }

    public void setDetials(String detials) {
        this.detials = detials;
    }
}
