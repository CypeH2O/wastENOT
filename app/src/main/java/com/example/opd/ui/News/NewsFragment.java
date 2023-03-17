package com.example.opd.ui.News;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.opd.R;

public class NewsFragment extends Fragment {

    private int pageNumber;

    public static NewsFragment newInstance(int page) {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    public NewsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.main_news, container, false);
        LinearLayout addnews = result.findViewById(R.id.nlayout);
        getLayoutInflater().inflate(R.layout.news_fragment,addnews);
        getLayoutInflater().inflate(R.layout.news_fragment,addnews);
        getLayoutInflater().inflate(R.layout.news_fragment,addnews);
        return result;
    }

}