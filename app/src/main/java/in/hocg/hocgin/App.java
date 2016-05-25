package in.hocg.hocgin;

import android.app.Application;

import com.bugtags.library.Bugtags;
import com.bugtags.library.BugtagsOptions;
import com.facebook.stetho.Stetho;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

import butterknife.ButterKnife;
import in.hocg.hocgin.inject.components.AppComponent;
import in.hocg.hocgin.inject.components.DaggerAppComponent;
import in.hocg.hocgin.myapplication.BuildConfig;

/**
 * App
 * Created by hocgin on 16-5-23.
 */
public class App extends Application {
    static AppComponent appComponent = DaggerAppComponent.create();

    @Override
    public void onCreate() {
        super.onCreate();
        _bugTags(); // init bugTags
        _logger(); // init logger

        if (BuildConfig.DEBUG) {
            _debug();
        }
    }

    private void _logger() {
        Logger.init("JLog");
    }

    private void _debug() {
        ButterKnife.setDebug(true);
        LeakCanary.install(this);
        Stetho.initializeWithDefaults(this);
    }

    private void _bugTags() {
        //在这里初始化
        BugtagsOptions options = new BugtagsOptions.Builder().
                trackingLocation(true).       //是否获取位置
                trackingCrashLog(true).       //是否收集闪退
                trackingConsoleLog(true).     //是否收集控制台日志
                trackingUserSteps(true).      //是否跟踪用户操作步骤
                crashWithScreenshot(true).    //收集闪退是否附带截图
                versionName(BuildConfig.VERSION_NAME).         //自定义版本名称
                versionCode(BuildConfig.VERSION_CODE).              //自定义版本号
                trackingNetworkURLFilter("(.*)").//自定义网络请求跟踪的 url 规则
                build();
        Bugtags.start(BuildConfig.BUGTAGS_APP_KEY, this, Bugtags.BTGInvocationEventNone, options);
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
