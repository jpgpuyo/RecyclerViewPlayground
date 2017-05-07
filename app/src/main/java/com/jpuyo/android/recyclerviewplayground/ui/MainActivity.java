package com.jpuyo.android.recyclerviewplayground.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jpuyo.android.recyclerviewplayground.R;
import com.jpuyo.android.recyclerviewplayground.ui.common.navigation.ActivityNavigator;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_sample_no_libraries)
    public void openNoLibrariesSample() {
        ActivityNavigator.loadNoLibrariesSample(this);
    }

    @OnClick(R.id.btn_sample_epoxy)
    public void openEpoxySample() {
        ActivityNavigator.loadEpoxySample(this);
    }

    @OnClick(R.id.btn_sample_renderers)
    public void openRenderersSample() {
        ActivityNavigator.loadRenderersSample(this);
    }

    @OnClick(R.id.btn_sample_groupie)
    public void openGroupieSample() {
        ActivityNavigator.loadGroupieSample(this);
    }
}
