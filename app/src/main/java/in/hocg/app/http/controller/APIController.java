package in.hocg.app.http.controller;


import javax.inject.Inject;

import in.hocg.app.App;
import in.hocg.app.http.URL;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hocgin on 16-5-24.
 * 进行网络请求
 * todo 考虑是否需要controller层
 */
public class APIController extends BaseController {

    @Inject
    URL.API api;

    public APIController() {
        App.getAppComponent().inject(this);
    }

    public Observable<Boolean> test() {
        return api.test()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
