package com.bwei.jingd.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.jingd.MainActivity;
import com.bwei.jingd.bean.UserBean;
import com.bwei.jingd.R;
import com.bwei.jingd.component.DaggerHttpComponent;
import com.bwei.jingd.module.HttpModule;
import com.bwei.jingd.ui.base.BaseActivity;
import com.bwei.jingd.ui.login.contract.LoginContract;
import com.bwei.jingd.ui.login.presenter.LoginPresenter;
import com.bwei.jingd.utils.SharedPreferencesUtils;

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener, LoginContract.View {

    private EditText mMobile;
    private EditText mPassword;
    private Button mBtLogin;

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mMobile = (EditText) findViewById(R.id.mobile);
        mPassword = (EditText) findViewById(R.id.password);
        mBtLogin = (Button) findViewById(R.id.btLogin);
        mBtLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btLogin:
                String mobile = mMobile.getText().toString();
                String password = mPassword.getText().toString();
                mPresenter.login(mobile, password);
                break;
        }
    }


    @Override
    public void loginSuccess(UserBean userBean) {
        Toast.makeText(LoginActivity.this, userBean.getMsg(), Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.setParam(LoginActivity.this,"uid",userBean.getData().getUid() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"name",userBean.getData().getUsername() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"iconUrl",userBean.getData().getIcon() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"token",userBean.getData().getToken() + "");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();
    }
}
