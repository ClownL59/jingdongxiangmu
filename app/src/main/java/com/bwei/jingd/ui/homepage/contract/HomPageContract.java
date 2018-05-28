package com.bwei.jingd.ui.homepage.contract;

import com.bwei.jingd.bean.AdBean;
import com.bwei.jingd.bean.CatagoryBean;
import com.bwei.jingd.ui.base.BaseContract;

public interface HomPageContract {
    interface View extends BaseContract.BaseView {
        void getAdSuccess(AdBean adBean);
        void getCatagorySuccess(CatagoryBean catagoryBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getAd();
        void getCatagory();
    }
}
