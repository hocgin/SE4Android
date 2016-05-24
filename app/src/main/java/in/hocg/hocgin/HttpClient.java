package in.hocg.hocgin;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hocgin on 16-5-24.
 */
public class HttpClient {

    private static OkHttpClient OK_HTTP_CLIENT;
    private static URL.API URL_API;

    /**
     * 官方API
     * @return
     */
    public static URL.API api() {
        if (null == URL_API) {
            synchronized (HttpClient.class) {
                if (null == URL_API) {
                    URL_API = new Retrofit.Builder()
                            .baseUrl(Constant.API_URL)
                            .client(okHttpClient())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(URL.API.class);
                }
            }
        }
        return URL_API;
    }



    /**
     * 初始化 OkHttpClient
     *
     * @return
     */
    public static OkHttpClient okHttpClient() {
        if (OK_HTTP_CLIENT == null) {
            synchronized (HttpClient.class) {
                if (OK_HTTP_CLIENT == null) {
                    // 指定缓存路径,缓存大小100Mb
//                    Cache cache = new Cache(new File(App.getContext().getCacheDir(), "HttpCache"),
//                            1024 * 1024 * 100);

                    OK_HTTP_CLIENT = new OkHttpClient.Builder()
//                            .cache(cache)
//                            .addInterceptor(mRewriteCacheControlInterceptor)
//                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)
//                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return OK_HTTP_CLIENT;
    }
}
