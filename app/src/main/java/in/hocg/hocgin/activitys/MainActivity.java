package in.hocg.hocgin.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bugtags.library.Bugtags;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.hocg.hocgin.myapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.bugBtn)
    Button bugBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bugBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "-->", Toast.LENGTH_SHORT);
        Bugtags.setInvocationEvent(Bugtags.BTGInvocationEventBubble);
    }
}
