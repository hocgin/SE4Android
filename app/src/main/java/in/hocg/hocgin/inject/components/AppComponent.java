package in.hocg.hocgin.inject.components;

import javax.inject.Singleton;

import dagger.Component;
import in.hocg.hocgin.activitys.MainActivity;
import in.hocg.hocgin.controller.TestController;
import in.hocg.hocgin.inject.modules.AppModule;
import in.hocg.hocgin.inject.modules.ControllerModule;

/**
 * Created by hocgin on 16-5-24.
 */
@Singleton
@Component(
        modules = {
                AppModule.class, // 杂项仓库
                ControllerModule.class // Controller仓库
        }
)
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(TestController controller);
}
