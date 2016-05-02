package com.sunday.mvpextend.Desc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sunday.mvpextend.R;
import com.sunday.mvpextend.MVPExtend.View.MVPExtendFragment;

/**
 * Created by Sunday on 16/4/28.
 */
public class DescFragment extends MVPExtendFragment {

    private DescFragmentPresenter mPresenter;
    private ListView mListView;

    /**
     * 两种实现方式，可以在View中去处理Adapter的逻辑，也可以在Presenter中去做处理，因为框架本身是为了方便开发，切忌犯为了设计而设计，为了架构而架构。
     */

//    private DescFragmentAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_desc,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter = new DescFragmentPresenter(this);

        mListView = (ListView) view.findViewById(R.id.list_view);


        mPresenter.initData();

    }

//    public void setDataToView(List<DescFragmentModel> mDataSource) {
//        mAdapter = new DescFragmentAdapter(getActivity(),mDataSource);
//        mListView.setAdapter(mAdapter);
//    }
}
