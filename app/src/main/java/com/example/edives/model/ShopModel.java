package com.example.edives.model;

import com.example.edives.frame.ICommonModel;
import com.example.edives.frame.ICommonView;
import com.example.edives.frame.NetManager;

public class ShopModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager mManager = NetManager.getNetManager();
        switch (whichApi){

        }
    }
}
