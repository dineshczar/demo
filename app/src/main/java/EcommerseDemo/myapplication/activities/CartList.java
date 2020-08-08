package EcommerseDemo.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import EcommerseDemo.myapplication.CommnParams;
import EcommerseDemo.myapplication.R;
import EcommerseDemo.myapplication.adapter.CartProduct;
import EcommerseDemo.myapplication.adapter.Product;
import EcommerseDemo.myapplication.adapter.cartproductadapter;
import EcommerseDemo.myapplication.adapter.productsAdapter;

public class CartList extends AppCompatActivity {
    cartproductadapter productsAdapter;
    Button mButton;
    FrameLayout mFrameLayoutmainlayout,fmContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this.getWindow().setFlags(WindowManager.LayoutParams.FLA, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.cartlist);


        RecyclerView recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        mButton = findViewById(R.id.pay);
        mFrameLayoutmainlayout = findViewById(R.id.mainlayout);
        fmContainer = findViewById(R.id.fmContainer);

        //Create new ProductsAdapter
        productsAdapter = new cartproductadapter(this);
        feedData();
        //Create new GridLayoutManager
      /*  GridLayoutManager gridLayoutManager = new GridLayoutManager(this,
                2,//span count no of items in single row
                GridLayoutManager.VERTICAL,//Orientation
                false);//reverse scrolling of recyclerview*/
        //set layout manager as gridLayoutManager

        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this
                , LinearLayoutManager.VERTICAL, false));
        recyclerViewProducts.setAdapter(productsAdapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent=new Intent(CartList.this, Payment.class);
                startActivity(mIntent);
                finish();

            }
        });


    }


    private void callFragment(Fragment fragment) {
        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();

        // fragment.setArguments(bundle);
        ft.add(R.id.fmContainer, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void feedData() {
        //show loading in recyclerview
        productsAdapter.showLoading();
        List<CartProduct> products = new ArrayList<>();
        products=CommnParams.products;
        int[] imageUrls = {R.mipmap.img, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4};
        String[] ProductName = {"Kingsmon Jacket", "Adidas Jacket", "Butterfly Jacket", "Puma Jacket"};
        String[] ProductPrice = {"$594", "$500", "$200", "$199"};
        boolean[] isNew = {true, false, false, true};
//        for (int i = 0; i < imageUrls.length; i++) {
//            CartProduct product = new CartProduct(imageUrls[i],
//                    ProductName[i],
//                    ProductPrice[i],
//                    isNew[i]);
//            products.add(product);
//        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //hide loading
                productsAdapter.hideLoading();
                //add products to recyclerview
                productsAdapter.addProducts(CommnParams.products);
            }
        }, 1000);
    }
}

