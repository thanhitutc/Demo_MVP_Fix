package com.thanhclub.demo_mvp_fix.screen.search_user;

import android.view.View;

import com.thanhclub.demo_mvp_fix.BasePresenter;
import com.thanhclub.demo_mvp_fix.data.model.User;

import java.util.List;

/**
 * Created by MyPC on 17/01/2018.
 */

public interface SearchContract {

    interface SearchView{
        public void showProgress();

        public void hideProgress();

        public void showNoData();

        public void showListUser(List<User> users);
    }

    interface Presenter extends BasePresenter<SearchView>{

        public void onSearch(String key, String limit);

    }
}
