package com.example.edive.model;

import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.ICommonModel;
import com.example.edive.frame.ICommonView;
import com.example.edive.frame.NetConfig;
import com.example.edive.frame.NetManager;

import okhttp3.RequestBody;

public class HomeModel implements ICommonModel {

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager mManager = NetManager.getNetManager();
        switch (whichApi){
            case ApiConfig.HomeTest_DATA:
                RequestBody body = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getFuData(body), view, whichApi);
                break;
        }
    }
}
