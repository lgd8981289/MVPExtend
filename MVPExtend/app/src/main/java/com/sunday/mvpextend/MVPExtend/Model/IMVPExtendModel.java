package com.sunday.mvpextend.MVPExtend.Model;

/**
 * Created by Sunday on 16/4/28.
 */
public interface IMVPExtendModel {



    /**
     * 简单获取数据的回调接口
     * 提供获取数据成功和获取数据失败的回调方法
     */
    interface OnRequestDataListener<M>{
        /**
         * 获取数据成功
         */
        void onSuccess(M m);

        /**
         * 获取数据失败
         */
        void onFailure(String error);
    }

    /**
     * 获取数据
     */
    void onRequestData(OnRequestDataListener onLoadDataListener);
}
