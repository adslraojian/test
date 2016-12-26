package test.raojian.com.interruptlist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TableLayout;

import com.example.raojian.mylibrary.TestJar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentsAdapter frAdapter;
    private String[] titleStr = {"第一页", "第二页"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setUpListener();
    }

    private void setUpListener() {

    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        frAdapter = new FragmentsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(frAdapter);
        int count = frAdapter.getCount();
//        for (int i = 0; i < count; ++i) {
//            String str = (String) frAdapter.getPageTitle(i);
//            TabLayout.Tab tab = tabLayout.newTab().setText(str);
//            tabLayout.addTab(tab);
//
//        }
        tabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
    }

    private void initData() {

    }

    class FragmentsAdapter extends FragmentPagerAdapter {


        public FragmentsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new MainActivityFragment();
            } else {
                return new SecondFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleStr[position];
        }



    }


    @Override
    protected void onStart() {
        super.onStart();
        TestJar<String> jar = new TestJar<>("hehe");
//        (Class)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Log.e("raojian", "onStart()1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("raojian", "onResume()1");
        viewPager.setCurrentItem(1, true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("raojian", "onPause()1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("raojian", "onStop()1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("raojian", "onDestroy()1");
    }
}
