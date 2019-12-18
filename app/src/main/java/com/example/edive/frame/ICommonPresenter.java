package com.example.edive.frame;

public interface ICommonPresenter<T> {
    void getData(int whichApi, T... t);
}
