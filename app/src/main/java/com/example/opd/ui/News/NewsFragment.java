package com.example.opd.ui.News;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import com.example.opd.R;

public class NewsFragment extends Fragment {
    ArrayList<News> News = new ArrayList<News>();
    JDBCConnector connnect = new JDBCConnector();
    ListView counterlist;
    ResultSet rs ;
    NewsAdapter newsAdapter;
    public static NewsFragment newInstance(int page) {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    public NewsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setEmptyData();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.main_news, container, false);
        Runnable Newsload = new Runnable() {
            @Override
            public void run() {
                rs = connnect.ConncectToDb(0,5);
                    counterlist.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                while (rs.next()) {
                                    newsAdapter.add(new News(rs.getString(2), rs.getString(3), rs.getBytes(4), rs.getBytes(5)));
                                }
                            }catch (SQLException sqlEx){

                            }
                        }
                    });

            }
        };
        Thread loadthread = new Thread(Newsload);
        loadthread.start();
        return result;
    }
    @Override
    public void onViewCreated (View view,  Bundle savedInstanceState){
        counterlist = view.findViewById(R.id.countriesList);
        newsAdapter = new NewsAdapter(this.getContext(),R.layout.news_fragment,News);
        counterlist.setAdapter(newsAdapter);
        counterlist.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                int a = counterlist.getLastVisiblePosition();
                int b = newsAdapter.getCount();
                if (i == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && (counterlist.getLastVisiblePosition() == newsAdapter.getCount()-1) ){
                    Runnable Newsload = new Runnable() {
                        @Override
                        public void run() {
                            rs = connnect.ConncectToDb(counterlist.getLastVisiblePosition()+1,5);
                            counterlist.post(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        while (rs.next()) {
                                            newsAdapter.add(new News(rs.getString(2), rs.getString(3), rs.getBytes(4), rs.getBytes(5)));
                                        }
                                    }catch (SQLException sqlEx){

                                    }
                                }
                            });

                        }
                    };
                    Thread loadthread = new Thread(Newsload);
                    loadthread.start();
                    // Now your listview has hit the bottom
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
    }
}