package com.copasso.lifeAccounting.presenter.contract;

import com.copasso.lifeAccounting.base.BaseContract;
import com.copasso.lifeAccounting.model.bean.remote.MyUser;

public interface UserInfoContract extends BaseContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View>{
        /**
         * 更新用户信息
         */
        void updateUser(MyUser user);
    }


}
