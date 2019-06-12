package com.thanhclub.demo_mvp_fix.data.repository.remote;

import com.thanhclub.demo_mvp_fix.data.model.User;

import java.util.List;

/**
 * Created by MyPC on 16/01/2018.
 */

public interface OnResultGetDataListener {

    public void onNoData();

    public void onError();

    public void onSuccessData(List<User> users);
}
