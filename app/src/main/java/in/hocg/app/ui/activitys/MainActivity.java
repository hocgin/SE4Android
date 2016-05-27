package in.hocg.app.ui.activitys;

import android.view.View;
import android.widget.Button;

import com.bugtags.library.Bugtags;

import javax.inject.Inject;

import butterknife.BindView;
import in.hocg.app.App;
import in.hocg.app.core.net.NetUtils;
import in.hocg.app.http.controller.APIController;
import in.hocg.app.myapplication.R;
import in.hocg.app.ui.activitys.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @BindView(R.id.bugBtn)
    Button bugBtn;

    @Inject
    APIController apiController;

    MainActivity() {
        App.getAppComponent().inject(this);
    }

    @Override
    protected void initViewsAndEvents() {
        bugBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiController.test();
                Bugtags.setInvocationEvent(Bugtags.BTGInvocationEventBubble);
            }
        });
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    void onNetworkDisconnected() {

    }

    @Override
    void onNetworkConnected(NetUtils.NetType type) {

    }

}
