package com.example.opd.ui.Calculator;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.example.opd.R;
public class CalcFragment extends Fragment {

    private int pageNumber;

    public static CalcFragment newInstance(int page) {
        CalcFragment fragment = new CalcFragment();
        return fragment;
    }

    public CalcFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.calc_start, container, false);

        return result;
    }
}