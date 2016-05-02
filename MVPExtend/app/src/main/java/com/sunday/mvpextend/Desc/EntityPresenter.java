package com.sunday.mvpextend.Desc;

import android.widget.TextView;

import com.sunday.mvpextend.Login.LoginModel;
import com.sunday.mvpextend.MVPExtend.Presenter.MVPExtendPresente;
import com.sunday.mvpextend.R;

/**
 * Created by Sunday on 16/4/28.
 */
public class EntityPresenter extends MVPExtendPresente<LoginModel,DescActivity>{



    public EntityPresenter(DescActivity activity) {
        super(activity);
    }

    @Override
    protected void setDataToView(LoginModel loginModel) {
        ((TextView)mMainView.getView(R.id.tv_logo)).setText(loginModel.getUeserLogo());
        ((TextView)mMainView.getView(R.id.tv_name)).setText(loginModel.getUserNickname());
    }
}
