package com.example.myapplication.DTO;

public class OrderDetailDTO {
    int OrderID, DrinkID, Quantity;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderId) {
        OrderID = orderId;
    }

    public int getDrinkID() {
        return DrinkID;
    }

    public void setDrinkID(int drinkId) {
        DrinkID = drinkId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
