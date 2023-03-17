package com.example.opd;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.opd.ui.News.NewsFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment resultFragment =null;
        switch (position) {
            case 0:
                resultFragment = PageFragment.newInstance(position);
                break;
            case 1:
                resultFragment = PageFragment.newInstance(position);
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