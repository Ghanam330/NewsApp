package com.example.newsultrs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NewsPagerAddapter extends FragmentStateAdapter {
    public NewsPagerAddapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new NewsFragment();
            case 1:
                return new EnglishNewsFragment();
            default:
                return new EgNewsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
