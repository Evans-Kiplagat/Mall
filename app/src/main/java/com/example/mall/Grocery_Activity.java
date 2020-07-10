package com.example.mall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Grocery_Activity extends AppCompatActivity {
    private Button btnADD;
    private RecyclerView recyclerViewReviews;
    private TextView txtName,txtPrice,txtDescription,txtReviews;
    private ImageView imageEmpty1,imageFilled1,imageEmpty2,imageFilled2,imageEmpty3,imageFilled3,imageView;
    private RelativeLayout firstRelLayout,secondRelLayout,thirdReLayout;
    private GroceryItems incomingItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_);
        initViews();

        Intent intent =getIntent();
        if (null != intent) {
            incomingItem =intent.getParcelableExtra("key");
            if (null != incomingItem){
                txtName.setText(incomingItem.getName());
                txtPrice.setText(String.valueOf(incomingItem.getPrice() + "ksh"));
                txtDescription.setText(incomingItem.getDescription());

                Glide.with(this)
                        .asBitmap()
                        .load(incomingItem.getImageUrl())
                        .into(imageView);
            }
        }
    }

    private void initViews() {
        btnADD=findViewById(R.id.btnAddToCart);
        recyclerViewReviews =findViewById(R.id.RecyclerReviews);
        txtName=findViewById(R.id.name);
        txtPrice=findViewById(R.id.price);
        txtDescription=findViewById(R.id.Descriptions);
        txtReviews=findViewById(R.id.reviews);
        imageEmpty1=findViewById(R.id.empty1);
        imageFilled1=findViewById(R.id.filledStar1);
        imageEmpty2=findViewById(R.id.secondEmpty);
        imageFilled2=findViewById(R.id.SecondFilledStar);
        imageEmpty3=findViewById(R.id.thirdEmpty);
        imageFilled3=findViewById(R.id.thirdFilledStar);
        firstRelLayout=findViewById(R.id.firstRelStar);
        secondRelLayout=findViewById(R.id.SecondRelStar);
        thirdReLayout=findViewById(R.id.ThirdRelStar);
        imageView=findViewById(R.id.imageCart);
    }
}
