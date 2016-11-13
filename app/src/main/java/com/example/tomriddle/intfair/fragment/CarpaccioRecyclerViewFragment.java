package com.example.tomriddle.intfair.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tomriddle.intfair.R;
import com.github.florent37.carpaccio.Carpaccio;
import com.github.florent37.carpaccio.controllers.adapter.Holder;
import com.github.florent37.carpaccio.controllers.adapter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class CarpaccioRecyclerViewFragment extends Fragment {

    private static int ITEM_COUNT = 0;
    private List<Object> mContentItems = new ArrayList<>();
    Carpaccio carpaccio;

    public static CarpaccioRecyclerViewFragment newInstance() {
        return new CarpaccioRecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview_carpaccio, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        carpaccio = (Carpaccio) view.findViewById(R.id.carpaccio);

        for (int i = 0; i < ITEM_COUNT; ++i)
                mContentItems.add(new Object());

        carpaccio.mapList("card",mContentItems);
        carpaccio.onItemClick("card", new OnItemClickListener() {
            @Override
            public boolean isClickable(Object item, int position, Holder holder) {
                return false;
            }

            @Override
            public void onItemClick(Object item, int position, Holder holder) {

            }


            public void onItemClick(Object o, int i, View view) {
                Toast.makeText(getActivity(),"position :"+i,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
