package com.example.opd.ui.News;

import static com.example.opd.ui.News.RequestHelper.getNewsFromUrl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
        SwipeRefreshLayout refreshLayout = result.findViewById(R.id.refrech);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                newsAdapter.clear();
               addNews(0,4);
                refreshLayout.setRefreshing(false);
            }
        });
        addNews(0,4);
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
                   addNews(a+1,4);
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
    }
    private void addNews(int startid,int count){

            Runnable Newsload = new Runnable() {
                @Override
                public void run() {

                    try {
                        List<News> newsList = getNewsFromUrl(startid, count);

                    counterlist.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                            for (News n : newsList) {
                                newsAdapter.add(n);
                            }
                        }catch (NullPointerException e){
                            e.printStackTrace();
                        }
                        }
                    });
                    }catch (Throwable e ){
                        e.printStackTrace();
                    }
                }
            };
            Thread loadthread = new Thread(Newsload);
            loadthread.start();

    }
}