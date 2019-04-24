package com.copasso.cocobill.presenter.contract;

import com.copasso.cocobill.base.BaseContract;
import com.copasso.cocobill.model.bean.local.BSort;
import com.copasso.cocobill.model.bean.local.NoteBean;

import java.util.List;

public interface BillNoteContract extends BaseContract {

    interface View extends BaseView {

        void loadDataSuccess(NoteBean bean);

    }

    interface Presenter extends BasePresenter<View>{
        /**
         * 获取信息
         */
        void getBillNote();

        void updateBBsorts(List<BSort> items);

        void addBSort(BSort bSort);
        void deleteBSortByID(Long id);
    }
}
