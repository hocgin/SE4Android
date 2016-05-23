package in.hocg.hocgin;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hocgin on 16-5-24.
 */
public class HttpClient {
    public static HttpRequest create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(_okHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        return retrofit.create(HttpRequest.class);
    }

    private static OkHttpClient _okHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    private static Gson gson() {
        return new Gson();
    }
}
