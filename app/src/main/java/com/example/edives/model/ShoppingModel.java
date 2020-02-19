package com.example.edives.model;

import com.example.edives.frame.ApiConfig;
import com.example.edives.frame.ICommonModel;
import com.example.edives.frame.ICommonView;
import com.example.edives.frame.NetConfig;
import com.example.edives.frame.NetManager;

import okhttp3.RequestBody;

public class ShoppingModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager mManager = NetManager.getNetManager();
        switch (whichApi){
            case ApiConfig.ORDER_FRAGMENT:
                int status = (int) t[0];
                int num = (int) t[1];
                int size = (int) t[2];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getOrder(status,num,size),view,whichApi);
                break;
            case ApiConfig.COMPLETEDORDER:
                String order = (String) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getComPleted(order),view,whichApi);
                break;
            case ApiConfig.ORDER_DETAILS:
                String orderSn = (String) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getOrderDetails(orderSn),view,whichApi);
                break;
            case ApiConfig.APPLKCOMIND:
                RequestBody body = (RequestBody) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getApplc(body),view,whichApi);
                break;
            case ApiConfig.APPLYDEATILS:
                String orderid = (String) t[0];
                mManager.method(mManager.getNetService(NetConfig.BASE_URL2).getApplyDeatils(orderid),view,whichApi);
                break;
        }
    }
}
