package com.example.edives.frame;

public interface ICommonModel<T> {
    void getData(ICommonView view, int whichApi, T... t);
}
