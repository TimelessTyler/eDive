package com.example.edive.model;

import com.example.edive.frame.ICommonModel;
import com.example.edive.frame.ICommonView;
import com.example.edive.frame.NetManager;

public class ShoppingModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        NetManager manager = NetManager.getNetManager();
        switch (whichApi){

        }
    }
}
