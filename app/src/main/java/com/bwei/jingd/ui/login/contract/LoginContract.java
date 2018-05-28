package com.bwei.jingd.ui.login.contract;

import com.bwei.jingd.bean.UserBean;
import com.bwei.jingd.ui.base.BaseContract;

public interface LoginContract {
    interface View extends BaseContract.BaseView {
        void loginSuccess(UserBean userBean);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void login(String mobile, String password);
    }
}
