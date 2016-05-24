package in.hocg.hocgin.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bugtags.library.Bugtags;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.hocg.hocgin.App;
import in.hocg.hocgin.controller.TestController;
import in.hocg.hocgin.myapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.bugBtn)
    Button bugBtn;

    @Inject
    TestController testController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.getAppComponent().inject(this);


        bugBtn.setOnClickListener(this);
        com.orhanobut.logger.Logger.v("2" +String.valueOf(testController));
        testController.testCall();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "-->", Toast.LENGTH_SHORT);
        Bugtags.setInvocationEvent(Bugtags.BTGInvocationEventBubble);
    }
}
