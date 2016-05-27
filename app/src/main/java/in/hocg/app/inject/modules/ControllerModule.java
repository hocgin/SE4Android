package in.hocg.app.inject.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.hocg.app.http.controller.APIController;

/**
 * Created by hocgin on 16-5-24.
 * 专门用于实例化 Controller
 */
@Module
public class ControllerModule {
    @Provides // 提供对象的方法
    @Singleton
    APIController provideAPIController() {
        return new APIController();
    }
}
