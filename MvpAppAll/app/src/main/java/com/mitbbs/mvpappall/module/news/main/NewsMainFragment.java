package com.mitbbs.mvpappall.module.news.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.mitbbs.mvpappall.R;
import com.mitbbs.mvpappall.module.base.BaseFragment;
import com.trello.rxlifecycle.LifecycleTransformer;

import butterknife.BindView;

/**
 * Created by jc on 2017/4/21.
 * 新闻主界面
 */
public class NewsMainFragment extends BaseFragment{

    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;



    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_news_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

}
