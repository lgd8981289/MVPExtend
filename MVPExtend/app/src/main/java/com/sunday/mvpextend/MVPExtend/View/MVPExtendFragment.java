package com.sunday.mvpextend.MVPExtend.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sunday on 16/4/28.
 */
public abstract class MVPExtendFragment extends Fragment{

    private static final int VIEW = 0x216;

    private Map<Integer,View> mViews;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mViews = new HashMap<>();
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mViews.put(VIEW,view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mViews != null){
            mViews.clear();
            mViews = null;
        }
    }

    /**
     * 通过ID 获取视图
     */
    public View getView(int id){

        View view = mViews.get(id);

        if (view == null){
            view = mViews.get(VIEW).findViewById(id);
            if (view != null){
                mViews.put(id,view);
            }
        }

        return view;
    };

}
