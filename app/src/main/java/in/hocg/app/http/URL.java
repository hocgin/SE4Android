package in.hocg.app.http;

import retrofit2.Call;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by hocgin on 16-5-24.
 */
public interface URL {
    interface API {
        @POST("v1/test.json")
        Observable<Boolean> test();
        @POST("v1/test.json")
        Call<Boolean> testCall();
    }
}
