package com.example.sujin.mvp1.login;

import com.example.sujin.mvp1.BasePresenter;
import com.example.sujin.mvp1.BaseView;

/**
 * Created by sujin on 1/16/18.
 */

public interface LoginContract {

  interface View extends BaseView<Presenter>{

    void showProgress();

    void hideProgress();

    void showUsernameError();

    void showPasswordError();

    void navigateToMain();
  }

  interface Presenter extends BasePresenter{
    void validateCredential(String username, String password);

    void onDestroy();
  }
}
