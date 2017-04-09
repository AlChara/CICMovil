package org.cic.cicmovil.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by PERSONAL on 31/03/2017.
 */

public class MapsFragment extends SupportMapFragment {
    public static final String TAG = "MapsFragment";

    public MapsFragment(){}

    public static MapsFragment newInstance(Bundle args) {
        MapsFragment fragment = new MapsFragment();
        if (args != null)
            fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
