package in.hocg.hocgin.utils.simple;

import android.support.graphics.drawable.BuildConfig;

import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.hocg.hocgin.utils.LangKit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hocgin on 16-4-28.
 * 简单的 retrofit2 回调
 * 可自动打印请求url,入参,响应状态等
 */
public abstract class SimpleControllerCallback<T> implements Callback<T> {

    public void handler(Call<T> call, Response<T> response, Throwable t) {

        Map<String, Object> messages = new HashMap<>();
        messages.put("Env", "Retrofit2");
        messages.put("Request", call.request().tag().toString());
        if (BuildConfig.DEBUG) {
            try {
                List<String> encodedNames = (List<String>) LangKit.getFiled(call.request().body(), "encodedNames");
                List<String> encodedValues = (List<String>) LangKit.getFiled(call.request().body(), "encodedValues");
                if (!LangKit.isNull(encodedNames) && !LangKit.isNull(encodedValues)) {
                    Map<String, String> params = new HashMap<>();
                    for (int i = 0; i < encodedNames.size(); i++) {
                        params.put(encodedNames.get(i), encodedValues.get(i));
                    }
                    messages.put("Params", params);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        T result = null;
        boolean isSuccessful = false;

        if (!LangKit.isNull(response)) {
            isSuccessful = response.isSuccessful();
            if (LangKit.isNull(t)) {
                result = response.body();
//                messages.put("Raw", response.raw().toString());
//                messages.put("Body", response.body().toString());
            } else {
                messages.put("Throwable", t.getMessage());
            }
        }
        Logger.json(new JSONObject(messages).toString());
        callback(result, isSuccessful);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        handler(call, null, t);
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        handler(call, response, null);
    }

    /**
     * 回调
     *
     * @param result       Gson转换后的对象
     * @param isSuccessful 响应成功 && 转换对象成功
     */
    protected abstract void callback(T result, boolean isSuccessful);
}
