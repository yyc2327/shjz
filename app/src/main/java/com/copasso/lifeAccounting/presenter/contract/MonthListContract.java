package com.copasso.lifeAccounting.presenter.contract;

import com.copasso.lifeAccounting.base.BaseContract;
import com.copasso.lifeAccounting.model.bean.local.BBill;
import com.copasso.lifeAccounting.model.bean.local.MonthListBean;

public interface MonthListContract extends BaseContract {

    interface View extends BaseContract.BaseView {

        void loadDataSuccess(MonthListBean list);

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

        void getMonthList(String id, String year, String month);

        void deleteBill(Long id);

        void updateBill(BBill bBill);
    }
}
