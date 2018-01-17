package com.thanhclub.demo_mvp_fix.screen.search_user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.thanhclub.demo_mvp_fix.OnItemRecyclerClickListener;
import com.thanhclub.demo_mvp_fix.R;
import com.thanhclub.demo_mvp_fix.adapter.UserAdapter;
import com.thanhclub.demo_mvp_fix.data.model.User;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements
        SearchContract.SearchView, View.OnClickListener, OnItemRecyclerClickListener {
    public static final String KEY_NAME_USERS = "NAME_USER";
    public static final String KEY_IMAGE_USER = "IMAGE_USER";
    private Button btnSearch;
    private EditText edtKeyword;
    private EditText edtLimit;
    private ProgressBar progressBar;
    private SearchUserPresenter presenter;
    private RecyclerView rc_user;
    private RecyclerView.LayoutManager layoutManager;
    private List<User> userList;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initViews();
        initActions();
        presenter.onStart();
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showNoData() {
        Toast.makeText(this, "Không có user!", Toast.LENGTH_SHORT).show();
        if (userList != null) userList.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showListUser(List<User> users) {
        userList = users;
        adapter = new UserAdapter(this, userList);
        rc_user.setAdapter(adapter);
        adapter.setListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_search_user:
                presenter.onSearch(edtKeyword.getText().toString(), edtLimit.getText().toString());
                break;
        }
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    private void initViews() {
        progressBar = (ProgressBar) findViewById(R.id.pro_bar_search);
        edtKeyword = (EditText) findViewById(R.id.edt_keyword);
        edtLimit = (EditText) findViewById(R.id.edt_limit_user);
        btnSearch = (Button) findViewById(R.id.btn_search_user);
        rc_user = (RecyclerView) findViewById(R.id.rc_user);
        layoutManager = new LinearLayoutManager(this);
        rc_user.setLayoutManager(layoutManager);
    }

    private void initActions() {
        presenter = new SearchUserPresenter(this);
        presenter.setsView(this);
        btnSearch.setOnClickListener(this);
        progressBar.setVisibility(View.GONE);
    }
}
