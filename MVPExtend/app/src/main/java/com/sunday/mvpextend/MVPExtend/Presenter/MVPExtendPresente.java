package com.sunday.mvpextend.MVPExtend.Presenter;

/**
 * Created by Sunday on 16/4/28.
 */
public abstract class MVPExtendPresente<M,V>{

    protected V mMainView;

    public MVPExtendPresente(V mainView){
        this.mMainView = mainView;
    }


    /**
     * 设置数据到视图
     * @param m
     */
    protected abstract void setDataToView(M m);
}
