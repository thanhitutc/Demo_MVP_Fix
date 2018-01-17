package com.thanhclub.demo_mvp_fix.screen.search_user;


import android.view.View;

import com.thanhclub.demo_mvp_fix.data.model.User;
import com.thanhclub.demo_mvp_fix.data.repository.remote.GetDataInteractor;
import com.thanhclub.demo_mvp_fix.data.repository.remote.OnResultGetDataListener;


import java.util.List;

public class SearchUserPresenter implements SearchContract.Presenter, OnResultGetDataListener {
    public static final String LINK_API = "https://api.github.com/search/users?per_page=";
    private SearchContract.SearchView sView;
    private GetDataInteractor getDataInteractor;

    public SearchUserPresenter(SearchContract.SearchView showDataListener) {
        this.sView = showDataListener;
    }

    @Override
    public void onNoData() {
        sView.hideProgress();
        sView.showNoData();
    }

    @Override
    public void onError() {
        sView.hideProgress();
    }

    @Override
    public void onSuccessData(List<User> users) {
        sView.showListUser(users);
        sView.hideProgress();
    }


    @Override
    public void setsView(SearchContract.SearchView view) {
        sView = view;
    }

    @Override
    public void onStart() {
        if (getDataInteractor == null){
            getDataInteractor = new GetDataInteractor(this);
        }
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onSearch(String key, String limit) {
        getDataInteractor.executeGetdata(LINK_API + limit + "&q=" + key);
        sView.showProgress();
    }

}
