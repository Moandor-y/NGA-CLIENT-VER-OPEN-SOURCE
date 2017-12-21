package sp.phone.fragment.material;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import sp.phone.mvp.contract.BaseContract;
import sp.phone.mvp.presenter.BasePresenter;

/**
 * Created by Justwen on 2017/11/25.
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseRxFragment implements BaseContract.View {

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = onCreatePresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        if (mPresenter != null) {
            mPresenter.detach();
        }
        super.onDetach();
    }

    protected abstract T onCreatePresenter();
}
