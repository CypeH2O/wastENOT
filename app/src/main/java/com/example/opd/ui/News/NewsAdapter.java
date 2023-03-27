package com.example.opd.ui.News;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

        ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layoutid, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        News newart = News.get(position);

        viewHolder.Title.setText(newart.getTitle());
        viewHolder.MainText.setText(newart.getMainText());
        Bitmap Titleimg= BitmapFactory.decodeByteArray(newart.getblobTitleimg(),0,newart.getblobTitleimg().length);
        Bitmap Mainimg= BitmapFactory.decodeByteArray(newart.getblobMainimg(),0,newart.getblobMainimg().length);
        viewHolder.TitleImg.setImageBitmap(Titleimg);
        viewHolder.MainImg.setImageBitmap(Mainimg);
        return convertView;
    }
    private class ViewHolder {
        final ImageView TitleImg, MainImg;
        final TextView Title, MainText;

        ViewHolder(View view) {
            TitleImg = view.findViewById(R.id.titleimg);
            MainImg = view.findViewById(R.id.mainimg);
            Title = view.findViewById(R.id.title);
            MainText = view.findViewById(R.id.main_text);
        }
    }
}
