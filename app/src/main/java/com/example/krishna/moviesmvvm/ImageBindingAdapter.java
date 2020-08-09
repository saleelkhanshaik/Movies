package com.example.krishna.moviesmvvm;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.databinding.BindingAdapter;

import com.example.krishna.common.CircleTransform;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ImageBindingAdapter {
    @BindingAdapter({"bindimageUrl","progressbar"})
    public static void loadImage(ImageView imageView, String URL,ProgressBar progressBar){
        Picasso.get()
                .load(URL)
                .centerCrop()
                .transform(new CircleTransform(50,0))
                .fit()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }
}
