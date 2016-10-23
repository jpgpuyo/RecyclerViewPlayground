package com.jpuyo.android.recyclerviewplayground.common.activities;

import android.os.Bundle;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.common.navigation.Navigator;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        navigator = new Navigator(this);
    }

    @OnClick(R.id.btn_sample_no_libraries)
    public void openNoLibrariesSample() {
        navigator.loadNoLibrariesSample();
    }

    @OnClick(R.id.btn_sample_epoxy)
    public void openEpoxySample() {
        navigator.loadEpoxySample();
    }

    @OnClick(R.id.btn_sample_renderers)
    public void openRenderersSample() {
        navigator.loadRenderersSample();
    }

    @OnClick(R.id.btn_sample_groupie)
    public void openGroupieSample() {
        navigator.loadGroupieSample();
    }
}
