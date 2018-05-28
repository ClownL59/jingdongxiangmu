package com.bwei.jingd.ui.base;

public interface BaseContract {
    //绑定，解绑
    interface BasePresenter<T extends BaseView> {
        void attchView(T view);

        void detachView();
    }

    //显示进度条和关闭进度
    interface BaseView {
        void showLoading();

        void dismissLoading();
    }
}
