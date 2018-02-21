package com.example.sujin.mvp1;

/**
 * Created by sujin on 1/16/18.
 */

public interface BaseView<P extends BasePresenter> {

  void setPresenter(P presenter);

}
