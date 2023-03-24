package com.example.opd.ui.News;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    public static NewsFragment newInstance(int page) {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    public NewsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rs = connnect.ConncectToDb();
        setInitialData();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.main_news, container, false);
        return result;
    }
    @Override
    public void onViewCreated (View view,  Bundle savedInstanceState){
        counterlist = view.findViewById(R.id.countriesList);
        NewsAdapter newsAdapter = new NewsAdapter(this.getContext(),R.layout.news_fragment,News);
        counterlist.setAdapter(newsAdapter);
    }
    private void setInitialData(){
        try {
            rs.next();
            News.add(new News (rs.getString(2), rs.getString(3)));
            rs.next();
            News.add(new News (rs.getString(2), rs.getString(3)));
            rs.next();
            News.add(new News (rs.getString(2), rs.getString(3)));
        }catch (SQLException sqlEx){

        }

    }
}