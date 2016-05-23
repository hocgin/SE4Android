package in.hocg.hocgin.inject.modules;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.hocg.hocgin.HttpRequest;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hocgin on 16-5-24.
 */
@Module
@Singleton
public class AppModule {
    @Provides // 提供对象的方法
    @Singleton // 单例
    HttpRequest provideHttpClient(OkHttpClient okHttpClient, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(HttpRequest.class);
    }

    @Provides // 提供对象的方法
    @Singleton // 单例
    Gson provideGson() {
        return new Gson();
    }

    @Provides // 提供对象的方法
    @Singleton // 单例
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }
}
