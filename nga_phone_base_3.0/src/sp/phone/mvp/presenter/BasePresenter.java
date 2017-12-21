package sp.phone.mvp.presenter;

import sp.phone.mvp.contract.BaseContract;

/**
 * Created by Justwen on 2017/11/25.
 */

public abstract class BasePresenter<T extends BaseContract.View, E extends BaseContract.Model> implements BaseContract.Presenter<T> {

    protected T mBaseView;

    protected E mBaseModel;

    public BasePresenter() {
        mBaseModel = onCreateModel();
    }

    @Override
    public void detach() {
        mBaseView = null;
        mBaseModel.detach();
    }

    @Override
    public void attachView(T view) {
        mBaseView = view;
        mBaseModel.setLifecycleProvider(view.getLifecycleProvider());
    }

    @Override
    public boolean isAttached() {
        return mBaseView != null;
    }

    protected abstract E onCreateModel();
}
