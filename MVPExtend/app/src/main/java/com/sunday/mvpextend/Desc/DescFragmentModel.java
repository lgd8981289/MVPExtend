package com.sunday.mvpextend.Desc;

import com.sunday.mvpextend.MVPExtend.Model.IMVPExtendModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sunday on 16/4/28.
 */
public class DescFragmentModel implements IMVPExtendModel{

    private String test;
    private List<DescFragmentModel> descFragmentModels;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public List<DescFragmentModel> getDescFragmentModels() {
        if (descFragmentModels == null){
            descFragmentModels = new ArrayList<>();
        }
        return descFragmentModels;
    }

    public void setDescFragmentModels(List<DescFragmentModel> descFragmentModels) {
        this.descFragmentModels = descFragmentModels;
    }

    @Override
    public void onRequestData(OnRequestDataListener onLoadDataListener) {

        descFragmentModels = new ArrayList<>();
        for (int i = 0 ; i < 100 ; i ++){
            DescFragmentModel model = new DescFragmentModel();
            model.setTest("Text" + i);
            descFragmentModels.add(model);
        }

        onLoadDataListener.onSuccess(descFragmentModels);

    }
}
