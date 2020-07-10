package com.example.mall;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class GroceryItems implements Parcelable {
    private int id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private String category;
    private int availableAmount;
    private int rate;
    private int userPoint;
    private int popularityPoint;
    private ArrayList<ReviewModel> reviews;

    public GroceryItems( String name, double price, String description, String imageUrl, String category, int availableAmount) {
        this.id = utils.getID();
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.availableAmount = availableAmount;
        this.rate=0;
        this.userPoint=0;
        this.popularityPoint=0;
        this.reviews =new ArrayList<>();
    }

    protected GroceryItems(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readDouble();
        description = in.readString();
        imageUrl = in.readString();
        category = in.readString();
        availableAmount = in.readInt();
        rate = in.readInt();
        userPoint = in.readInt();
        popularityPoint = in.readInt();
    }

    public static final Creator<GroceryItems> CREATOR = new Creator<GroceryItems>() {
        @Override
        public GroceryItems createFromParcel(Parcel in) {
            return new GroceryItems(in);
        }

        @Override
        public GroceryItems[] newArray(int size) {
            return new GroceryItems[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(int userPoint) {
        this.userPoint = userPoint;
    }

    public int getPopularityPoint() {
        return popularityPoint;
    }

    public void setPopularityPoint(int popularityPoint) {
        this.popularityPoint = popularityPoint;
    }

    public ArrayList<ReviewModel> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<ReviewModel> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "GroceryItems{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                ", availableAmount=" + availableAmount +
                ", rate=" + rate +
                ", userPoint=" + userPoint +
                ", popularityPoint=" + popularityPoint +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeString(category);
        dest.writeInt(availableAmount);
        dest.writeInt(rate);
        dest.writeInt(userPoint);
        dest.writeInt(popularityPoint);
    }
}
