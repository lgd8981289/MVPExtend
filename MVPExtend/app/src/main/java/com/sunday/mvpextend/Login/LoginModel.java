package com.sunday.mvpextend.Login;

import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;

import com.sunday.mvpextend.MVPExtend.Model.IMVPExtendModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sunday on 16/4/28.
 */
public class LoginModel implements IMVPExtendModel,Parcelable{

    private OnRequestDataListener onLoadDataListener;

    public LoginModel(){}

    protected LoginModel(Parcel in) {
        userLogo = in.readString();
        userNickname = in.readString();
    }

    public static final Creator<LoginModel> CREATOR = new Creator<LoginModel>() {
        @Override
        public LoginModel createFromParcel(Parcel in) {
            return new LoginModel(in);
        }

        @Override
        public LoginModel[] newArray(int size) {
            return new LoginModel[size];
        }
    };

    @Override
    public void onRequestData(OnRequestDataListener onLoadDataListener) {
        this.onLoadDataListener = onLoadDataListener;

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 1000);

                    mHandler.sendEmptyMessage(0);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void onRequestDataOK(){
        String resultData = "{\"userLogo\": \"测试内容o668\",\n" +
                "        \"userNickname\": \"测试内容58e6\"}";

        try {
            JSONObject jsonObject = new JSONObject(resultData);
            userLogo = jsonObject.getString("userLogo");
            userNickname = jsonObject.getString("userNickname");

            onLoadDataListener.onSuccess(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            onRequestDataOK();
        }
    };


    private String userLogo;
    private String userNickname;

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUeserLogo() {
        return userLogo;
    }

    public void setUserLogo(String ueserLogo) {
        this.userLogo = ueserLogo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userLogo);
        dest.writeString(userNickname);
    }
}
