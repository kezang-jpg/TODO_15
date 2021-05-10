package com.example.todo15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout=findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.First));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Second));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Third));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



                ViewPager viewPager=findViewById(R.id.pager);
                PageAdapter adapter=new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
                viewPager.setAdapter(adapter);
               tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
              viewPager.setCurrentItem(tab.getPosition());
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {

          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {

          }
      });
    }
}