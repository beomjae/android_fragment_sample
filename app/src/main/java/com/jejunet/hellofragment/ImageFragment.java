package com.jejunet.hellofragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFragment extends Fragment implements View.OnClickListener{
    private ImageView imageView;
    public OnImageSelectedListener onImageSelectedListener;

    public static ImageFragment newInstance(){
        ImageFragment imageFragment = new ImageFragment();
        return imageFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onImageSelectedListener = (OnImageSelectedListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnImageSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image, container, false);
        imageView = (ImageView) v.findViewById(R.id.image1);
        imageView.setOnClickListener(this);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
            if(onImageSelectedListener != null) {
                onImageSelectedListener.onImageSelected("Image1");
            }
    }

    public interface OnImageSelectedListener {
        public void onImageSelected(String msg);
    }
}
