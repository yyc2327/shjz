package com.copasso.cocobill.presenter.contract;

import com.copasso.cocobill.base.BaseContract;
import com.copasso.cocobill.model.bean.remote.MyUser;

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
