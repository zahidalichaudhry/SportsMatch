package com.thinkgeniux.sportsmatch.PojoClasses;

/**
 * Created by Fakhar Ali on 2/1/2019.
 */

public class AccountPojo {
    int images;
    String title;
    String subtitle;

    public AccountPojo(int images, String title, String subtitle) {
        this.images = images;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}
