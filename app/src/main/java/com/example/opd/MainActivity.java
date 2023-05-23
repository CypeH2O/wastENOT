package com.example.opd;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

import com.example.opd.ui.AboutUsActivity;
import com.example.opd.ui.Calculator.CalcFragment;
import com.example.opd.ui.Calculator.Calculator_activity;
import com.example.opd.ui.News.ExtendenNewsActivity;
import com.example.opd.ui.News.NewsFragment;
import com.example.opd.ui.settings.SettingsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    boolean leftMenuOpen = false;
    int randint;
    String str;
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
            str = "Hello world";
            try {
                InputStream input = assetManager.open("text/advise.txt");
                byte[] bytes = new byte[input.available()];
                input.read(bytes);
                String text = new String (bytes);
                String[] lines = text.split("\r\n|\r|\n");
                //str = text.substring(text.indexOf(Integer.toString(randint)),text.indexOf("\n",text.indexOf(Integer.toString(randint))));
                randint = 1 + (int)(Math.random() * ((lines.length - 1) + 1));
                str=lines[randint];

                Dialog dialog = new Dialog(MainActivity.this);
                // Установите заголовок
                dialog.setTitle("Заголовок диалога");
                dialog.setContentView(R.layout.dialog_view);
                TextView textview = (TextView) dialog.findViewById(R.id.DialogtextView);
                textview.setText(str);
                dialog.show();

                Button buttonnext = (Button) dialog.findViewById(R.id.buttonNext);
                buttonnext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        randint=(randint+1)%(lines.length);
                        if (randint==0){randint=1;}
                        str = lines[randint];
                        textview.setText(str);
                        dialog.show();
                    }
                });

                Button buttonprev = (Button) dialog.findViewById(R.id.buttonPrev);
                buttonprev.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        randint=(randint+lines.length-1)%(lines.length);
                        str = lines[randint];
                        textview.setText(str);
                        dialog.show();
                    }
                });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        }else if(id == android.R.id.home){
            if(leftMenuOpen){
                drawerLayout.closeDrawer(Gravity.LEFT);
                leftMenuOpen = false;
            }else{
                drawerLayout.openDrawer(GravityCompat.START);
                leftMenuOpen = true;
            }

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //установка изначального layout
        setLang();
        setContentView(R.layout.activity_main);
        setNavigationViewListener();
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
                        tab.setText(R.string.title_map);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.calc);
                        tab.setText(R.string.title_calc);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_notifications_black_24dp);
                        tab.setText(R.string.title_news);
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
    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @SuppressLint("NonConstantResourceId") //надо ибо Warning: Resource IDs will be non-final by default in Android Gradle Plugin version 8.0, avoid using them in switch case statements
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.settings: {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.about:{
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.share:{
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                //shareIntent.setAction(Intent.ACTION_VIEW);
                String shareBody = "Лучшее эко-приложение: \r\nhttps://github.com/CypeH2O/PolyECO/tree/NewsBranch";
                //СОЗДАТЬ README ФАЙЛ И ДАТЬ ССЫЛКУ НА НЕГО
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Поделиться"));
                break;
            }
        }
        //close navigation drawer
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    private void setLang(){
        SharedPreferences sp = this.getSharedPreferences("language", Context.MODE_PRIVATE);

        String languageToLoad  = sp.getString("language","ru"); // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }
}