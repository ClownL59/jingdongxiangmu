package com.bwei.jingd.component;

import com.bwei.jingd.module.HttpModule;
import com.bwei.jingd.ui.classify.ClassifyFragment;
import com.bwei.jingd.ui.classify.ListActivity;
import com.bwei.jingd.ui.classify.ListDetailsActivity;
import com.bwei.jingd.ui.homepage.HomePageFragment;
import com.bwei.jingd.ui.login.LoginActivity;
import com.bwei.jingd.ui.mine.MakeSureOrderActivity;
import com.bwei.jingd.ui.mine.UserInfoActivity;
import com.bwei.jingd.ui.mine.fragment.FragmentAllOrder;
import com.bwei.jingd.ui.mine.fragment.FragmentWaitOrder;
import com.bwei.jingd.ui.shopcart.ShopCartActivity;
import com.bwei.jingd.ui.shopcart.ShopCartActivity2;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(LoginActivity loginActivity);

    void inject(HomePageFragment homePageFragment);

    void inject(ClassifyFragment classifyFragment);

    void inject(ListActivity listActivity);

    void inject(ListDetailsActivity listDetailsActivity);

    void inject(ShopCartActivity shopCartActivity);

    void inject(ShopCartActivity2 shopCartActivity2);

    void inject(MakeSureOrderActivity makeSureOrderActivity);

    void inject(UserInfoActivity userInfoActivity);

    void inject(FragmentAllOrder fragmentAllOrder);

    void inject(FragmentWaitOrder fragmentWaitOrder);
}
