package com.example.opd.ui.Calculator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.opd.PageFragment;
import com.example.opd.ui.News.NewsFragment;

public class CalcAdapter extends FragmentStateAdapter {
    public CalcAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment resultFragment =null;
        switch (position) {
            case 0:
                resultFragment = CalcFragment1.newInstance();
                break;
            case 1:
                resultFragment = CalcFragment.newInstance(position);
                break;
            case 2:
                resultFragment = NewsFragment.newInstance(position);
                break;
        }
        return resultFragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
