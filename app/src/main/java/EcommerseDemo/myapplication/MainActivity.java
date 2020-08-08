package EcommerseDemo.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import EcommerseDemo.myapplication.activities.CartList;
import EcommerseDemo.myapplication.activities.LoginActivity;
import EcommerseDemo.myapplication.adapter.Product;
import EcommerseDemo.myapplication.adapter.productsAdapter;
import EcommerseDemo.myapplication.frafments.AddtoCart;

public class MainActivity extends AppCompatActivity {
    productsAdapter productsAdapter;
FrameLayout mFrameLayoutmainlayout,fmContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this.getWindow().setFlags(WindowManager.LayoutParams.FLA, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
         mFrameLayoutmainlayout = findViewById(R.id.mainlayout);
        fmContainer = findViewById(R.id.fmContainer);

        //Create new ProductsAdapter
        productsAdapter = new productsAdapter(this);
        feedData();
        //Create new GridLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,
                2,//span count no of items in single row
                GridLayoutManager.VERTICAL,//Orientation
                false);//reverse scrolling of recyclerview
        //set layout manager as gridLayoutManager
        recyclerViewProducts.setLayoutManager(gridLayoutManager);
        recyclerViewProducts.setAdapter(productsAdapter);




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);

        // return true so that the menu pop up is opened
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.feeds:

//              callFragment(new AddtoCart());
                if(CommnParams.products.size()>0) {
                    Intent mIntent = new Intent(MainActivity.this, CartList.class);
                    startActivity(mIntent);
                }
                break;

        }
        return true;
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
        final List<Product> products = new ArrayList<>();
        int[] imageUrls = {R.mipmap.img, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4};
        String[] ProductName = {"Kingsmon Jacket", "Adidas Jacket", "Butterfly Jacket", "Puma Jacket"};
        String[] ProductPrice = {"$594", "$500", "$200", "$199"};
        boolean[] isNew = {true, false, false, true};
        for (int i = 0; i < imageUrls.length; i++) {
            Product product = new Product(imageUrls[i],
                    ProductName[i],
                    ProductPrice[i],
                    isNew[i]);
            products.add(product);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //hide loading
                productsAdapter.hideLoading();
                //add products to recyclerview
                productsAdapter.addProducts(products);
            }
        }, 1000);
    }
}
