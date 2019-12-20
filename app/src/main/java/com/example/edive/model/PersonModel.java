package com.example.edive.model;

import com.example.edive.frame.ApiConfig;
import com.example.edive.frame.ICommonModel;
import com.example.edive.frame.ICommonView;
import com.example.edive.frame.NetConfig;
import com.example.edive.frame.NetManager;
import com.example.edive.utils.NormalConfig;

import okhttp3.RequestBody;

public class PersonModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager mManager = NetManager.getNetManager();
        switch (whichApi){
            case ApiConfig.MYPERSONDESTIALS:
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getPersonalDeatials(),view,whichApi);
                break;
                case ApiConfig.XIUGAIGERENXX:
                    RequestBody body = (RequestBody) t[0];
                    mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getUpdateMessagercoach(body),view,whichApi);
                    break;
            case ApiConfig.PERSONALMESSAGER:
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getPersonalMessager(),view,whichApi);
                break;
        }
    }
}
