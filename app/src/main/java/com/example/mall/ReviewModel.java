package com.example.mall;

public class ReviewModel {
    private int groceryId;
    private String userName;
    private String Text;
    private String date;

    public ReviewModel(int groceryId, String userName, String text, String date) {
        this.groceryId = groceryId;
        this.userName = userName;
        Text = text;
        this.date = date;
    }

    public int getGroceryId() {
        return groceryId;
    }

    public void setGroceryId(int groceryId) {
        this.groceryId = groceryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReviewModel{" +
                "groceryId=" + groceryId +
                ", userName='" + userName + '\'' +
                ", Text='" + Text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
