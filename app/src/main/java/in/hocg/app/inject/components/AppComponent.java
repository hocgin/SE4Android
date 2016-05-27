package in.hocg.app.inject.components;

import javax.inject.Singleton;

import dagger.Component;
import in.hocg.app.ui.activitys.MainActivity;
import in.hocg.app.http.controller.APIController;
import in.hocg.app.inject.modules.AppModule;
import in.hocg.app.inject.modules.ControllerModule;

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
    void inject(APIController controller);
}
