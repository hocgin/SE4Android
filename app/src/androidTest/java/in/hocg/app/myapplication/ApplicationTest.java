package in.hocg.app.myapplication;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.orhanobut.logger.Logger;

import in.hocg.app.http.controller.APIController;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    APIController testController;

    public ApplicationTest() {
        super(Application.class);
    }

    public void testDagger() {
//        ((App) getApplication()).getAppComponent().inject(this);
        Logger.v(String.valueOf(testController == null));
    }
}