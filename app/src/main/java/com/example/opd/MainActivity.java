package com.example.opd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.opd.ui.News.ExtendenNewsActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //установка изначального laypot
        setContentView(R.layout.activity_main);
        //адаптер нужен для перелистывания страниц
        ViewPager2 pager = findViewById(R.id.pager);
        FragmentStateAdapter pageAdapter = new FragmentAdapter(this);
        pager.setAdapter(pageAdapter);


        TabLayout tabLayout = findViewById(R.id.tab_layout);
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setIcon(R.drawable.ic_home_black_24dp);
                        tab.setText("Карта");
                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_dashboard_black_24dp);
                        tab.setText("Калькулятор");
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_notifications_black_24dp);
                        tab.setText("Новости");
                        break;
                }

            }
        });
        tabLayoutMediator.attach();

    }
    public void ToExtendedNews(View view){
        Intent intent = new Intent(this, ExtendenNewsActivity.class);
        startActivity(intent);
    }



}