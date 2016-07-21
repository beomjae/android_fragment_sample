package com.jejunet.hellofragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Image2Fragment extends Fragment {
    private OnCarSelectedListener onCarSelectedListener;
    private ImageView carImage;

    public static Image2Fragment newInstance() {
        Image2Fragment fragment = new Image2Fragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onCarSelectedListener = (OnCarSelectedListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onCarSelectedListener");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image2, container, false);
        carImage = (ImageView) v.findViewById(R.id.image2);
        carImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCarSelectedListener.onCarSelected();
            }
        });

        return v;
    }

    public interface OnCarSelectedListener {
        public void onCarSelected();
    }

}
