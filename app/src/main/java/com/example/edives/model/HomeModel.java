package com.example.edives.model;

import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.ICommonModel;
import com.example.edives.frame.ICommonView;
import com.example.edives.frame.NetConfig;
import com.example.edives.frame.NetManager;

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
            case ApiConfig.INTEGRAL_DATA:
                int pagenumi = (int) t[0];
                int pagesizei = (int) t[1];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getFuDatass(pagenumi,pagesizei), view, whichApi);
                break;
            case ApiConfig.INTERRAL_DUIHUAN:
                int giftid = (int) t[0];
                String siz = (String) t[1];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getIntegralGift(giftid,siz),view,whichApi);
                break;
            case ApiConfig.INTEGRALDEATLIS_DATA:
                int integralid = (int) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getIntegralDeatlis(integralid),view,whichApi);
                break;
            case ApiConfig.INTEGRAlS_FITS:
                int inte = (int) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getIntegralFints(inte),view,whichApi);
                break;
            case ApiConfig.INTEGRAL_ALL:
                int ids = (int) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getIntegralAll(ids),view,whichApi);
                break;
            case ApiConfig.ALLSPENUM:
                int pids = (int) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getAllSpenum(pids),view,whichApi);
                break;
            case ApiConfig.MORENDIZHI:
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getMOren(),view,whichApi);
                break;
            case ApiConfig.CHUANGJIANJIFENGHAOLI:
                RequestBody requestBodyss = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getChuan(requestBodyss),view,whichApi);
                break;
            case ApiConfig.ADDRESSLIST:
                RequestBody bodyss = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getAddressList(bodyss),view,whichApi);
                break;
            case ApiConfig.ADDADDRESS:
                RequestBody requestBodys = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getAddaddress(requestBodys),view,whichApi);
                break;
            case ApiConfig.SEARCH_DATA:
                String cont = (String) t[0];
                String uid = (String) t[1];
                int ty = (int) t[2];
                int nu = (int) t[3];
                int si = (int) t[4];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getSearchData(cont,uid,ty,nu,si),view,whichApi);
                break;
            case ApiConfig.SEARCH_DATA_SHOPPING:
                String conts = (String) t[0];
                String uids = (String) t[1];
                int tys = (int) t[2];
                int nus = (int) t[3];
                int sis = (int) t[4];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getSearchDatas(conts,uids,tys,nus,sis),view,whichApi);
                break;
            case ApiConfig.SEARCH_DATA_TOPIC:
                String contss = (String) t[0];
                String uidss = (String) t[1];
                int tyss = (int) t[2];
                int nuss = (int) t[3];
                int siss = (int) t[4];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getSearchDatass(contss,uidss,tyss,nuss,siss),view,whichApi);
                break;
            case ApiConfig.SEARCH_DATA_SHOPPINGSSS:
                String contsss = (String) t[0];
                String uidsss = (String) t[1];
                int tysss = (int) t[2];
                int nusss = (int) t[3];
                int sisss = (int) t[4];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getSearchDatassss(contsss,uidsss,tysss,nusss,sisss),view,whichApi);
                break;
            case ApiConfig.SEARCHLOSTIOH_DATA:
                String ididid = (String) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getSearchListoy(ididid),view,whichApi);
                break;
            case ApiConfig.SEARCHDELECT:
                String useridsss = (String) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getDelectSearch(useridsss),view,whichApi);
                break;
            case ApiConfig.UPDATAPASSWORD:
                RequestBody phone = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getUpdatePassword(phone),view,whichApi);
                break;
        }
    }
}
