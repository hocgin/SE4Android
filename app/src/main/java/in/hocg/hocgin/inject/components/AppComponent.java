package in.hocg.hocgin.inject.components;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;
import in.hocg.hocgin.inject.modules.AppModule;

/**
 * Created by hocgin on 16-5-24.
 */
@Component(
        modules = {
                AppModule.class
        }
)
@Singleton
public interface AppComponent {
    void inject(Activity container);
}
