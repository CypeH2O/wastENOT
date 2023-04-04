package com.example.opd.ui.News;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.opd.R;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExtendenNewsActivity extends AppCompatActivity {
    JDBCConnector connector = new JDBCConnector();
    ResultSet rs;
    ResultSet rsblob;
    String TextMark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.extended_news);
        LinearLayout mainlayout = findViewById(R.id.root_layout);
        Bundle arguments = getIntent().getExtras();
        Context cont = this;
        Runnable Newsload = new Runnable() {
            @Override
            public void run() {
                rs = connector.GetMarkNewsfromDB(arguments.getInt("num"));
                rsblob = connector.GetBLOBNewsfromDB(arguments.getInt("num"));
                try{
                    rs.next();
                    TextMark = rs.getString(2);
                }catch (SQLException sqlEx){
                    sqlEx.printStackTrace();
                }
                mainlayout.post(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            rs.next();
                            while(TextMark.length() != 0){
                                int SepIndex = TextMark.indexOf("<");
                                if(SepIndex !=-1) {
                                    String sub1;
                                    TextView text = new TextView(cont);
                                    sub1 = TextMark.substring(0, SepIndex);
                                    text.setText(sub1);
                                    TextDeco(text);
                                    mainlayout.addView(text);
                                    byte[] byteimg = null;
                                    String s, s1;
                                    rsblob.beforeFirst();
                                    while (rsblob.next()) {
                                        s = rsblob.getString(2);
                                        s1 = TextMark.substring(SepIndex + 1, TextMark.indexOf(">"));
                                        if (s.equals(s1)) {
                                            byteimg = rsblob.getBytes(3);
                                            break;
                                        }
                                    }
                                    Bitmap bmpimg = BitmapFactory.decodeByteArray(byteimg, 0, byteimg.length);
                                    ImageView img = new ImageView(cont);
                                    img.setImageBitmap(bmpimg);
                                    ImgDeco(img);
                                    mainlayout.addView(img);
                                    TextMark = TextMark.substring(TextMark.indexOf(">")+1,TextMark.length());
                                }else{
                                    TextView text = new TextView(cont);
                                    text.setText(TextMark);
                                    TextDeco(text);
                                    mainlayout.addView(text);
                                    TextMark = "";
                                }


                            }

                        }catch (SQLException sqlEx){
                            sqlEx.printStackTrace();
                        }

                    }
                });

            }
        };
        Thread loadthread = new Thread(Newsload);
        loadthread.start();

       // text.setText( arguments.get("num").toString());
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void TextDeco(TextView text){
        FrameLayout.LayoutParams LParams;
        LParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Linkify.addLinks(text,Linkify.ALL);
        text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        text.setLayoutParams(LParams);

    }
    private void ImgDeco(ImageView Img){
        Img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Img.setAdjustViewBounds(true);
    }
}