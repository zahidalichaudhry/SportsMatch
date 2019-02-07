package com.thinkgeniux.sportsmatch.PojoClasses;

public class Stories
{
    private String ID;
    private String categName;
    private int categImage;
//    private String createdAt;
//    private String updatedAt;

    public Stories(String ID, String categName, int categImage) {
        this.ID = ID;
        this.categName = categName;
        this.categImage = categImage;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCategName() {
        return categName;
    }

    public void setCategName(String categName) {
        this.categName = categName;
    }

    public int getCategImage() {
        return categImage;
    }

    public void setCategImage(int categImage) {
        this.categImage = categImage;
    }


//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(String updatedAt) {
//        this.updatedAt = updatedAt;
//    }
}
