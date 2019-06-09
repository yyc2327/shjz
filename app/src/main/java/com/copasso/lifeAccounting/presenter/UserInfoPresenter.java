package com.copasso.lifeAccounting.presenter;


import com.copasso.lifeAccounting.base.RxPresenter;
import com.copasso.lifeAccounting.model.bean.remote.MyUser;
import com.copasso.lifeAccounting.presenter.contract.UserInfoContract;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class UserInfoPresenter extends RxPresenter<UserInfoContract.View>
        implements UserInfoContract.Presenter {

    private String TAG = "UserInfoPresenter";

    @Override
    public void updateUser(MyUser user) {
        user.update(user.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null)
                    mView.onSuccess();
                else
                    mView.onFailure(e);
            }
        });
    }
}
