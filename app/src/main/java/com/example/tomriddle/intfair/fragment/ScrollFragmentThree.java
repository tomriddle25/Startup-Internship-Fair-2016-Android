package com.example.tomriddle.intfair.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tomriddle.intfair.R;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

/**
 * Created by tomriddle on 13/11/16.
 */

public class ScrollFragmentThree extends Fragment {

    private ObservableScrollView mScrollView;

    public static ScrollFragmentThree newInstance() {
        return new ScrollFragmentThree();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scrollthree, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mScrollView = (ObservableScrollView) view.findViewById(R.id.scrollViewThree);

        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView, null);
    }
}


