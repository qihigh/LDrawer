package com.ikimuhendis.ldrawer.sample;

import android.widget.ImageView;
import android.widget.SeekBar;

import com.ikimuhendis.ldrawer.DrawerArrowDrawable;

import butterknife.InjectView;
import butterknife.OnClick;

public class NoActionBarSampleActivity extends BaseActivity {

    private DrawerArrowDrawable mDrawerArrow;

    @InjectView(R.id.drawer_arrow)
    ImageView mImageView;

    @InjectView(R.id.drawer_seekbar)
    SeekBar mSeekbar;

    private boolean isMirror = false;

    @Override
    public void initContentView() {
        setContentView(R.layout.activity_no_action_bar_sample);
    }

    @Override
    public void initView() {
        mDrawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };
        mDrawerArrow.setColor(android.R.color.holo_blue_bright);

        mImageView.setImageDrawable(mDrawerArrow);
    }

    @Override
    public void initListener() {
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mDrawerArrow.setProgress(progress / 100F);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.change_drawer_direction)
    public void drawerAction() {
        mDrawerArrow.setVerticalMirror(isMirror);
        isMirror = !isMirror;
    }
}

