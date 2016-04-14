package com.example.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MediaService extends Service { 
	
	private MediaPlayer mediaPlayer;
	private int[] musics={R.raw.a1,R.raw.a2};
	//private MediaPlayer fo

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		if(mediaPlayer != null){
			mediaPlayer.stop();
		}
		String data = intent.getStringExtra("data");
		if(data.equalsIgnoreCase("forward")){
			mediaPlayer=MediaPlayer.create(this,musics[0]);
		}else if(data.equalsIgnoreCase("left")){
			mediaPlayer=MediaPlayer.create(this, musics[1]);
		}
		
		if(mediaPlayer != null){
			mediaPlayer.start();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		mediaPlayer.release();
        stopSelf();
		super.onDestroy();
	}
	
	

}
