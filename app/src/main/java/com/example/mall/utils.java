package com.example.mall;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class utils {
    private static int ID=0;
    private static final String ALTERNATIVE_DB="fake database";
    private static  final  String GROCERY_FIRST_ITEMS="grocery";
    private  static  final Gson gson = new Gson();
    private static  final Type type = new TypeToken<ArrayList<GroceryItems>>(){}.getType();

    public static void initSharedPreference(Context context){
        SharedPreferences sharedPreferences =context.getSharedPreferences(ALTERNATIVE_DB,Context.MODE_PRIVATE);
        ArrayList<GroceryItems> allItems =gson.fromJson(sharedPreferences.getString(GROCERY_FIRST_ITEMS,null),type);

        if (null ==allItems){
            intiAllData(context);
        }

    }

    private static void intiAllData(Context c) {
        ArrayList<GroceryItems> items = new ArrayList<>();
        GroceryItems milk =new GroceryItems("Milk Tuzo",440.0,
                "this is a quality kind of milks from tuzo milk campany",
                "https://images.unsplash.com/photo-1549395156-e0c1fe6fc7a5?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60","9",7);
        milk.setPopularityPoint(20);

        items.add(milk);

        GroceryItems TotoBread =new GroceryItems("icebergs",909.0,
                "this is a quality kind of milks from tuzo milk campany",
                "https://i2.wp.com/butterwithasideofbread.com/wp-content/uploads/2019/07/White-Bread_7.bsb_.jpg?ssl=1","9",7);
       TotoBread.setPopularityPoint(3);
        TotoBread.getUserPoint();
        items.add(TotoBread);

        GroceryItems pespi =new GroceryItems("icebergs",909.0,
                "this is a quality kind of milks from tuzo milk campany",
                "https://images-na.ssl-images-amazon.com/images/I/515Lwr5CyxL.jpg","9",7);
       pespi.setPopularityPoint(34);
        pespi.getUserPoint();
        items.add(pespi);


        GroceryItems  soda =new GroceryItems("cocacola",405.0,
                "this is a quality kind of milks from tuzo milk campany",
                "https://images.unsplash.com/photo-1534260164206-2a3a4a72891d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60","9",7);
        soda.setPopularityPoint(2);
        soda.getUserPoint();
        items.add(soda);

        GroceryItems ice_cream =new GroceryItems("icebergs",909.0,
                "ice cream of the sweet taste for kids",
                "https://images.unsplash.com/photo-1497034825429-c343d7c6a68f?ixlib=rb-1.2.1&w=1000&q=80","9",7);
      ice_cream.setPopularityPoint(34);
        ice_cream.getUserPoint();
        items.add(ice_cream);

        GroceryItems Tuzo =new GroceryItems("icebergs",909.0,
                "this is a quality kind of milks from tuzo milk campany think of trying it",
                "https://res-1.cloudinary.com/afsk/c_lpad,dpr_1.0,f_auto,h_533,q_100,w_400/media/catalog/product/t/u/tuzo_1.jpg","9",7);
        Tuzo.setPopularityPoint(34);
        Tuzo.getUserPoint();
        items.add(Tuzo);

        SharedPreferences sharedPreferences=c.getSharedPreferences(ALTERNATIVE_DB,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString(GROCERY_FIRST_ITEMS,gson.toJson(items));
        editor.commit();

    }
    public static ArrayList<GroceryItems> getAllItems(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences(ALTERNATIVE_DB,Context.MODE_PRIVATE);
        ArrayList<GroceryItems> allItems =gson.fromJson(sharedPreferences.getString(GROCERY_FIRST_ITEMS,null),type);
        return allItems;
    }
    public static int getID() {
        ID++;
        return ID;
    }
}
