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
            case ApiConfig.USERDATALIS:
                int userids = (int) t[0];
                int userType = (int) t[1];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getUserPerson(userids,userType),view,whichApi);
                break;
            case ApiConfig.NOTFOLLOWS:
                RequestBody bodyfollows = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getNotfollows(bodyfollows),view,whichApi);
                break;
            case ApiConfig.FOLLOWUSER:
                RequestBody follows = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getFollow(follows),view,whichApi);
                break;
            case ApiConfig.LABUMUSERPERSONAL:
                int useridperson = (int) t[0];
                int personnum = (int) t[1];
                int personsize = (int) t[2];
                int userTypes = (int) t[3];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getAlbum(useridperson,personnum,personsize,userTypes),view,whichApi);
                break;
        }
    }
}
