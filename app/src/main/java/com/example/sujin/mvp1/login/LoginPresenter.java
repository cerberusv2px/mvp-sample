package com.example.sujin.mvp1.login;

import android.text.TextUtils;
import android.util.Log;
import com.example.sujin.mvp1.login.LoginContract.View;

/**
 * Created by sujin on 1/16/18.
 */

public class LoginPresenter implements LoginContract.Presenter {

  private static final String TAG = LoginPresenter.class.getSimpleName();
  private LoginContract.View view;

  public LoginPresenter(LoginContract.View view) {
    this.view = view;
    view.setPresenter(this);
  }

  @Override
  public void start() {
    Log.e(TAG, "Start");
  }

  @Override
  public void stop() {
    Log.e(TAG, "Stop");
  }

  @Override
  public void validateCredential(String username, String password) {
    Log.e(TAG, "Validate credential");
    if(TextUtils.isEmpty(username)) {
      view.hideProgress();
      view.showUsernameError();
      return;
    }

    if(TextUtils.isEmpty(password)) {
      view.hideProgress();
      view.showPasswordError();
      return;
    }

    view.navigateToMain();
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy");
  }


}
