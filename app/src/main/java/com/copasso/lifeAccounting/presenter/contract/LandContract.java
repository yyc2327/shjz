package com.copasso.lifeAccounting.presenter.contract;

import com.copasso.lifeAccounting.base.BaseContract;
import com.copasso.lifeAccounting.model.bean.remote.MyUser;

public interface LandContract extends BaseContract {

    interface View extends BaseContract.BaseView {

        void landSuccess(MyUser user);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        /**
         * 用户登陆
         */
        void login(String username, String password);

        /**
         * 用户注册
         */
        void signup(String username, String password, String mail);
    }
}
