package com.example.edives.model;

import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.ICommonModel;
import com.example.edives.frame.ICommonView;
import com.example.edives.frame.NetConfig;
import com.example.edives.frame.NetManager;

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
            case ApiConfig.ADDARESSMOREN:
                int addaressid = (int) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getAddaress(addaressid),view,whichApi);
                break;
            case ApiConfig.DELECTADDRESS:
                int addressid = (int) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getDelectAddress(addressid),view,whichApi);
                break;
            case ApiConfig.COACHINVITEUSER:
                RequestBody requestBody = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getCoachuser(requestBody),view,whichApi);
                break;
            case ApiConfig.FOLLOWUSERS:
                RequestBody follow = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getFollows(follow),view,whichApi);
                break;
            case ApiConfig.NOTFOLLOW:
                RequestBody bodyfollow = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getNotfollow(bodyfollow),view,whichApi);
                break;
            case ApiConfig.FOLLOWLIST:
                int numa = (int) t[0];
                int sizea = (int) t[1];
                int type = (int) t[2];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getFollowList(numa,sizea,type),view,whichApi);
                break;
            case ApiConfig.TIJIAOYIJIAN:
                RequestBody vodys = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getAddSug(vodys),view,whichApi);
                break;
            case ApiConfig.SUGGEST:
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getSuggers(),view,whichApi);
                break;
        }
    }
}
