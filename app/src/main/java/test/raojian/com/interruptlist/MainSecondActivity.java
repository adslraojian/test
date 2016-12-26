package test.raojian.com.interruptlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("raojian", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("raojian", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("raojian", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("raojian", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("raojian", "onDestroy()");
    }
}
