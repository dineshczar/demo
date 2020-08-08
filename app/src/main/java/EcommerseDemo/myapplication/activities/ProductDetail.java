package EcommerseDemo.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

import EcommerseDemo.myapplication.CommnParams;
import EcommerseDemo.myapplication.MainActivity;
import EcommerseDemo.myapplication.R;
import EcommerseDemo.myapplication.adapter.CartProduct;
import EcommerseDemo.myapplication.adapter.Product;

public class ProductDetail  extends AppCompatActivity implements Serializable, View.OnClickListener {
    ImageView mButtonadd,mButtonSub;
    TextView mTextView,tvProductDetailPrice;
    ImageView mImageView;
    RatingBar mRatingBar;
    EditText mEditTextqty;
    Button mButtonbtnaddtocart;
    private Product currentProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentproductdetail);
        mImageView=(ImageView)findViewById(R.id.ivProductDetailImage) ;
        mRatingBar=(RatingBar)findViewById(R.id.ratingBarProduct) ;
        mTextView=(TextView) findViewById(R.id.tvProductDetailName) ;
        tvProductDetailPrice=(TextView) findViewById(R.id.tvProductDetailPrice) ;
        mButtonadd=(ImageView) findViewById(R.id.ivProductDetailQuantityPlus) ;
        mButtonSub=(ImageView) findViewById(R.id.ivProductDetailQuantityMinus) ;
        mButtonbtnaddtocart=(Button) findViewById(R.id.btnaddtocart) ;
        mEditTextqty=(EditText) findViewById(R.id.qty) ;
        mButtonadd.setOnClickListener(this);
        mButtonSub.setOnClickListener(this);
        mButtonbtnaddtocart.setOnClickListener(this);
        Intent i = getIntent();
         currentProduct = (Product)i.getSerializableExtra("MyClass");
        Picasso.with(this).load(currentProduct.getImageResourceId()).into(mImageView);
        mRatingBar.setNumStars(5);
        mRatingBar.setRating(Float.valueOf("3.0"));
        mTextView.setText(currentProduct.getProductName());
        tvProductDetailPrice.setText(""+currentProduct.getProductPrice());
        mEditTextqty.setText("1");
       // mButton=(Button)findViewById(R.id.btnLogin);
       /* mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mIntent);
            }
        });*/
    }

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.ivProductDetailQuantityPlus:
        if(Integer.valueOf(mEditTextqty.getText().toString())>0) {
            int val = Integer.valueOf(mEditTextqty.getText().toString());
            val = val + 1;
            mEditTextqty.setText(String.valueOf(val));
        }
        break;
    case R.id.ivProductDetailQuantityMinus:
        if(Integer.valueOf(mEditTextqty.getText().toString())>1) {
            int val = Integer.valueOf(mEditTextqty.getText().toString());
            val = val - 1;
            mEditTextqty.setText(String.valueOf(val));
        }
        break;
    case R.id.btnaddtocart:
        CartProduct product = new CartProduct(currentProduct.getImageResourceId(),
                currentProduct.getProductName(),
                currentProduct.getProductPrice(),
               true);
        CommnParams.products.add(product);
        Toast.makeText(this,"Product Added To Cart Successfully",Toast.LENGTH_SHORT).show();
        break;
}
    }
}
