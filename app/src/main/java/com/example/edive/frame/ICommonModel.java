package com.example.edive.frame;

public interface ICommonModel<T> {
    void getData(ICommonView view, int whichApi, T... t);
}
