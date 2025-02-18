package com.example.wintertest.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.wintertest.R;
import com.example.wintertest.ui.fragment.FirstFragment;
import com.example.wintertest.ui.fragment.PersonageFragment;
import com.example.wintertest.ui.fragment.HealthFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    List<Integer> imgs = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout = findViewById(R.id.my_tab);
        viewPager2 = findViewById(R.id.viewPager2);
        imgs.add(R.drawable.table_image_1);
        imgs.add(R.drawable.table_image_3);
        imgs.add(R.drawable.table_image_4);
        titles.add("首页");
        titles.add("健康");
        titles.add("个人");
        fragments.add(new FirstFragment());
        fragments.add(new HealthFragment());
        fragments.add(new PersonageFragment());

        FragmentStateAdapter viewPagerAdapter = new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragments.get(position);
            }

            @Override
            public int getItemCount() {
                return fragments.size();
            }
        };
        viewPager2.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setIcon(imgs.get(position));
            tab.setText(titles.get(position));

        }).attach();
    }
}