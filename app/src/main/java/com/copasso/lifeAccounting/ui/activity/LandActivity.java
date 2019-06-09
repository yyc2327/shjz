package com.copasso.lifeAccounting.ui.activity;

import android.content.Intent;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.copasso.lifeAccounting.R;
import com.copasso.lifeAccounting.base.BaseMVPActivity;
import com.copasso.lifeAccounting.model.bean.remote.MyUser;
import com.copasso.lifeAccounting.presenter.LandPresenter;
import com.copasso.lifeAccounting.presenter.contract.LandContract;
import com.copasso.lifeAccounting.utils.ProgressUtils;
import com.copasso.lifeAccounting.utils.SnackbarUtils;
import com.copasso.lifeAccounting.utils.StringUtils;
import com.copasso.lifeAccounting.utils.ToastUtils;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * 用户登录、注册activity
 */
public class LandActivity extends BaseMVPActivity<LandContract.Presenter>
        implements LandContract.View,  View.OnClickListener {

    private EditText emailET;
    private EditText usernameET;
    private EditText passwordET;
    private EditText rpasswordET;
    private TextView signTV;
    private TextView forgetTV;
    private Button loginBtn;

    //是否是登陆操作
    private boolean isLogin = true;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_land;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        emailET=findViewById(R.id.login_et_email);
        usernameET=findViewById(R.id.login_et_username);
        passwordET=findViewById(R.id.login_et_password);
        rpasswordET=findViewById(R.id.login_et_rpassword);
        signTV=findViewById(R.id.login_tv_sign);
        forgetTV=findViewById(R.id.login_tv_forget);
        loginBtn=findViewById(R.id.login_btn_login);
    }

    @Override
    protected void initClick() {
        super.initClick();
        signTV.setOnClickListener(this);
        forgetTV.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn_login:  //button
                if (isLogin) {
                    login();  //登陆
                } else {
                    sign();  //注册
                }
                break;
            case R.id.login_tv_sign:  //sign
                if (isLogin) {
                    //置换注册界面
                    signTV.setText("登录");
                    loginBtn.setText("注册");
                    rpasswordET.setVisibility(View.VISIBLE);
                    forgetTV.setVisibility(View.GONE);
                    emailET.setVisibility(View.VISIBLE);
                } else {
                    //置换登陆界面
                    signTV.setText("注册");
                    loginBtn.setText("登录");
                    rpasswordET.setVisibility(View.GONE);
                    forgetTV.setVisibility(View.VISIBLE);
                    emailET.setVisibility(View.GONE);
                }
                isLogin = !isLogin;
                break;
            case R.id.login_tv_forget:  //忘记密码
                showForgetPwDialog();
                break;
            default:
                break;
        }
    }

    /**
     * 显示忘记密码对话框
     */
    public void showForgetPwDialog() {
        new MaterialDialog.Builder(this)
                .title("备注")
                .inputType(InputType.TYPE_CLASS_TEXT)
                .input("请输入注册邮箱", null, (dialog, input) -> {
                    if (!StringUtils.checkEmail(input.toString())) {
                        SnackbarUtils.show(mContext, "请输入正确的邮箱格式");
                        return;
                    }
                    if (input.equals("")) {
                        SnackbarUtils.show(mContext, "内容不能为空！");

                    } else {
                        //找回密码
                        BmobUser.resetPasswordByEmail(input.toString(), new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                if (e == null) {
                                    ToastUtils.show(mContext, "重置密码请求成功，请到邮箱进行密码重置操作");
                                } else {
                                    ToastUtils.show(mContext, "失败:" + e.getMessage());
                                }
                            }
                        });
                    }
                })
                .positiveText("确定")
                .negativeText("取消")
                .show();
    }


    /**
     * 执行登陆动作
     */
    public void login() {
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        if (username.length() == 0 || password.length() == 0) {
            SnackbarUtils.show(mContext, "用户名或密码不能为空");
            return;
        }

        ProgressUtils.show(this, "正在登陆...");

        mPresenter.login(username, password);
    }

    /**
     * 执行注册动作
     */
    public void sign() {
        String email = emailET.getText().toString();
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();
        String rpassword = rpasswordET.getText().toString();
        if (email.length() == 0 || username.length() == 0 || password.length() == 0 || rpassword.length() == 0) {
            SnackbarUtils.show(mContext, "请填写必要信息");
            return;
        }
        if (!StringUtils.checkEmail(email)) {
            SnackbarUtils.show(mContext, "请输入正确的邮箱格式");
            return;
        }
        if (!password.equals(rpassword)) {
            SnackbarUtils.show(mContext, "两次密码不一致");
            return;
        }

        ProgressUtils.show(this, "正在注册...");

        mPresenter.signup(username,password,email);

    }

    /***********************************************************************/

    @Override
    protected LandContract.Presenter bindPresenter() {
        return new LandPresenter();
    }

    @Override
    public void landSuccess(MyUser user) {
        ProgressUtils.dismiss();
        if (isLogin) {
            setResult(RESULT_OK, new Intent());
            finish();
        }else {
            SnackbarUtils.show(mContext, "注册成功");
        }
        Log.i(TAG,user.toString());
    }

    @Override
    public void onSuccess() {
    }

    @Override
    public void onFailure(Throwable e) {
        ProgressUtils.dismiss();
        SnackbarUtils.show(mContext, e.getMessage());
        Log.e(TAG,e.getMessage());
    }
}
