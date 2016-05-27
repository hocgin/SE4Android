package in.hocg.app.core.loading;

import android.view.View;

/**
 * Created by hocgin on 16-5-25.
 */
public class VaryViewManager {
    private VaryViewHelper helper;

    public VaryViewManager(View view) {
        this(new DefaultVaryViewHelper(view));
    }

    public VaryViewManager(VaryViewHelper helper) {
        super();
        this.helper = helper;
    }

    public void showNetworkError(View.OnClickListener onClickListener) {
//        View layout = helper.inflate(R.layout.message);
//        TextView textView = (TextView) layout.findViewById(R.id.message_info);
//        textView.setText(helper.getContext().getResources().getString(R.string.network_error));
//
//        ImageView imageView = (ImageView) layout.findViewById(R.id.message_icon);
//        imageView.setImageResource(R.mipmap.ic_exception);
//
//        if (null != onClickListener) {
//            layout.setOnClickListener(onClickListener);
//        }
//
//        helper.showLayout(layout);
    }

    public void showError(String errorMsg, View.OnClickListener onClickListener) {
//        View layout = helper.inflate(R.layout.message);
//        TextView textView = (TextView) layout.findViewById(R.id.message_info);
//        if (!LangKit.isEmpty(errorMsg)) {
//            textView.setText(errorMsg);
//        } else {
//            textView.setText(helper.getContext().getResources().getString(R.string.common_error_msg));
//        }
//
//        ImageView imageView = (ImageView) layout.findViewById(R.id.message_icon);
//        imageView.setImageResource(R.drawable.ic_error);
//
//        if (null != onClickListener) {
//            layout.setOnClickListener(onClickListener);
//        }
//
//        helper.showLayout(layout);
    }

    public void showEmpty(String emptyMsg, View.OnClickListener onClickListener) {
//        View layout = helper.inflate(R.layout.message);
//        TextView textView = (TextView) layout.findViewById(R.id.message_info);
//        if (!LangKit.isEmpty(emptyMsg)) {
//            textView.setText(emptyMsg);
//        } else {
//            textView.setText(helper.getContext().getResources().getString(R.string.common_empty_msg));
//        }
//
//        ImageView imageView = (ImageView) layout.findViewById(R.id.message_icon);
//        imageView.setImageResource(R.drawable.ic_exception);
//
//        if (null != onClickListener) {
//            layout.setOnClickListener(onClickListener);
//        }
//
//        helper.showLayout(layout);
    }

    public void showLoading(String msg) {
//        View layout = helper.inflate(R.layout.loading);
//        if (!LangKit.isEmpty(msg)) {
//            TextView textView = (TextView) layout.findViewById(R.id.loading_msg);
//            textView.setText(msg);
//        }
//        helper.showLayout(layout);
    }

    public void restore() {
        helper.restoreView();
    }
}
