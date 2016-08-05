package mal.com.cfb.views.activities;

import android.support.v7.app.AppCompatActivity;

import mal.com.cfb.exception.ExceptionUtil;

public class CFBActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        // For handling the exception that need to be shown to the user
        ExceptionUtil.getSharedInstance().registerCurrentActivity(this);
    }

}
