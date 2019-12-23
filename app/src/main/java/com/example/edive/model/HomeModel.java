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
            case ApiConfig.HOME_TOPIC_DATA:
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getHomeTopic(), view, whichApi);
                break;
            case ApiConfig.HOT_DATA:
                int pagenumh = (int) t[0];
                int pagesizeh = (int) t[1];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getHotData(pagenumh,pagesizeh), view, whichApi);
                break;
            case ApiConfig.NEWDYNAMIC_DATA:
                int pagenums = (int) t[0];
                int pagesizes = (int) t[1];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getNewsDynamicData(pagenums,pagesizes), view, whichApi);
                break;
            case ApiConfig.TOPICDESTIO_DATA:
                int topicid = (int) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getTopicDtaaa(topicid),view,whichApi);
                break;
            case ApiConfig.FOLLOWUSER:
                RequestBody follow = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getFollow(follow),view,whichApi);
                break;
            case ApiConfig.NOTFOLLOWS:
                RequestBody bodyfollow = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getNotfollows(bodyfollow),view,whichApi);
                break;
            case ApiConfig.HOTDETALIS_DATA:
                int pagenum = (int) t[0];
                int pagesize = (int) t[1];
                int idss = (int) t[2];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getHotDetalisData(pagenum,pagesize,idss),view,whichApi);
            case ApiConfig.NEWSLIKE:
                int like = (int) t[0];
                int userType = (int) t[1];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getLike(like,userType),view,whichApi);
                break;
            case ApiConfig.NOTLIKE:
                int notlike = (int) t[0];
                int usertype = (int) t[1];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getNotLike(notlike,usertype),view,whichApi);
                break;
            case ApiConfig.NEWSDYNAMICDEATILS_DATA:
                int id = (int) t[0];
                int num = (int) t[1];
                int size = (int) t[2];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getNewsDynamicDetalisData(id,num,size), view, whichApi);
                break;
            case ApiConfig.APLLCOMMENT:
                int commentnum = (int) t[0];
                int commentsize = (int) t[1];
                int commentid = (int) t[2];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getAllComment(commentnum,commentsize,commentid),view,whichApi);
                break;
            case ApiConfig.NEWSDYNAMICDEATILS_COMMENT:
                RequestBody bodys = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getComment(bodys),view,whichApi);
                break;
            case ApiConfig.DYNAMICDEATILS_DATA_PL:
                int post = (int) t[0];
                int userTypes = (int) t[1];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getDynamicdatas(post,userTypes),view,whichApi);
                break;
            case ApiConfig.CONVERSEARCH_DATA:
                String data = (String) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getSearchDynaic(data),view,whichApi);
                break;
            case ApiConfig.CONVERSATION_DATA:
                int pagenumc = (int) t[0];
                int pagesizec = (int) t[1];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getConverSation(pagenumc,pagesizec),view,whichApi);
                break;
            case ApiConfig.DELECTMYDYNAMIC:
                int dynamicid = (int) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getDelectDynamic(dynamicid),view,whichApi);
                break;
            case ApiConfig.MYDYNAMICDETAILS:
                String userid = (String) t[0];
                int nums = (int) t[1];
                int sizes = (int) t[2];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getMyDynamic(userid,nums,sizes),view,whichApi);
                break;
            case ApiConfig.ADDDYNAMIC:
                RequestBody requestBody = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getAddDynamic(requestBody),view,whichApi);
                break;
            case ApiConfig.HOTDETALIS_DATAS:
                int pnum = (int) t[0];
                int psize = (int) t[1];
                int pid = (int) t[2];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getHotDatasss(pnum,psize,pid),view,whichApi);
                break;
            case ApiConfig.SHOPPING_DIVING:
                RequestBody ha = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getDiving(ha),view,whichApi);
                break;
            case ApiConfig.MYDYNAMICDETAILSS:
                String userids = (String) t[0];
                int pageNums = (int) t[1];
                int pageSizes = (int) t[2];
                int usertypr = (int) t[3];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getMyDynamicS(userids,pageNums,pageSizes,usertypr),view,whichApi);
                break;
        }
    }
}
