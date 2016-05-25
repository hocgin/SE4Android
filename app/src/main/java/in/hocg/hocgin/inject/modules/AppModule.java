package in.hocg.hocgin.inject.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.hocg.hocgin.Constant;
import in.hocg.hocgin.http.HttpClient;
import in.hocg.hocgin.http.URL;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hocgin on 16-5-24.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    URL.API provideAPI() {
        return new Retrofit.Builder()
                .baseUrl(Constant.API_URL)
                .client(HttpClient.okHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(URL.API.class);
    }
}
