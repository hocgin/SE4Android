package in.hocg.hocgin.inject.components;

import dagger.Component;
import in.hocg.hocgin.inject.PerActivity;
import in.hocg.hocgin.inject.modules.ActivityModule;

/**
 * Created by hocgin on 16-5-24.
 */
@Component(
        dependencies = AppComponent.class,
        modules = {
                ActivityModule.class
        }
)
@PerActivity
public interface ActivityComponent {
}
