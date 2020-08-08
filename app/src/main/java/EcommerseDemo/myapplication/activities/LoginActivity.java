package EcommerseDemo.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import EcommerseDemo.myapplication.CommnParams;
import EcommerseDemo.myapplication.MainActivity;
import EcommerseDemo.myapplication.R;

public class LoginActivity extends AppCompatActivity {
 Button mButton;
 TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actovity_login);
        mButton=(Button)findViewById(R.id.btnLogin);
        mTextView=(TextView) findViewById(R.id.tvSignUp);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(mIntent);
                finish();
                CommnParams.Islogin=true;
            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent=new Intent(LoginActivity.this, SignUp.class);
                startActivity(mIntent);
                finish();

            }
        });
    }
}