package com.bwei.jingd.module;


import com.bwei.jingd.net.AdApi;
import com.bwei.jingd.net.AdApiService;
import com.bwei.jingd.net.AddCartApi;
import com.bwei.jingd.net.AddCartApiService;
import com.bwei.jingd.net.AddrsApi;
import com.bwei.jingd.net.AddrsApiService;
import com.bwei.jingd.net.Api;
import com.bwei.jingd.net.CatagoryApi;
import com.bwei.jingd.net.CatagoryApiService;
import com.bwei.jingd.net.CreateOrderApi;
import com.bwei.jingd.net.CreateOrderApiService;
import com.bwei.jingd.net.DeleteCartApi;
import com.bwei.jingd.net.DeleteCartApiService;
import com.bwei.jingd.net.GetCartApi;
import com.bwei.jingd.net.GetCartApiService;
import com.bwei.jingd.net.ListApi;
import com.bwei.jingd.net.ListApiService;
import com.bwei.jingd.net.LoginApi;
import com.bwei.jingd.net.LoginApiService;
import com.bwei.jingd.net.MyInterceptor;
import com.bwei.jingd.net.OrderApi;
import com.bwei.jingd.net.OrderApiService;
import com.bwei.jingd.net.ProductCatagoryApi;
import com.bwei.jingd.net.ProductCatagoryApiService;
import com.bwei.jingd.net.UpdateCartApi;
import com.bwei.jingd.net.UpdateCartApiService;
import com.bwei.jingd.net.UpdateHeaderApi;
import com.bwei.jingd.net.UpdateHeaderApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor);
    }

    @Provides
    LoginApi provideLoginApi(OkHttpClient.Builder builder) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        LoginApiService loginApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getLoginApi(loginApiService);
    }

    @Provides
    AdApi provideAdApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AdApiService adApiService = retrofit.create(AdApiService.class);
        return AdApi.getAdApi(adApiService);
    }

    @Provides
    CatagoryApi provideCatagoryApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        CatagoryApiService catagoryApiService = retrofit.create(CatagoryApiService.class);
        return CatagoryApi.getCatagoryApi(catagoryApiService);
    }

    @Provides
    ProductCatagoryApi provideProductCatagoryApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ProductCatagoryApiService productCatagoryApiService = retrofit.create(ProductCatagoryApiService.class);
        return ProductCatagoryApi.getProductCatagoryApi(productCatagoryApiService);
    }

    @Provides
    ListApi provideListApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ListApiService listApiService = retrofit.create(ListApiService.class);
        return ListApi.getListApi(listApiService);
    }

    @Provides
    AddCartApi provideAddCartApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AddCartApiService addCartApiService = retrofit.create(AddCartApiService.class);
        return AddCartApi.getAddCartApi(addCartApiService);
    }

    @Provides
    GetCartApi provideGetCartApi(OkHttpClient.Builder builder) {
        builder.addInterceptor(new MyInterceptor());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        GetCartApiService getCartApiService = retrofit.create(GetCartApiService.class);
        return GetCartApi.getGetCartApi(getCartApiService);
    }

    @Provides
    UpdateCartApi provideUpdateCartApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        UpdateCartApiService updateCartApiService = retrofit.create(UpdateCartApiService.class);
        return UpdateCartApi.getUpdateCartApi(updateCartApiService);
    }

    @Provides
    DeleteCartApi provideDeleteCartApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        DeleteCartApiService deleteCartApiService = retrofit.create(DeleteCartApiService.class);
        return DeleteCartApi.getDeleteCartApi(deleteCartApiService);
    }

    @Provides
    AddrsApi provideAddrsApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        AddrsApiService addrsApiService = retrofit.create(AddrsApiService.class);
        return AddrsApi.getAddrsApi(addrsApiService);
    }

    @Provides
    CreateOrderApi provideCreateOrderApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        CreateOrderApiService createOrderApiService = retrofit.create(CreateOrderApiService.class);
        return CreateOrderApi.getCreateOrderApi(createOrderApiService);
    }

    @Provides
    UpdateHeaderApi provideUpdateHeaderApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        UpdateHeaderApiService updateHeaderApiService = retrofit.create(UpdateHeaderApiService.class);
        return UpdateHeaderApi.getUpdateHeaderApi(updateHeaderApiService);
    }

    @Provides
    OrderApi provideOrderApi(OkHttpClient.Builder builder) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        OrderApiService orderApiService = retrofit.create(OrderApiService.class);
        return OrderApi.getOrderApi(orderApiService);
    }
}
