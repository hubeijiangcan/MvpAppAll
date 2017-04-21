package com.mitbbs.mvpappall.utils;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.functions.Func1;

/**
 * Created by jc on 2017/4/19.
 * RxJava 帮助类
 */
public final class RxHelper {

    private RxHelper() {
        throw new AssertionError();
    }
    /**
     * 倒计时
     * @param time
     * @return
     */
    public static Observable<Integer> countdown(int time) {
        if (time < 0) {
            time = 0;
        }
        final int countTime = time;

        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .map(new Func1<Long, Integer>() {
                    @Override
                    public Integer call(Long increaseTime) {
                        Log.e("test",increaseTime+"");
                        return countTime - increaseTime.intValue();
                    }
                })
                .take(countTime + 1)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
