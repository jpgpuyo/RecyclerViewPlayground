package com.jpuyo.android.recyclerviewplayground.common.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.jpuyo.android.recyclerviewplayground.R;

import butterknife.BindView;

public class RecyclerViewActivity extends BaseActivity{

    @BindView(R.id.mainRecyclerView)
    RecyclerView mainRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_recycler_view);
        super.onCreate(savedInstanceState);
    }
}
