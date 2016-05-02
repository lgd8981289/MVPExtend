package com.sunday.mvpextend.MVPExtend.View;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sunday on 16/4/23.
 */
public abstract class MVPExtendActivity extends AppCompatActivity{

    /**
     * 保存所有findViewById的View集合
     */
    private Map<Integer,View> mViews;

    @Nullable
    @Override
    public View findViewById(@IdRes int id) {
        View view = super.findViewById(id);
        mViews.put(id,view);
        return view;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mViews = new HashMap<>();
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
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
            view = findViewById(id);
            if (view != null){
                mViews.put(id,view);
            }
        }

        return view;
    };

}
