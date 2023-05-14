package com.example.opd.ui.Calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.opd.R;

import java.util.List;

public class CalcFragmentAdapter extends ArrayAdapter<CalcFragmentToOneValuesData> {
    private LayoutInflater inflater;
    private int layout;
    private List<CalcFragmentToOneValuesData> calcFragment;

    public CalcFragmentAdapter(Context context, int resource, List<CalcFragmentToOneValuesData> calcFragment) {
        super(context, resource, calcFragment);
        this.calcFragment = calcFragment;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        TextView mainText = view.findViewById(R.id.texthome);
        TextView leftText = view.findViewById(R.id.left_text);
        TextView units = view.findViewById(R.id.units);

        CalcFragmentToOneValuesData fragment = calcFragment.get(position);

        mainText.setText(fragment.getMainText());
        leftText.setText(fragment.getLeftText());
        units.setText(fragment.getUnits());

        return view;
    }
}
