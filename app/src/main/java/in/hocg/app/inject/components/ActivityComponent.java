package in.hocg.app.inject.components;

import dagger.Component;
import in.hocg.app.inject.PerActivity;
import in.hocg.app.inject.modules.ActivityModule;

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
