package com.example.psm;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.longdo.mjpegviewer.MjpegView;


public class MainActivity extends AppCompatActivity {

    private String websiteUri = "http://192.168.0.105:5000";
    private ProgressDialog progressDialog;
    private MjpegView mjpegView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        playerView = findViewById(R.id.exoplayer_view);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("buffering");
        progressDialog.setCancelable(true);

        mjpegView = findViewById(R.id.mjpegView);

        mjpegView.setMode(MjpegView.MODE_FIT_WIDTH);
        mjpegView.setAdjustHeight(true);
        mjpegView.setSupportPinchZoomAndPan(true);
        mjpegView.setUrl(websiteUri);
        mjpegView.startStream();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mjpegView.stopStream();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mjpegView.startStream();
    }
}
