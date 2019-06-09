package com.copasso.lifeAccounting.presenter.contract;

import com.copasso.lifeAccounting.base.BaseContract;
import com.copasso.lifeAccounting.model.bean.local.BBill;
import com.copasso.lifeAccounting.model.bean.local.NoteBean;

public interface BillContract extends BaseContract {

    interface View extends BaseView {

        void loadDataSuccess(NoteBean bean);

    }

    interface Presenter extends BasePresenter<View>{
        /**
         * 获取信息
         */
        void getBillNote();

        /**
         * 添加账单
         */
        void addBill(BBill bBill);

        /**
         * 修改账单
         */
        void updateBill(BBill bBill);


        /**
         * 删除账单
         */
        void deleteBillById(Long id);
    }
}
