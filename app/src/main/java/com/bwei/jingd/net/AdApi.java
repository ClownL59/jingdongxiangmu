package com.bwei.jingd.net;


import com.bwei.jingd.bean.AdBean;

import io.reactivex.Observable;

public class AdApi {
    private static AdApi adApi;
    private AdApiService adApiService;

    private AdApi(AdApiService adApiService) {
        this.adApiService = adApiService;
    }

    public static AdApi getAdApi(AdApiService adApiService) {
        if (adApi == null) {
            adApi = new AdApi(adApiService);
        }
        return adApi;
    }

    public Observable<AdBean> getAd() {
        return adApiService.getAd();
    }
}
