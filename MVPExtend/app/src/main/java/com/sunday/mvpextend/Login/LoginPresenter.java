package com.sunday.mvpextend.Login;

import android.content.Intent;

import com.sunday.mvpextend.Desc.DescActivity;
import com.sunday.mvpextend.MVPExtend.Model.IMVPExtendModel;
import com.sunday.mvpextend.MVPExtend.Presenter.MVPExtendPresente;

/**
 * Created by Sunday on 16/4/28.
 */
public class LoginPresenter extends MVPExtendPresente<LoginModel,LoginActivity> {

    /**
     * 在Presenter中重建Model的对象，用于处理所有与数据有关的内容
     */
    private IMVPExtendModel mModel;

    public LoginPresenter(LoginActivity activity) {
        super(activity);
        mModel = new LoginModel();
    }


    @Override
    public void setDataToView(LoginModel loginModel) {
        //跳转界面,并把获取到的模型传输到DescActivity中
        Intent intent = new Intent(mMainView, DescActivity.class);
        intent.putExtra(DescActivity.ENTITY,loginModel);
        mMainView.startActivity(intent);
    }

    /**
     * 模拟登陆
     */
    public void login(){
        mMainView.showLoading();
        mModel.onRequestData(new IMVPExtendModel.OnRequestDataListener<LoginModel>() {
            @Override
            public void onSuccess(LoginModel loginModel) {
                mMainView.dismisLoading();
                setDataToView(loginModel);

            }

            @Override
            public void onFailure(String error) {
                mMainView.dismisLoading();
            }
        });
    }

}
