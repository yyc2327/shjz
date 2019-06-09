package com.copasso.lifeAccounting.presenter.contract;

import com.copasso.lifeAccounting.base.BaseContract;
import com.copasso.lifeAccounting.model.bean.local.MonthChartBean;

public interface MonthChartContract extends BaseContract {

    interface View extends BaseView {

        void loadDataSuccess(MonthChartBean bean);

    }

    interface Presenter extends BasePresenter<View> {

        void getMonthChart(String id, String year, String month);
    }
}
