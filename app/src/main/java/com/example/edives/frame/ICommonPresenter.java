package com.example.edives.frame;

public interface ICommonPresenter<T> {
    void getData(int whichApi, T... t);
}
