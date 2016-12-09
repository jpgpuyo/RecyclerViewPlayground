package com.jpuyo.android.recyclerviewplayground.ui.common.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jpuyo.android.recyclerviewplayground.R;

import butterknife.BindView;

public abstract class RecyclerViewActivity extends BaseActivity{

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_recycler_view);
        super.onCreate(savedInstanceState);
        setupToolbar();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        setTitle(getToolbarTitle());
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null ) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public abstract String getToolbarTitle();


}
