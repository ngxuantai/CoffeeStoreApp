package com.example.myapplication.DTO;

public class DrinkDTO {
    int DrinkID, CategoryID;
    String DrinkName,Price,Status;
    byte[] Image;

    public int getDrinkID() {
        return DrinkID;
    }

    public void setDrinkID(int drinkId) {
        DrinkID = drinkId;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryId) {
        CategoryID = categoryId;
    }

    public String getDrinkName() {
        return DrinkName;
    }

    public void setDrinkName(String drinkName) {
        DrinkName = drinkName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

}
