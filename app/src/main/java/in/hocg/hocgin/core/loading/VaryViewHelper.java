package in.hocg.hocgin.core.loading;

import android.content.Context;
import android.view.View;

/**
 * Created by hocgin on 16-5-25.
 */
public interface VaryViewHelper {

    View getCurrentLayout();

    void restoreView();

    void showLayout(View view);

    View inflate(int layoutId);

    Context getContext();

    View getView();

}
