package com.jejunet.hellofragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ImageFragment.OnImageSelectedListener, Image2Fragment.OnCarSelectedListener{
    @BindView(R.id.content_frame) FrameLayout contentFrame;
    @OnClick(R.id.fragment1_btn) void onClickButton1() {
        ImageFragment imageFragment = ImageFragment.newInstance();
        addFragmentToContentFrame(imageFragment);
    }

    @OnClick(R.id.fragment2_btn) void onClickButton2() {
        Image2Fragment image2Fragment = Image2Fragment.newInstance();
        addFragmentToContentFrame(image2Fragment);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void addFragmentToContentFrame(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onImageSelected(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCarSelected() {
        Toast.makeText(this, "CAR IMAGE!!!", Toast.LENGTH_SHORT).show();
    }
}
