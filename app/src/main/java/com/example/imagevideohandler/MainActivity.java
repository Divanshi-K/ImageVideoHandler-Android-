package com.example.imagevideohandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.MediaController;


public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;
    AppCompatButton bnimg,bnvid,bnfs;
    ImageView image1;
    LinearLayout llvid,llimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoView);
        bnimg = findViewById(R.id.bnimg);
        bnvid = findViewById(R.id.bnvid);
        bnfs = findViewById(R.id.bnfulvid);
        image1 = findViewById(R.id.image1);
        llimg = findViewById(R.id.llimage);
        llvid = findViewById(R.id.llvideo);

        bnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llimg.setVisibility(View.VISIBLE);
                llvid.setVisibility(View.GONE);
            }
        });

        bnvid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llimg.setVisibility(View.GONE);
                llvid.setVisibility(View.VISIBLE);
            }
        });

        bnfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llimg.setVisibility(View.GONE);
                llvid.setVisibility(View.VISIBLE);
            }
        });

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://"+
                getPackageName() + "/"+
                R.raw.video));
    }
    private void ShowNormalVideo()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) videoView.getLayoutParams();
        params.weight = 700;
        params.height = 400;
        params.leftMargin = 0;
        videoView.setLayoutParams(params);
        videoView.start();
    }
    private void ShowFullScreenVideo()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)videoView.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.heightPixels;
        params.leftMargin = 0;
        videoView.setLayoutParams(params);
        videoView.start();
    }
}