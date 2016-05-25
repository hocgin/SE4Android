package in.hocg.hocgin.view;

import android.content.Context;

/**
 * Created by hocgin on 16-5-24.
 */
public interface LoadDataView {

    /**
     * show loading message
     *
     * @param msg
     */
    void showLoading(String msg);

    /**
     * hide loading
     */
    void hideLoading();

    /**
     * show error message
     */
    void showError(String msg);

    /**
     * show exception message
     */
    void showException(String msg);

    /**
     * show net error
     */
    void showNetError();

    /**
     * Get a {@link android.content.Context}.
     */
    Context context();
}
