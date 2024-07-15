package com.example.thefoodieszone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thefoodieszone.Domain.FoodDomain;
import com.example.thefoodieszone.Helper.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {
private TextView addToCartBtn;
private TextView titleTxt,feeTxt,descriptionTxt,numberOedertxt;
private ImageView plusBtn,MinusBtn,picFood;
private FoodDomain object;
int numberOrder=1;
private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart=new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {

        object= (FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceID=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceID)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText(("₹"+object.getFee()));
        descriptionTxt.setText(object.getDescription());
        numberOedertxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOedertxt.setText(String.valueOf(numberOrder));
            }
        });

        MinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOedertxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberIncart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }


    private void initView() {
        addToCartBtn=findViewById(R.id.addTocartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOedertxt=findViewById(R.id.numberOrderTxt);
        plusBtn=findViewById(R.id.plusBtn);
        MinusBtn=findViewById(R.id.minusBtn);
        picFood=findViewById(R.id.picfood);

    }
}