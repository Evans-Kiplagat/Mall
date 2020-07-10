package com.example.mall;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class fragment_main extends Fragment {
    private BottomNavigationView navigationView;
    private RecyclerView recyclerViewNewItem,recyclerViewSuggestedItem,recyclerViewPopularItem;
    private GroceryAdapter NewItemAdapter,/*SuggestedItemAdapter,*/PopularItemAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_main,container,false);

        initViews(v);
        initSelected();
        initAdapters();
        return v;
    }

    private void initAdapters() {
        NewItemAdapter =new GroceryAdapter(getActivity());
        recyclerViewNewItem.setAdapter(NewItemAdapter);
        recyclerViewNewItem.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

        GroceryAdapter suggestedViewAdapter = new GroceryAdapter(getActivity());
        recyclerViewSuggestedItem.setAdapter(suggestedViewAdapter);
        recyclerViewSuggestedItem.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));


        PopularItemAdapter = new GroceryAdapter(getActivity());
        recyclerViewPopularItem.setAdapter(PopularItemAdapter);
        recyclerViewPopularItem.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

        ArrayList<GroceryItems> NewItems =utils.getAllItems(getActivity());
        if (null !=NewItems){
            Comparator<GroceryItems> NewItemComparator =new Comparator<GroceryItems>() {
                @Override
                public int compare(GroceryItems o1, GroceryItems o2) {
                    return o1.getId()-o2.getId();
                }
            };
           Collections.sort(NewItems,NewItemComparator);
           NewItemAdapter.setGroceryItemsList(NewItems);

        }

        ArrayList<GroceryItems> PopularItems = utils.getAllItems(getActivity());
        if (null !=PopularItems){
            Comparator<GroceryItems> PopularItemComparator = new Comparator<GroceryItems>() {
                @Override
                public int compare(GroceryItems o1, GroceryItems o2) {
                    return o1.getPopularityPoint()-o2.getPopularityPoint();
                }
            };
            Comparator<GroceryItems> comparatorReverse =Collections.reverseOrder(PopularItemComparator);
            Collections.sort(PopularItems,comparatorReverse);
            PopularItemAdapter.setGroceryItemsList(PopularItems);
        }

        ArrayList<GroceryItems> suggestedItems =utils.getAllItems(getActivity());
        if(null != suggestedItems){
               Comparator<GroceryItems> suggestedComparator = new Comparator<GroceryItems>() {
                   @Override
                   public int compare(GroceryItems o1, GroceryItems o2) {
                       return o1.getUserPoint()-o2.getUserPoint();
                   }
               };
               Comparator<GroceryItems> comparatorReverse =Collections.reverseOrder(suggestedComparator);
               Collections.sort(suggestedItems,suggestedComparator);
               suggestedViewAdapter.setGroceryItemsList(suggestedItems);

        }
    }

    private void initSelected() {
        navigationView.setSelectedItemId(R.id.hommm);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.shoppingCart:
                        Toast.makeText(getActivity(), "wannna do some shoppings ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.hommm:
                        break;
                    case R.id.search:
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

    private void initViews(View v){
        navigationView =v.findViewById(R.id.navigation_bottom_bottom);
        recyclerViewNewItem =v.findViewById(R.id.RecyclerNewItem);
       recyclerViewPopularItem =v.findViewById(R.id.RecyclerPopularItem);
        recyclerViewSuggestedItem =v.findViewById(R.id.RecyclerSuggestedItem);


    }
}
