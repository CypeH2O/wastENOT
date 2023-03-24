package com.example.opd.ui.News;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.opd.R;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    private LayoutInflater inflater;
    private int layoutid;
    private List<News> News;
    public NewsAdapter(Context context, int resource, List<News> News){
        super(context,resource,News);
        this.News=News;
        this.inflater =LayoutInflater.from( context);
        this.layoutid = resource;
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layoutid, parent, false);

        TextView Title = view.findViewById(R.id.title);
        TextView MainText = view.findViewById(R.id.main_text);

        News newart = News.get(position);

        Title.setText(newart.getTitle());
        MainText.setText(newart.getMainText());
        return view;
    }
}
