package in.hocg.hocgin.myapplication;

import org.junit.Test;

import javax.inject.Inject;

import in.hocg.hocgin.controller.BaseController;
import in.hocg.hocgin.controller.TestController;
import in.hocg.hocgin.inject.components.AppComponent;
import in.hocg.hocgin.inject.components.DaggerAppComponent;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest extends BaseController{

    @Inject
    TestController testController;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void eqHttpClient() {
        System.out.print(String.valueOf(testController));
    }
}