package EcommerseDemo.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import EcommerseDemo.myapplication.CommnParams;
import EcommerseDemo.myapplication.MainActivity;
import EcommerseDemo.myapplication.R;

public class SignUp   extends AppCompatActivity {
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        mButton=(Button)findViewById(R.id.btnsignup);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent=new Intent(SignUp.this, MainActivity.class);
                startActivity(mIntent);
                finish();
                CommnParams.Islogin=true;
            }
        });
    }
}
