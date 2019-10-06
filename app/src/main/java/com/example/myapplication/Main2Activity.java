package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.Adapter.FoodAdapter;
import com.example.myapplication.Model.Food;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    public static final int REQUEST_CODE =1;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ArrayList<Food> foods = new ArrayList<>();

        foods.add(new Food("STRAWBERRY JAM OATS", R.drawable.a1, 54800,"1 Variant"));
        foods.add(new Food("RUSTBERRY OATS", R.drawable.a2, 48700,"1 Variant"));
        foods.add(new Food("BERRY CHOCOLATE ALMON OATS ", R.drawable.a3, 56700,"3 Variant"));
        foods.add(new Food("BERRY ALMON BANANA OATS", R.drawable.a4, 48900,"3 Variant "));
        foods.add(new Food("BERRY ORANGE ALMON OATS ", R.drawable.a5, 54800,"3 Variant"));
        foods.add(new Food("BANANA RUSTBERRY OATS", R.drawable.a6, 44800,"2 Variant"));
        foods.add(new Food("ALMON HONEY CHOCOLATE OATS", R.drawable.a7, 34000,"3 Variant"));
        foods.add(new Food("CHOCOLATE ALMON OATS", R.drawable.a8, 2700,"2 Variant"));
        foods.add(new Food("BANANA PARNUT OATS", R.drawable.a9, 18800,"2 Variant"));
        foods.add(new Food("BLUEBERRY STAWBERRY OATS", R.drawable.a10, 25000,"2 Variant"));

        adapter = new FoodAdapter(this, foods);
        ListView orderListView = (ListView) findViewById(R.id.order_list_view);
        orderListView.setAdapter(adapter);
        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Main2Activity.this, FoodDetailActivity.class);
                Food currentFood = foods.get(position);
                Log.e("FOOD NAME",currentFood.getFoodName());
                i.putExtra("name", currentFood.getFoodName());
                i.putExtra("image", currentFood.getmImageResouce());
                i.putExtra("price", currentFood.getFoodPrice());
                i.putExtra("type",currentFood.getType());
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);  }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_cart:
                Intent i = new Intent(Main2Activity.this, ProfileAccount.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
