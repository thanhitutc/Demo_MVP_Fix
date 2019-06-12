package com.thanhclub.demo_mvp_fix;

/**
 * Created by le.quang.dao on 10/03/2017.
 */

public interface BasePresenter<T> {

    void setsView(T sView);

    void onStart();

    void onStop();
}
