package org.cic.cicmovil.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.cic.cicmovil.R;

/**
 * Created by PERSONAL on 04/04/2017.
 */

public class ProbeFragment extends Fragment{
    private TextView mTextView;

    public ProbeFragment() {
    }


    public static ProbeFragment newInstance(Bundle args) {

        ProbeFragment fragment = new ProbeFragment();
        if (args != null) fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final String title = getArguments().getString("title");
        View root = inflater.inflate(R.layout.fragment_probe, container, false);
         mTextView = (TextView) root.findViewById(R.id.tv_contain);
        mTextView.setText(title);
        return root;
    }
}
