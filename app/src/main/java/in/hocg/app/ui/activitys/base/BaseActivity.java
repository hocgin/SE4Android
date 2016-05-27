package in.hocg.app.ui.activitys.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.bugtags.library.Bugtags;

import butterknife.ButterKnife;
import in.hocg.app.core.loading.VaryViewManager;
import in.hocg.app.core.net.NetChangeObserver;
import in.hocg.app.core.net.NetStateReceiver;
import in.hocg.app.core.net.NetUtils;
import in.hocg.app.view.LoadDataView;

/**
 * Created by hocgin on 16-5-24.
 */
public abstract class BaseActivity extends AppCompatActivity implements LoadDataView {

    private Context context;
    /**
     * Screen information
     */
    protected int screenWidth = 0;
    protected int screenHeight = 0;
    protected float screenDensity = 0.0f;
    private NetChangeObserver netChangeObserver;
    /**
     * loading view controller
     */
    private VaryViewManager varyViewManager = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        screenDensity = displayMetrics.density;
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        netChangeObserver = new NetChangeObserver() {
            @Override
            public void onNetConnected(NetUtils.NetType type) {
                onNetworkConnected(type);
            }

            @Override
            public void onNetDisConnect() {
                onNetworkDisconnected();
            }
        };
        NetStateReceiver.registerObserver(netChangeObserver);
        initViewsAndEvents();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        if (null != getLoadingTargetView()) {
            varyViewManager = new VaryViewManager(getLoadingTargetView());
        }
    }

    /**
     * bind view and event
     */
    protected abstract void initViewsAndEvents();

    /**
     * get loading target view
     */
    protected abstract View getLoadingTargetView();

    /**
     * layout id
     *
     * @return
     */
    public abstract
    @LayoutRes
    int getContentViewLayoutID();

    /**
     * 网络断开
     */
    public abstract void onNetworkDisconnected();

    /**
     * 网络连接成功
     *
     * @param type
     */
    public abstract void onNetworkConnected(NetUtils.NetType type);

    @Override
    protected void onResume() {
        super.onResume();
        Bugtags.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Bugtags.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Bugtags.onDispatchTouchEvent(this, event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetStateReceiver.removeRegisterObserver(netChangeObserver);
    }

    @Override
    public Context context() {
        return context;
    }

    @Override
    public void showLoading(String msg) {
        if (null == varyViewManager) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }
        varyViewManager.showLoading(msg);
    }

    @Override
    public void hideLoading() {
        if (null == varyViewManager) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }
        varyViewManager.restore();
    }

    @Override
    public void showError(String msg) {
        if (null == varyViewManager) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }
        varyViewManager.showError(msg, null);
    }

    @Override
    public void showException(String msg) {
        showError(msg);
    }

    @Override
    public void showNetError() {
        if (null == varyViewManager) {
            throw new IllegalArgumentException("You must return a right target view for loading");
        }
        varyViewManager.showNetworkError(null);
    }


}
