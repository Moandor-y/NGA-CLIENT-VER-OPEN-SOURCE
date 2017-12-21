package gov.anzong.androidnga.activity;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;

import sp.phone.common.UserManagerImpl;
import sp.phone.utils.ActivityUtils;

/**
 * Created by Justwen on 2017/11/27.
 */
@Interceptor(priority = 8)
public class ActivityInterceptor implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback interceptorCallback) {
        if (postcard.getExtra() == ActivityUtils.REQUEST_CODE_LOGIN && UserManagerImpl.getInstance().getActiveUser() == null) {
            interceptorCallback.onInterrupt(new Exception("未登录"));
            ARouter.getInstance().build(ActivityUtils.PATH_LOGIN).navigation();
        } else {
            interceptorCallback.onContinue(postcard);
        }

    }

    @Override
    public void init(Context context) {

    }
}
