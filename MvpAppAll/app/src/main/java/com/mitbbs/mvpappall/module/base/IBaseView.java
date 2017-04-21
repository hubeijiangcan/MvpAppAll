package com.mitbbs.mvpappall.module.base;

import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * Created by jc on 2017/4/19.
 * 基础 BaseView 接口
 */
public interface IBaseView {

    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 隐藏加载动画
     */
    void hideLoading();

//    /**
//     * 显示网络错误
//     * @param onRetryListener 点击监听
//     */
//    void showNetError(EmptyLayout.OnRetryListener onRetryListener);
    /**
     * 绑定生命周期
     * @param <T>
     * @return
     */
    <T> LifecycleTransformer<T> bindToLife();

    /**
     * 完成刷新, 新增控制刷新
     */
    void finishRefresh();
}
