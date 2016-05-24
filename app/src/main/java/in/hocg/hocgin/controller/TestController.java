package in.hocg.hocgin.controller;


import javax.inject.Inject;

import in.hocg.hocgin.App;
import in.hocg.hocgin.URL;
import in.hocg.hocgin.utils.simple.SimpleControllerCallback;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hocgin on 16-5-24.
 */
public class TestController extends BaseController {

    @Inject
    URL.API api;

    public TestController() {
        App.getAppComponent().inject(this);
    }

    public Observable<Boolean> test() {
        return api.test()
                .subscribeOn(Schedulers.test())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void testCall() {
        api.testCall()
                .enqueue(new SimpleControllerCallback<Boolean>() {
                    @Override
                    protected void callback(Boolean result, boolean isSuccessful) {

                    }
                });
    }
}
