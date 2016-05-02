package com.sunday.mvpextend.Desc;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

import com.sunday.mvpextend.Login.LoginModel;
import com.sunday.mvpextend.R;
import com.sunday.mvpextend.MVPExtend.View.MVPExtendActivity;

public class DescActivity extends MVPExtendActivity {

    public static final String ENTITY = "entity";

    private TextView mTvLogo,mTvName;


    //用来处理传输过来的登录信息的模型的Presenter
    private EntityPresenter mEctityPresenter;
    private DescFragment mDescFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);

        mEctityPresenter = new EntityPresenter(this);

        mEctityPresenter.setDataToView((LoginModel) getIntent().getParcelableExtra(ENTITY));


        mTvLogo = (TextView) findViewById(R.id.tv_logo);
        mTvName = (TextView) findViewById(R.id.tv_name);

        mDescFragment = new DescFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment,mDescFragment).commit();

    }
}
