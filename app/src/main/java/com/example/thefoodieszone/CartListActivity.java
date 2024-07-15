package com.example.thefoodieszone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thefoodieszone.Adaptor.CartListAdaptor;
import com.example.thefoodieszone.Helper.ManagementCart;
import com.example.thefoodieszone.Interface.ChangeNumberItemsListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    public TextView totalFeeTxt,c1,taxTxt,deliveryTxt,totalTxt,emptyTxt;
    private  double tax;
    private ScrollView scrollView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);


        managementCart=new ManagementCart(this);

        initView();
        initList();
        CalculateCart();
        bottomNavigation();


    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout profileBtn=findViewById(R.id.profileBtn);
        LinearLayout  aboutBtn=findViewById(R.id.supprtBtn);
        LinearLayout contact=findViewById(R.id.settingBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,register.class));
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this, AboutusActivity.class));
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this, contactusactivity.class));
            }
        });

    }
    public void initView() {
        recyclerViewList=findViewById(R.id.recyclerView);
        totalFeeTxt=findViewById(R.id.totalFeeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.deliveryTxt);
        totalTxt=findViewById(R.id.totalTxt);
        emptyTxt=findViewById(R.id.emptyTxt);
        scrollView=findViewById(R.id.scrollView3);
        recyclerViewList=findViewById(R.id.cartView);
        c1=findViewById(R.id.Checkout);




    }


    private void initList(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter=new CartListAdaptor(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }
    private void CalculateCart(){
        double percentTax=0.02;
        double delivery=40;

        tax=Math.round((managementCart.getTotalfeee()*percentTax)*100)/100;
        double total=Math.round((managementCart.getTotalfeee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managementCart.getTotalfeee()*100)/100;

        totalFeeTxt.setText("₹"+itemTotal);
        taxTxt.setText("₹"+tax);
        deliveryTxt.setText("₹"+delivery);
        totalTxt.setText("₹"+total);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CartListActivity.this, "Thank you for shopping \n Visit us Again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}