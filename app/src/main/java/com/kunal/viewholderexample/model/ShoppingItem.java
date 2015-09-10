package com.kunal.viewholderexample.model;

import android.graphics.Color;

/**
 * Created by kunal on 10/9/15.
 */
public class ShoppingItem {

    String itemName;
    String itemPrice;
    boolean isItemInCart;
    int itemButtonColor= Color.parseColor("#E0E0E0");
    String itemQuantity;
    String itemButtonText="NOT ADDED";

    public ShoppingItem(String itemName, String itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemButtonColor() {
        return itemButtonColor;
    }

    public void setItemButtonColor(int itemButtonColor) {
        this.itemButtonColor = itemButtonColor;
    }

    public String getItemButtonText() {
        return itemButtonText;
    }

    public void setItemButtonText(String itemButtonText) {
        this.itemButtonText = itemButtonText;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean isItemInCart() {
        return isItemInCart;
    }

    public void setIsItemInCart(boolean isItemInCart) {
        this.isItemInCart = isItemInCart;
    }
}
