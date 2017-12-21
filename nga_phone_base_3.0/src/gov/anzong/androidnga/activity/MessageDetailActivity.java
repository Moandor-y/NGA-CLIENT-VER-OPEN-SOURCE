package gov.anzong.androidnga.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import gov.anzong.androidnga.R;
import sp.phone.fragment.material.MessageDetailFragment;
import sp.phone.utils.StringUtils;

public class MessageDetailActivity extends SwipeBackAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        setupActionBar();
        initFragment();
    }

    private void initFragment() {
        Fragment fragment = new MessageDetailFragment();
        fragment.setHasOptionsMenu(true);
        Bundle bundle = new Bundle();
        String url = getIntent().getDataString();
        int mid;
        if (null != url) {
            mid = StringUtils.getUrlParameter(url, "mid");
        } else {
            mid = getIntent().getIntExtra("mid", 0);
        }
        bundle.putInt("mid", mid);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

}