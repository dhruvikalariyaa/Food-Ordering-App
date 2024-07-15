package com.example.thefoodieszone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.thefoodieszone.Adaptor.CategoryAdaptor;
import com.example.thefoodieszone.Adaptor.PopularAdaptor;
import com.example.thefoodieszone.Domain.CategoryDomain;
import com.example.thefoodieszone.Domain.FoodDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerviewPopular();
        bottomNavigation();


    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout profileBtn=findViewById(R.id.profileBtn);
        ConstraintLayout orderbtn=findViewById(R.id.orderBtn);
        LinearLayout aboutBtn=findViewById(R.id.supprtBtn);
        LinearLayout contact=findViewById(R.id.settingBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,register.class));
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutusActivity.class));
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, contactusactivity.class));
            }
        });


        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), CartListActivity.class);
                startActivity(intent);
            }
        });
    }
    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);


        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter=new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }
    private void recyclerviewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById((R.id.recyclerView2));
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain>  foodList=new ArrayList<>();
        foodList.add(new FoodDomain("Monster Pizza","monsterpizza","slices paneer,mozzrella cheese,fresh oregano,ground blacck pepper,pizza souce",220.0 ));
        foodList.add((new FoodDomain("Cheese Burger","burger","Alutikki,onion,cheese,Special sauce,Lettuce,tomato",200.0)));
        foodList.add(new FoodDomain("Vegetable Pizza","pizza3","olive oil,vegetable oil,pitted kalamata,cherry tomatoes,fresh oregano",230.0));
        foodList.add(new FoodDomain("Veg Hotdog","hotdog","olive oil,vegetable oil,veg tikki,tomatoes,onions,corn",234.0));
        foodList.add(new FoodDomain("Coke zero","cokezero2","coca cola zero",39.0));
        foodList.add(new FoodDomain("Strwberry Donut","donut","Milk, Colour,strawberry , flour , sprinklers,",239.0));
        adapter2=new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

    }
}