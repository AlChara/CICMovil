package org.cic.cicmovil.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.cic.cicmovil.R;
import org.cic.cicmovil.adapters.TabViewAdapter;

/**
 * Created by PERSONAL on 03/04/2017.
 */

public class InitFragment extends Fragment{
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private AppBarLayout mAppBarLayout;
    private TabViewAdapter mTabViewAdapter;

    public InitFragment() {
    }

    public static InitFragment newInstance() {
        
        Bundle args = new Bundle();
        
        InitFragment fragment = new InitFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_init, container, false);
        if(savedInstanceState == null){
            View main = (View) container.getParent();
            mAppBarLayout = (AppBarLayout) main.findViewById(R.id.appbar_layout);
            mTabLayout = new TabLayout(getActivity());
            mTabLayout.setTabTextColors(getResources().getColor(R.color.secondary_text),
                    Color.WHITE);
            create_view(root);
            mAppBarLayout.addView(mTabLayout);

        }
        return root;
    }

    private void create_view(View root){
        mTabViewAdapter = new TabViewAdapter(getFragmentManager());
        String[] titles = {"UNO", "DOS","TRES"};
        Bundle uno = new Bundle(), dos = new Bundle(), tres = new Bundle();
        uno.putString("title", titles[0]);
        dos.putString("title", titles[1]);
        tres.putString("title", titles[2]);
        mTabViewAdapter.addFragment(ProbeFragment.newInstance(uno), titles[0]);
        mTabViewAdapter.addFragment(ProbeFragment.newInstance(dos), titles[1]);
        mTabViewAdapter.addFragment(ProbeFragment.newInstance(tres), titles[2]);
        mViewPager = (ViewPager) root.findViewById(R.id.vp_init_contain);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(mTabViewAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAppBarLayout.removeView(mTabLayout);
    }
}
