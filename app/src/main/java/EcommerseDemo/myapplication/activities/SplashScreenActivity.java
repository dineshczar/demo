package EcommerseDemo.myapplication.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import EcommerseDemo.myapplication.CommnParams;
import EcommerseDemo.myapplication.MainActivity;
import EcommerseDemo.myapplication.R;


public class SplashScreenActivity extends Activity {
    boolean isLoggedIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        handleSplashThread();
    }



    private void handleSplashThread() {
       /* final boolean isAppOpenFirstTime = prefsManager.getBoolean(PrefsKeys.IS_APP_OPENED_FIRST_TIME, true);
        if (isAppOpenFirstTime) {
            prefsManager.saveBoolean(PrefsKeys.IS_APP_OPENED_FIRST_TIME, false);
            if (!marshmallowPermission.requestPermissions(Manifest.permission.ACCESS_FINE_LOCATION)) {
                return;
            }
        }*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    /*if (!isInActivity) {
                        return;
                    }*/

                    Intent mIntent=new Intent(SplashScreenActivity.this,

                            CommnParams.Islogin==false? LoginActivity.class: MainActivity.class);
                    startActivity(mIntent);
                     finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        isInActivity = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
//        isInActivity = false;
    }


}
