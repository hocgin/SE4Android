package in.hocg.app.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by hocgin on 16-5-24.
 */
public class HttpClient {

    private static OkHttpClient OK_HTTP_CLIENT;

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
