package in.hocg.hocgin.inject.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.hocg.hocgin.controller.TestController;

/**
 * Created by hocgin on 16-5-24.
 * 专门用于实例化 Controller
 */
@Module
public class ControllerModule {
    @Provides // 提供对象的方法
    @Singleton
    TestController provideTestController() {
        return new TestController();
    }
}
