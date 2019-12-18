package com.example.edive.frame;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public abstract class BaseObserver implements Observer {
    private Disposable mDisposable;

    public abstract void onSuccess(Object value);

    public abstract void onFailed(Throwable e);

    public void complete() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(Object value) {
        onSuccess(value);
        disPos();
    }

    @Override
    public void onError(Throwable e) {
        onFailed(e);
        disPos();
    }

    @Override
    public void onComplete() {
        complete();
    }

    private void disPos() {
//        if (!mDisposable.isDisposed()) mDisposable.isDisposed();
        if (!mDisposable.isDisposed()) mDisposable.dispose();
    }
}
