package com.bwei.jingd.ui.classify.contract;


import com.bwei.jingd.bean.CatagoryBean;
import com.bwei.jingd.bean.ProductCatagoryBean;
import com.bwei.jingd.ui.base.BaseContract;

public interface ClassifyContract {
    interface View extends BaseContract.BaseView {
        void getProductCatagorySuccess(ProductCatagoryBean productCatagoryBean);
        void getCatagorySuccess(CatagoryBean catagoryBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getProductCatagory(String cid);
        void getCatagory();
    }
}
