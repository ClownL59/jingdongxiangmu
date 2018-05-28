package com.bwei.jingd.ui.classify.contract;


import com.bwei.jingd.bean.ProductsBean;
import com.bwei.jingd.ui.base.BaseContract;

import java.util.List;

public interface ListContract {
    interface View extends BaseContract.BaseView {
        void onSuccess(List<ProductsBean.DataBean> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getProducts(String pscid);
    }
}
