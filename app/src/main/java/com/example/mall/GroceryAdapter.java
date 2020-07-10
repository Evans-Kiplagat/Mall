package com.example.mall;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.Viewholder> {
    private ArrayList<GroceryItems>  groceryItemsList =new ArrayList<>();
    private Context context;

    public GroceryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);

        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        holder.txtName.setText(groceryItemsList.get(position).getName());
       holder.txtPrice.setText(String.valueOf(groceryItemsList.get(position).getPrice()));

        Glide.with(context)
                .asBitmap()
                .load(groceryItemsList.get(position).getImageUrl())
                .into(holder.imageView);

          holder.pare.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(context,Grocery_Activity.class);
                  intent.putExtra("key",groceryItemsList.get(position));
                  context.startActivity(intent);
              }
          });
    }

    @Override
    public int getItemCount() {
        return groceryItemsList.size();
    }



    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtName;
        private TextView txtPrice;
        private CardView pare;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.image);
            txtName=itemView.findViewById(R.id.txtname);
            txtPrice=itemView.findViewById(R.id.txtprice);
            pare=itemView.findViewById(R.id.parent);
        }
    }

    public void setGroceryItemsList(ArrayList<GroceryItems> groceryItemsList) {
        this.groceryItemsList = groceryItemsList;
        notifyDataSetChanged();
    }
}
