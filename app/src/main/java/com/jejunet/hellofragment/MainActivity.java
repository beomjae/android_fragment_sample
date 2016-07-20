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

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.content_frame) FrameLayout contentFrame;
    @OnClick(R.id.fragment1_btn) void onClickButton1() {
        Toast.makeText(this, "Button1", Toast.LENGTH_SHORT).show();
        ImageFragment imageFragment = ImageFragment.newInstance();
        addFragmentToContentFrame(imageFragment);
    }

    @OnClick(R.id.fragment2_btn) void onClickButton2() {
        // TODO button2
        Toast.makeText(this, "Button2", Toast.LENGTH_SHORT).show();
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
        fragmentTransaction.add(R.id.content_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
