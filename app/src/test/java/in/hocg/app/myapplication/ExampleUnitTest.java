package in.hocg.app.myapplication;

import org.junit.Test;

import javax.inject.Inject;

import in.hocg.app.http.controller.APIController;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest{

    @Inject
    APIController testController;
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void eqHttpClient() {
        System.out.print(String.valueOf(testController));
    }
}