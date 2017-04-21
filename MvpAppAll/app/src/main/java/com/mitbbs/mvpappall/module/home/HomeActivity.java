package com.mitbbs.mvpappall.module.home;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.mitbbs.mvpappall.R;
import com.mitbbs.mvpappall.module.base.BaseActicity;

import butterknife.BindView;

/**
 * Created by jv on 2017/4/19.
 */
public class HomeActivity extends BaseActicity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    // 本来想用这个来存储Fragment做切换，不过貌似fragment会被回收产生异常，估计内存占用太大
//    private SparseArray<Fragment> mSparseFragments = new SparseArray<>();
    private SparseArray<String> mSparseTags = new SparseArray<>();
    private long mExitTime = 0;
    private int mItemId = -1;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case R.id.nav_news:
//                    replaceFragment(R.id.fl_container,new );
                    break;
                case R.id.nav_photos:
                    break;
                case R.id.nav_videos:
                    break;
                case R.id.nav_setting:

                    break;
            }
            return true;
        }
    });


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        _initDrawerLayout(mDrawerLayout, mNavView);
    }


    @Override
    protected void updateViews(boolean isRefresh) {

    }

    /**
     * 初始化 DrawerLayout
     * @param mDrawerLayout
     * @param mNavView
     */
    private void _initDrawerLayout(DrawerLayout mDrawerLayout, NavigationView mNavView) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            //将侧边栏顶部延伸至status bar
            mDrawerLayout.setFitsSystemWindows(true);
            //将主页面顶部延伸至status bar
            mDrawerLayout.setClipToPadding(false);
        }
        mDrawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerClosed(View drawerView) {
                mHandler.sendEmptyMessage(mItemId);
            }
        });
        mNavView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        if (item.isChecked()){
            return true;
        }
        mItemId = item.getItemId();
        return true;
    }
}
