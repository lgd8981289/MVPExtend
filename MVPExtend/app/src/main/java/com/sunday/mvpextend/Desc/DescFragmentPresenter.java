package com.sunday.mvpextend.Desc;

import android.widget.ListView;

import com.sunday.mvpextend.MVPExtend.Model.IMVPExtendModel;
import com.sunday.mvpextend.MVPExtend.Presenter.MVPExtendPresente;
import com.sunday.mvpextend.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunday on 16/4/28.
 */
public class DescFragmentPresenter extends MVPExtendPresente<List<DescFragmentModel>,DescFragment> {

    private DescFragmentModel mModel;
    private DescFragmentAdapter mAdapter;
    private List<DescFragmentModel> mDataSource = new ArrayList<>();

    public DescFragmentPresenter(DescFragment activity) {
        super(activity);
        mModel = new DescFragmentModel();

        mAdapter = new DescFragmentAdapter(mMainView.getActivity(),mDataSource);
        ((ListView)mMainView.getView(R.id.list_view)).setAdapter(mAdapter);
    }

    @Override
    protected void setDataToView(List<DescFragmentModel> descFragmentModels) {
        mDataSource.addAll(descFragmentModels);


        mAdapter.notifyDataSetChanged();
    }

    public void initData(){
        mModel.onRequestData(new IMVPExtendModel.OnRequestDataListener<List<DescFragmentModel>>() {
            @Override
            public void onSuccess(List<DescFragmentModel> o) {
                setDataToView(o);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }
}
