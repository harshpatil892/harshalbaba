package com.example.harshal.jitu;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundSoundService extends Service implements BackgroundSoundServicee {
    Context context;
    private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.song);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);

    }

    @SuppressLint("WrongConstant")
    public int onStartCommand(Intent intent, int flags, int startId) {
//        player.start();
        return 0;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }
    public IBinder onUnBind(Context arg0) {
        // TO DO Auto-generated method
        if(player.isPlaying()){
            player.stop();
        }
        return null;
    }

    @Override
    public void onStop() {
        onUnBind(context);
        player.stop();
        player.release();
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        onUnBind(context);
    }

    @Override
    public void onPause() {
        player.stop();
        player.release();
        onUnBind(context);
    }

    @Override
    public void onLowMemory() {

    }
}