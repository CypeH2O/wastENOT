package com.example.opd;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.opd.ui.Calculator.CalcFragment;
import com.example.opd.ui.Calculator.Calculator_activity;
import com.example.opd.ui.News.ExtendenNewsActivity;
import com.example.opd.ui.News.NewsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.advice_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.advice_save) {
            AssetManager assetManager = getAssets();
            String str = "Hello world";
            try {
                int randint = 1 + (int)(Math.random() * ((30 - 1) + 1));
                InputStream input = assetManager.open("text/advise.txt");
                byte[] bytes = new byte[input.available()];
                input.read(bytes);
                String text = new String (bytes);

                str = text.substring(text.indexOf(Integer.toString(randint)),text.indexOf("\n",text.indexOf(Integer.toString(randint))));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), str, Snackbar.LENGTH_SHORT);
snackbar.show();

        }else if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //установка изначального layout
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_table_rows_24);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager2 pager = findViewById(R.id.pager);
        pager.setUserInputEnabled(false);
        //адаптер нужен для перелистывания страниц
        FragmentStateAdapter pageAdapter = new FragmentAdapter(this);
        pager.setAdapter(pageAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        //медиатор нужен для анимации нижней панели
        TabLayoutMediator tabLayoutMediator= new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setIcon(R.drawable.map);
                        tab.setText("Карта");
                        break;
                    case 1:
                        tab.setIcon(R.drawable.calc);
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
    public void StartEcoTest(View view){
        Intent intent = new Intent(this, Calculator_activity.class);
        startActivity(intent);
    }


}