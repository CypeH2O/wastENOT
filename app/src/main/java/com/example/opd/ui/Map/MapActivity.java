package com.example.opd.ui.Map;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import com.example.opd.R;

public class MapActivity extends Fragment {

    public static MapActivity newInstance(int page) {
        MapActivity map_frag = new MapActivity();
        Bundle args=new Bundle();

        map_frag.setArguments(args);
        return map_frag;
    }

    public MapActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.activity_map, container, false);
        WebView webView = result.findViewById(R.id.webView);
        if(webView != null){
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("https://regreenpolytech.github.io/map/");
        }
//        if(webView != null){
//            webView.getSettings().setJavaScriptEnabled(true);
//            String dataloader = "";
//            try(FileReader reader = new FileReader("map.html"))
//            {
//                // читаем посимвольно
//                dataloader = String.valueOf(reader.read(dataloader.toCharArray()));
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            webView.loadData(dataloader, "text/html", "base64");
//        }
        else{
            Log.e(TAG, "webView is null");
        }

        return result;
    }
}
