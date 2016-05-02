package com.sunday.mvpextend.Login;

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;

import com.sunday.mvpextend.R;
import com.sunday.mvpextend.MVPExtend.View.MVPExtendActivity;

public class LoginActivity extends MVPExtendActivity {

    private ProgressDialog mProressDialog;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new LoginPresenter(this);



    }

    //从Activity中发起登录请求
    public void onLoginClick(View view){
        mPresenter.login();
    }

    public void showLoading(){
        if (mProressDialog == null){
            mProressDialog = new ProgressDialog(this);
        }
        mProressDialog.show();
    }

    public void dismisLoading(){
        if (mProressDialog != null){
            mProressDialog.dismiss();
        }
    }
}
